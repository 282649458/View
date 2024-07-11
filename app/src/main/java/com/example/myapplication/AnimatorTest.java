package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnimatorTest extends AppCompatActivity {

    ImageView mImagerView;
    Button mButton,btn_Turn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animator_test);
        Intent intent=new Intent(this,MyselfView.class);
        mImagerView=findViewById(R.id.image_demo);
        mButton=findViewById(R.id.action_image);
        btn_Turn=findViewById(R.id.turn_to_View);
        btn_Turn.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(intent);
            }

        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(mImagerView, "alpha", 1f, 0f, 1f);
                animator.setDuration(2000);

                //动画延迟500ms执行
                animator.setStartDelay(500);

                //执行重复次数 +1
                animator.setRepeatCount(3);

                // 设置动画重复播放模式 RESTART -执行完一遍后重新执行
                // REVERSE -执行完一遍后 从末位置往前执行
                animator.setRepeatMode(ValueAnimator.RESTART);

                //监听值变换
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.i("MainActivity","value：" +animation.getAnimatedValue());
                    }
                });
                animator.start();
            }
        });
    }
}