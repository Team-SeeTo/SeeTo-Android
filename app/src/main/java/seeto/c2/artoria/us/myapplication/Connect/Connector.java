package seeto.c2.artoria.us.myapplication.Connect;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connector {
    private static Retrofit retrofit = null;
    private static API api = null;
    private static String url = "URL here";

    public static API getClient(){
        if(retrofit == null && api == null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(url)
                    .build();

            api = retrofit.create(API.class);
        }
        return api;
    }
}
