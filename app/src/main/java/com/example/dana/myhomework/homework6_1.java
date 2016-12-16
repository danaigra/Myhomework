package com.example.dana.myhomework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SnapHelper;
import android.util.AttributeSet;
import android.view.View;

public class homework6_1 extends View{
    private Paint paint=new Paint();
    private ShapeDrawable circle_bg, circle_border;

    private void init() {
        paint.setColor(0xff_00_00_ff);
    }

    public homework6_1(Context context) {
        super(context);
        init();
    }

    public homework6_1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public homework6_1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawLine(0,0,0,100,paint);
        canvas.drawLine(0,50,50,50,paint);
        canvas.drawLine(50,0,50,100,paint);
        canvas.drawLine(70,0,70,100,paint);
        canvas.drawLine(70,0,120,0,paint);
        canvas.drawLine(70,50,120,50,paint);
        canvas.drawLine(70,100,120,100,paint);
        canvas.drawLine(140,0,140,100,paint);
        canvas.drawLine(140,100,190,100,paint);
        canvas.drawLine(210,0,210,100,paint);
        canvas.drawLine(210,100,260,100,paint);
        circle_bg=new ShapeDrawable(new OvalShape());
        circle_bg.getPaint().setColor(0xff_ff_ff_ff);
        circle_bg.setBounds(272,2,318,98);
        circle_border=new ShapeDrawable(new OvalShape());
        circle_bg.getPaint().setColor(0xff_ff_ff_00);
        circle_border.setBounds(270,0,320,100);
        circle_border.draw(canvas);
        circle_bg.draw(canvas);
        super.onDraw(canvas);
    }
}
