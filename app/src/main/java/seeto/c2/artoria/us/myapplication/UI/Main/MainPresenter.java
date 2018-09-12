package seeto.c2.artoria.us.myapplication.UI.Main;

import android.content.Context;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Model.SimpleProfileModel;

public class MainPresenter implements MainContract.Presenter {
    private Context context;

    public MainPresenter(Context context){
        this.context = context;
    }

    @Override
    public void SimpleProfileRequest(String token) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("token",token);

        new Connector(context).getClient().SimpleProfile(queryContainerBuilder)
                .enqueue(new Callback<SimpleProfileModel>() {
                    @Override
                    public void onResponse(Call<SimpleProfileModel> call, Response<SimpleProfileModel> response) {

                    }

                    @Override
                    public void onFailure(Call<SimpleProfileModel> call, Throwable t) {

                    }
                });
    }
}
