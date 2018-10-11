package seeto.c2.artoria.us.myapplication.Connect;

import android.widget.CalendarView;

import com.ramkishorevs.graphqlconverter.converter.GraphQuery;
import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import javax.annotation.PostConstruct;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import seeto.c2.artoria.us.myapplication.Adapter.QMRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Model.IdeasDetailModel;
import seeto.c2.artoria.us.myapplication.Model.IdeasMainModel;
import seeto.c2.artoria.us.myapplication.Model.IdeasSearchModel;
import seeto.c2.artoria.us.myapplication.Model.LeaderBoardModel;
import seeto.c2.artoria.us.myapplication.Model.NewCommentModel;
import seeto.c2.artoria.us.myapplication.Model.NewIdeasModel;
import seeto.c2.artoria.us.myapplication.Model.SimpleProfileModel;
import seeto.c2.artoria.us.myapplication.Model.TimeLineModel;
import seeto.c2.artoria.us.myapplication.Model.TodoMainModel;
import seeto.c2.artoria.us.myapplication.Model.TodoSearchModel;
import seeto.c2.artoria.us.myapplication.Model.TokenModel;


public interface API {

    @POST("/graphql")
    @GraphQuery("register")
    Call<Void> Register(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("login")
    Call<TokenModel> Signin(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("simple_profile")
    Call<SimpleProfileModel> SimpleProfile(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("ideas_main")
    Call<IdeasMainModel> IdeasMain(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("todo_main")
    Call<TodoMainModel> TodoMain(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("ideas_search")
    Call<IdeasMainModel> IdeasSearch(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("ideas_filter")
    Call<IdeasMainModel> IdeasFilter(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("todo_search")
    Call<TodoSearchModel> TodoSearch(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("timeline_main")
    Call<TimeLineModel> TimelineMain(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("new_idea")
    Call<NewIdeasModel> NewIdea(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("ideas_view_detail")
    Call<IdeasDetailModel> IdeasDetail(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("new_comment")
    Call<NewCommentModel> NewComment(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("ideas_vote")
    Call<Void> Vote(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("new_todo")
    Call<Void> NewTODO(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("complete_milestone")
    Call<Void> CompleteMilestone(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("todo_edit")
    Call<Void> TodoEdit(@Body QueryContainerBuilder queryContainerBuilder);

    @POST("/graphql")
    @GraphQuery("leaderboard_main")
    Call<LeaderBoardModel> LeaderBoardMain(@Body QueryContainerBuilder queryContainerBuilder);
}
