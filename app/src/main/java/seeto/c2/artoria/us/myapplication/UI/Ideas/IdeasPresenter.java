package seeto.c2.artoria.us.myapplication.UI.Ideas;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Item.IdeasItem;
import seeto.c2.artoria.us.myapplication.Model.IdeasMainModel;
import seeto.c2.artoria.us.myapplication.Model.IdeasSearchModel;
import seeto.c2.artoria.us.myapplication.Model.NewIdeasModel;
import seeto.c2.artoria.us.myapplication.UI.Main.MainActivity;

public class IdeasPresenter implements IdeasContract.Presenter {
    private Context context;
    QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder();


    public IdeasPresenter(Context context){
        this.context = context;
    }

    @Override
    public void SearchRequest(String token, String search_string, String filterBy, int startRank) {
                queryContainerBuilder
                .putVariable("token",token)
                .putVariable("searchString",search_string)
                .putVariable("filterBy",filterBy)
                .putVariable("startRank",startRank);

        new Connector(context).getClient().IdeasSearch(queryContainerBuilder)
                .enqueue(new Callback<IdeasSearchModel>() {
                    @Override
                    public void onResponse(Call<IdeasSearchModel> call, Response<IdeasSearchModel> response) {
                        if (response.isSuccessful()){
                            IdeasSearchModel data = response.body();

                            ArrayList<IdeasItem> listdata = new ArrayList<>();

                            for (int i = 0; i < response.body().getData().getIdeas().size(); i++) {
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getAuthor());
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getTitle());
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getBody());
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getComments().get(i).getComment_author());
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getComments().get(i).getComment_body());
                                Log.d("DEBUG", String.valueOf(data.getData().getIdeas().get(i).getUpvoter()));

//                                listdata.add(new IdeasItem(data.getData().getIdeas().get(i).getTitle(),
//                                        data.getData().getIdeas().get(i).getBody(),
//                                        "#" + i,
//                                        data.getData().getIdeas().get(i).getComments().get(i).getComment_author(),
//                                        data.getData().getIdeas().get(i).getComments().get(i).getComment_body()));

                            }
                        } else {
                            Log.d("DEBUG","failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<IdeasSearchModel> call, Throwable t) {

                    }
                });

    }

    @Override
    public void NewIdeaRequest(String category, String token, String title, String body) {
                queryContainerBuilder
                .putVariable("category",category)
                .putVariable("token",token)
                .putVariable("title",title)
                .putVariable("body",body);


        new Connector(context).getClient().NewIdea(queryContainerBuilder)
                .enqueue(new Callback<NewIdeasModel>() {
                    @Override
                    public void onResponse(Call<NewIdeasModel> call, Response<NewIdeasModel> response) {
                        if(response.body().getData().getNewIdea().getResult().getSuccess()){
                            Log.d("DEBUG", response.body().getData().getNewIdea().getResult().getMessage());
                            Log.d("DEBUG","success");
                            Log.d("DEBUG", String.valueOf(response.code()));


                            Toast.makeText(context, "작성이 성공적으로 완료되었습니다", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                        } else {
                            Log.d("DEBUG", String.valueOf(response.code()));
                            Log.d("DEBUG","failed");
                        }

                    }

                    @Override
                    public void onFailure(Call<NewIdeasModel> call, Throwable t) {
                            Log.d("DEBUG","network_failed");
                    }
                });
    }
}
