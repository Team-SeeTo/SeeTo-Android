package seeto.c2.artoria.us.myapplication.UI.Signup;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.UI.Signin.SigninActivity;

public class SignupPresenter implements SignupContract.Presenter{
    private Context context;

    public SignupPresenter(Context context){
        this.context = context;
    }

    @Override
    public void SignupRequest(String id, String username, String password) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("email",id)
                .putVariable("username",username)
                .putVariable("password",password);

        new Connector(context).getClient().Register(queryContainerBuilder)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()){
                            Log.d("DEBUG","success");
                            Log.d("DEBUG",response.message());
                            Log.d("DEBUG", String.valueOf(response.code()));
                            Intent intent = new Intent(context, SigninActivity.class);
                            context.startActivity(intent);
                            Toast.makeText(context, "성공적으로 회원가입되었습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.d("DEBUG",response.message());
                            Log.d("DEBUG","failed");
                            Log.d("DEBUG", String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                            Log.d("DEBUG","network_failed");
                    }
                });
    }
}
