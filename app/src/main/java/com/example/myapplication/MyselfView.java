package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.View.TitleBar;

public class MyselfView extends AppCompatActivity {
    private TitleBar titleBar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_myself_view);
        Intent intent=new Intent(this,AnimatorTest.class);
        Intent intent1=new Intent(this,MyselfViewGroup.class);
        titleBar=findViewById(R.id.titleBar);
        titleBar.setTitle("这里是自定义组合控件");
        titleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        titleBar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyselfView.this,"点击右侧的image",Toast.LENGTH_SHORT).show();
                startActivity(intent1);
            }
        });
    }
}