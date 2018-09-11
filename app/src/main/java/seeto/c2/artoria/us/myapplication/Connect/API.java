package seeto.c2.artoria.us.myapplication.Connect;

import com.ramkishorevs.graphqlconverter.converter.GraphQuery;
import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import seeto.c2.artoria.us.myapplication.Model.TokenModel;


public interface API {

    @POST("/graphql")
    @GraphQuery("register")
    Call<Void> Register(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("login")
    Call<TokenModel> Signin(@Body QueryContainerBuilder queryContainerBuilder);

}
