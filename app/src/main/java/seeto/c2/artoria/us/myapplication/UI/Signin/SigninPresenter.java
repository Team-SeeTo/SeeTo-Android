package seeto.c2.artoria.us.myapplication.UI.Signin;

import android.content.Context;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Model.TokenModel;

public class SigninPresenter implements SigninContract.Presenter {
    private Context context;

    public SigninPresenter(Context context){
        this.context = context;
    }


    @Override
    public void SigninRequest(String email, String password) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("email", email)
                .putVariable("password", password);

        new Connector(context).getClient().Signin(queryContainerBuilder)
                .enqueue(new Callback<TokenModel>() {
                    @Override
                    public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {

                    }

                    @Override
                    public void onFailure(Call<TokenModel> call, Throwable t) {

                    }
                });
    }
}
