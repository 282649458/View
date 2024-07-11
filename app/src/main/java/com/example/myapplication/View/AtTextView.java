package com.example.myapplication.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;



public class AtTextView extends androidx.appcompat.widget.AppCompatTextView {
    private Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    public AtTextView(Context context){
        super(context);
        initDraw();
    }

    public AtTextView( Context context,  AttributeSet attrs) {
        super(context, attrs);
        initDraw();
    }
    private void initDraw(){
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth((float) 1.5);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int width=getWidth();
        int height=getHeight();
        canvas.drawRect(0,0,width,height,paint);
    }
}

