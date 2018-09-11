package seeto.c2.artoria.us.myapplication.UI.Signin;

import android.content.Context;
import android.util.Log;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Model.TokenModel;
import seeto.c2.artoria.us.myapplication.PreferenceUtil;

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
                            String accessToken = data.getData().getAuth().getAccessToken();
                            String refershToken = data.getData().getAuth().getRefreshToken();
                            PreferenceUtil.getInstance(context).putStringExtra("accessToken", data.getData().getAuth().getAccessToken());
                            PreferenceUtil.getInstance(context).putStringExtra("refreshToken",data.getData().getAuth().getRefreshToken());
                            Log.d("DEBUG", "success");
                            Log.d("DEBUG", String.valueOf(response.code()));
                            Log.d("DEBUG", response.message());
                            Log.d("DEBUG", PreferenceUtil.getInstance(context).getStringExtra("accessToken"));

                        } else {
                            Log.d("DEBUG",response.message());
                            Log.d("DEBUG", "failed");
                            Log.d("DEBUG", String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<TokenModel> call, Throwable t) {
                        Log.d("DEBUG", "network_failed");
                    }
                });
    }
}
