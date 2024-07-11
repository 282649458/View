package com.example.myapplication.Scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;


public class ViewDemo extends View {
    Scroller mScroller;


    public ViewDemo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
         mScroller = new Scroller(context);

    }
    @Override
    public void computeScroll(){
        super.computeScroll();
        if (mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }
    public void smoothScrollTo(int destX,int destY){
        int scrollX=getScrollX();
        int delta=destX-scrollX;
        mScroller.startScroll(scrollX,0,delta,0,20000);
        invalidate();
    }
}