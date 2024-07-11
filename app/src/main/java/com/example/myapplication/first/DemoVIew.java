package com.example.myapplication.first;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DemoVIew extends View {
    private  int lastX;
    private  int lastY;
    public DemoVIew(Context context) {
        super(context);
    }

    public DemoVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DemoVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    public boolean onTouchEvent(MotionEvent event){
        int x=(int) event.getX();
        int y=(int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX=x;
                lastY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX=x-lastX;
                int offsetY=y-lastY;
                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                break;
        }
        return true;
    }


}