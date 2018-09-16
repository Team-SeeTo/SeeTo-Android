package seeto.c2.artoria.us.myapplication.UI.Ideas;

import android.content.Context;
import android.util.Log;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Item.IdeasItem;
import seeto.c2.artoria.us.myapplication.Model.IdeasMainModel;

public class IdeasPresenter implements IdeasContract.Presenter {
    private Context context;

    public IdeasPresenter(Context context){
        this.context = context;
    }

    @Override
    public void getListDataRequest(String token, String filterBy, int startRank) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("token",token)
                .putVariable("filterBy",filterBy)
                .putVariable("startRank",startRank);

        new Connector(context).getClient().IdeasMain(queryContainerBuilder)
                .enqueue(new Callback<IdeasMainModel>() {
                    @Override
                    public void onResponse(Call<IdeasMainModel> call, Response<IdeasMainModel> response) {
                        if (response.isSuccessful()){
                            IdeasMainModel data = response.body();

                            ArrayList<IdeasItem> listdata = new ArrayList<>();

                            for (int i = 0; i < response.body().getData().getIdeas().size(); i++) {
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getAuthor());
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getTitle());
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getBody());
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getComments().get(i).getComment_author());
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getComments().get(i).getComment_body());
                                Log.d("DEBUG", data.getData().getIdeas().get(i).getUpvoter().get(i));

                                listdata.add(new IdeasItem(data.getData().getIdeas().get(i).getTitle(),
                                        data.getData().getIdeas().get(i).getBody(),
                                        "#" + i,
                                        data.getData().getIdeas().get(i).getComments().get(i).getComment_author(),
                                        data.getData().getIdeas().get(i).getComments().get(i).getComment_body()));

                            }
                        } else {
                            Log.d("DEBUG","failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<IdeasMainModel> call, Throwable t) {

                    }
                });

    }
}
