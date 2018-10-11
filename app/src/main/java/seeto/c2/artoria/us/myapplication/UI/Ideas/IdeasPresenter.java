package seeto.c2.artoria.us.myapplication.UI.Ideas;

import android.content.Context;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Model.IdeasMainModel;

public class IdeasPresenter implements IdeasContract.Presenter {
    private Context context;

    public IdeasPresenter(Context context){
        this.context = context;
    }

    @Override
    public void getListDataRequest(String token, String filterBy, String startRank) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder();

        new Connector(context).getClient().IdeasMain(queryContainerBuilder)
                .enqueue(new Callback<IdeasMainModel>() {
                    @Override
                    public void onResponse(Call<IdeasMainModel> call, Response<IdeasMainModel> response) {

                    }

                    @Override
                    public void onFailure(Call<IdeasMainModel> call, Throwable t) {

                    }
                });

    }
}