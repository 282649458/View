package com.example.myapplication.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;

public class TitleBar extends RelativeLayout {
    private ImageView titlebar_left,titlebar_right;
    private TextView titlebar_title;
    private RelativeLayout titlebar_trootlayout;
    private int mColor= Color.BLUE;
    private int mTextColor=Color.WHITE;
    private String titleName;
    public TitleBar(Context context) {
        super(context);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.TitleBar);
        mColor=typedArray.getColor(R.styleable.TitleBar_title_bg,Color.BLUE);
        mTextColor=typedArray.getColor(R.styleable.TitleBar_title_color,Color.WHITE);
        titleName=typedArray.getString(R.styleable.TitleBar_title_text);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    public void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.my_title,this,true);
        titlebar_left = findViewById(R.id.titleBar_left);
        titlebar_title=findViewById(R.id.titleBar_title);
        titlebar_right=findViewById(R.id.titleBar_right);
        titlebar_trootlayout=findViewById(R.id.titlebar_rootlayout);
        titlebar_trootlayout.setBackgroundColor(mColor);
        titlebar_title.setTextColor(mTextColor);
        titlebar_title.setText(titleName);
    }
    public void setTitle(String titleName){
        if (!TextUtils.isEmpty(titleName)){
            titlebar_title.setText(titleName);
        }
    }
    public void setLeftListener(OnClickListener onClickListener){
        titlebar_left.setOnClickListener(onClickListener);
    }
    public void setRightListener(OnClickListener onClickListener){
        titlebar_right.setOnClickListener(onClickListener);
    }
}
