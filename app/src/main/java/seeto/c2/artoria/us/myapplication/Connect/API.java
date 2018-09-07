package seeto.c2.artoria.us.myapplication.Connect;

import com.ramkishorevs.graphqlconverter.converter.GraphQuery;
import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {

    @POST("/graphql")
    @GraphQuery("register")
    Call<Void> Register(@Body QueryContainerBuilder queryContainerBuilder);


}
