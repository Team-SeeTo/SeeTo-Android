package seeto.c2.artoria.us.myapplication.Ideas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import seeto.c2.artoria.us.myapplication.R;

public class IdeasViewDetailActivity extends AppCompatActivity{

    boolean like_flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas_view_details);

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
    }
}
