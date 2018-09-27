package seeto.c2.artoria.us.myapplication.UI.Ideas;

import android.annotation.SuppressLint;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import seeto.c2.artoria.us.myapplication.Adapter.CommentRecyclerAdapter;
import seeto.c2.artoria.us.myapplication.Connect.Connector;
import seeto.c2.artoria.us.myapplication.Item.CommentItem;
import seeto.c2.artoria.us.myapplication.Model.IdeasDetailModel;
import seeto.c2.artoria.us.myapplication.Model.NewCommentModel;
import seeto.c2.artoria.us.myapplication.R;
import seeto.c2.artoria.us.myapplication.SharedPreferenceKt;

public class IdeasViewDetailActivity extends AppCompatActivity{

    boolean like_flag = false;
    TextView title, body , createdAt;
    RecyclerView comment_list;
    CommentRecyclerAdapter adapter;
    ArrayList<CommentItem> list_data = new ArrayList<>();
    EditText comment_input;
    ImageView comment_send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas_view_details);

        title = findViewById(R.id.ideas_detail_title);
        body = findViewById(R.id.ideas_detail_content);
        createdAt = findViewById(R.id.ideas_detail_date_text);
        comment_list = findViewById(R.id.ideas_detail_comment_list);
        comment_input = findViewById(R.id.ideas_detail_comment_input);
        comment_send = findViewById(R.id.ideas_detail_comment_sendbtn);

        getIdeasDetail(getIntent().getStringExtra("id"), SharedPreferenceKt.getToken(this,true));

        ImageView like_btn = findViewById(R.id.ideas_detail_like);
        like_btn.setOnClickListener(v -> {
            if(!like_flag){
                like_flag = true;
                like_btn.setImageResource(R.drawable.outline_favorite_check_border_24px);
                Toast.makeText(this, "이 게시물에 좋아요를 표시했습니다.", Toast.LENGTH_SHORT).show();
            } else {
                like_flag = false;
                like_btn.setImageResource(R.drawable.outline_favorite_border_24px);
                Toast.makeText(this, "이 게시물에 좋아요를 취소했습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        comment_list.setLayoutManager(new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        comment_send.setOnClickListener(view -> {
            String content = comment_input.getText().toString();

            NewCommentRequest(content,getIntent().getStringExtra("id"),SharedPreferenceKt.getToken(this,true));
            list_data.clear();
            getIdeasDetail(getIntent().getStringExtra("id"),SharedPreferenceKt.getToken(this,true));

//            list_data.add(new CommentItem("asdf",content));
//            adapter = new CommentRecyclerAdapter(list_data);
//            comment_list.setAdapter(adapter);

            comment_input.setText("");
            Toast.makeText(this, "댓글이 성공적으로 작성되었습니다.", Toast.LENGTH_SHORT).show();

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(comment_input.getWindowToken(),0);
        });


    }

    public void NewCommentRequest(String content, String id, String token) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("comment",content)
                .putVariable("id",id)
                .putVariable("token",token);

        new Connector(this).getClient().NewComment(queryContainerBuilder)
                .enqueue(new Callback<NewCommentModel>() {
                    @Override
                    public void onResponse(Call<NewCommentModel> call, Response<NewCommentModel> response) {
                        NewCommentModel data = response.body();
                        if(data.getData().getNewcomment().getResult().getSuccess()){
                            Log.d("DEBUG",data.getData().getNewcomment().getResult().getMessage());
                        } else {
                            Log.d("DEBUG","failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<NewCommentModel> call, Throwable t) {
                            Log.d("DEBUG","network_failed");
                    }
                });
    }

    public void getIdeasDetail(String id, String token) {
        QueryContainerBuilder queryContainerBuilder = new QueryContainerBuilder()
                .putVariable("token",token)
                .putVariable("view",id);

        new Connector(this).getClient().IdeasDetail(queryContainerBuilder)
                .enqueue(new Callback<IdeasDetailModel>() {
                    @Override
                    public void onResponse(Call<IdeasDetailModel> call, Response<IdeasDetailModel> response) {
                       if(response.body() != null) {
                           IdeasDetailModel data = response.body();

                           for (int i = 0; i < data.getData().getIdeas().size(); i++) {
//                               Log.d("DEBUG", data.getData().getIdeas().get(i).getTitle());
//                               Log.d("DEBUG", data.getData().getIdeas().get(i).getBody());
//                               Log.d("DEBUG", data.getData().getIdeas().get(i).getCreatedAt());

                               String date = data.getData().getIdeas().get(i).getCreatedAt();
                               String split_date = date.substring(0,10);

                               title.setText(data.getData().getIdeas().get(i).getTitle());
                               body.setText(data.getData().getIdeas().get(i).getBody());
                               createdAt.setText(split_date);

                               for (int j = 0; j < data.getData().getIdeas().get(i).getComment().size(); j++){
                                   if (data.getData().getIdeas().get(i).getComment() != null) {

                                       list_data.add(new CommentItem(data.getData().getIdeas().get(i).getComment().get(j).getAuthor(),
                                               data.getData().getIdeas().get(i).getComment().get(j).getBody()));

                                   } else {
                                       Log.d("DEBUG","comment_null");
                                       break;
                                   }
                               }

                           }

                           adapter = new CommentRecyclerAdapter(list_data);
                           comment_list.setAdapter(adapter);

                       } else {
                           Log.d("DEBUG","res_null");
                       }
                    }

                    @Override
                    public void onFailure(Call<IdeasDetailModel> call, Throwable t) {
                           Log.d("DEBUG","network_failed");
                    }
                });
    }
}
