package seeto.c2.artoria.us.myapplication.Connect;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.ramkishorevs.graphqlconverter.converter.GraphQLConverter;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class Connector{
    private Retrofit retrofit;
    private API api;
    private String url = "http://seeto.services/";
    private Context context;

    public Connector(Context context) {
        this.context = context;
    }


    public API getClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GraphQLConverter.create(context))
                    .baseUrl(url)
                    .client(client)
                    .build();

            api = retrofit.create(API.class);

        return api;
    }
}
