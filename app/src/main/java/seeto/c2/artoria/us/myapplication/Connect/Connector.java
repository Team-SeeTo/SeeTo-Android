package seeto.c2.artoria.us.myapplication.Connect;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.ramkishorevs.graphqlconverter.converter.GraphQLConverter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connector{
    private Retrofit retrofit;
    private API api;
    private String url = "https://seeto.herokuapp.com/";
    private Context context;

    public Connector(Context context) {
        this.context = context;
    }


    public API getClient(){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GraphQLConverter.create(context))
                    .baseUrl(url)
                    .build();

            api = retrofit.create(API.class);

        return api;
    }
}
