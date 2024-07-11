package com.example.myapplication.Animator;

import android.animation.ObjectAnimator;
import android.view.View;

public class MyView {
    private View mTarget;
    private MyView(View mTarget){
        this.mTarget=mTarget;
    }
    public int getWidth(){
        return mTarget.getLayoutParams().width;
    }
    public void setWidth(int width){
        mTarget.getLayoutParams().width=width;
        mTarget.requestLayout();
    }

}
