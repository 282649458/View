package com.example.myapplication.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class FromView extends View {
    private Paint mPaint=new Paint();
    private int mColor=Color.RED;
    public FromView(Context context) {
        super(context);
        initDraw();
    }

    public FromView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.FromView);
        mColor=typedArray.getColor(R.styleable.FromView_view_color, Color.RED);
        typedArray.recycle();
        initDraw();
    }

    public FromView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw();
    }
    private void initDraw(){
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth((float) 1.5);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode =MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode=MeasureSpec.getMode(heightMeasureSpec);
        int widthSpecSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize=MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode==MeasureSpec.AT_MOST&&heightSpecMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(600,600);
        }
        else if (widthSpecMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(600,heightSpecSize);
        }
        else if (heightSpecMode==MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize,600);
        }
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int paddingLeft=getPaddingLeft();
        int paddingTop=getPaddingTop();
        int paddingRight=getPaddingRight();
        int paddingBottom=getPaddingBottom();
        int width=getWidth()-paddingLeft-paddingRight;
        int height=getHeight()-paddingTop-paddingBottom;
        canvas.drawRect(0+paddingLeft,0+paddingTop,width+paddingLeft,height+paddingTop,mPaint);
    }
}
