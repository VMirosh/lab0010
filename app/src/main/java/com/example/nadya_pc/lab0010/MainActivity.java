package com.example.nadya_pc.lab0010;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class MainActivity extends Activity implements View.OnTouchListener {

    Paint p;
    int mywidth=0, myheight=0;
    float x,y;
    int n=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pp=new painter(this);
        setContentView(pp);
        pp.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();
        pp.invalidate();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                n++;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

    class painter extends View {
        public painter(Context context) {
            super(context);
            p = new Paint();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            mywidth = w;
            myheight = h;
            super.onSizeChanged(w, h, oldw, oldh);
        }


        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            int Val1=100,Val2=200;
            int Val3 = 0, Val4 = 100;
            int Val5 = 100,Val6 = 200;
            int num=1;
            while(Val1<(myheight-300)) {
                while (Val3 < mywidth) {
                    p.setColor(Color.DKGRAY);
                    canvas.drawRect(Val3, Val1, Val4, Val2, p);
                    Val3 = Val3 + 200;
                    Val4 = Val4 + 200;
                }
                while (Val5 < mywidth) {
                    p.setColor(Color.GREEN);
                    canvas.drawRect(Val5, Val1, Val6, Val2, p);
                    Val5 = Val5 + 200;
                    Val6 = Val6 + 200;
                }
                Val1 = Val1 +  100;
                Val2 = Val2 +  100;
                num++;
                if(num%2==0) {
                    Val3 = 100;
                    Val4 = 200;
                    Val5 = 0;
                    Val6= 100;
                }else{
                    Val3=0;
                    Val4=100;
                    Val5=100;
                    Val6=200;
                }

            }
            p.setTextSize(50);
            p.setTextAlign(Paint.Align.CENTER);
            int val1=Math.round(x);
            int val2=Math.round(y);
            int alpha = myheight-(myheight%100)-200;
            int bravo = mywidth-(mywidth%100);
            int charly = myheight - 100;
            int delta = mywidth - (mywidth / 2);
            if(val2==0 && val1==0) {
                String s = "Размер экрана: " + alpha+ " x " + bravo;
                p.setColor(Color.BLACK);
                canvas.drawText(s, delta, charly, p);
            }
            if(val1>0 && val2>0) {
                invalidate(delta,charly,delta,charly);
                p.setColor(Color.BLACK);
                String out = val1 + " " + val2 + " число нажатий " + n;
                canvas.drawText(out, delta, charly, p);
            }
        }
    }

    painter pp;
}
