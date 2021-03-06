package seeto.c2.artoria.us.myapplication.UI.Signin;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Model.TokenModel;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;
import seeto.c2.artoria.us.myapplication.UI.Main.MainActivity;

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
                        if(response.isSuccessful()){
                            TokenModel data = response.body();
                            if(data.getData().getAuth().getResult().getAccessToken() != null){

                                SharedPreferenceKt.saveToken(context,data.getData().getAuth().getResult().getAccessToken(),true);
                                SharedPreferenceKt.saveToken(context,data.getData().getAuth().getResult().getRefreshToken(),false);

                                Intent intent = new Intent(context, MainActivity.class);
                                context.startActivity(intent);
                            } else {
                                Log.d("DEBUG","token_null");
                            }
                        } else {
                            Log.d("DEBUG",response.message());
                            Log.d("DEBUG", "failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<TokenModel> call, Throwable t) {
                        Log.d("login", "network_failed");
                        Log.d("login", String.valueOf(t));
                    }
                });
    }
}
