package com.example.zhexiantu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author：lenovo
 * @Date：2019/4/24 19:27
 * @Description：描述信息
 */
public class LinView extends View {

    private Paint mLinePaint;
    private  int textSize=20;
    private Path mPath;
    private int startX=100;
    private int startY=800;

    public LinView(Context context) {
        super(context);
    }

    public LinView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

        private void init(){
        mLinePaint=new Paint();
        mLinePaint.setColor(Color.RED);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setTextSize(textSize);
        mLinePaint.setStrokeWidth(2);
            mPath=new Path();
            mPath.moveTo(100,800);

        }
    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawPath(mPath,mLinePaint);

      canvas.drawLine(startX,startY,800,startY,mLinePaint);//画X轴  左上右下
      canvas.drawLine(startX,startY,startX,100,mLinePaint);//画Y轴     左上右下

        canvas.drawText("0",100-mLinePaint.measureText("0")-20,800+textSize,mLinePaint);
        for (int i=100;i<=600;i+=100) {
            String text=i+"";
            float textWidth=mLinePaint.measureText(text);
            canvas.drawText(text,startX+i-textWidth/2,startY+textSize,mLinePaint);//X轴坐标
            canvas.drawText(text,startX-textWidth,startY-i+textWidth/2,mLinePaint);//Y轴坐标
        }
    }
    public void addPoi(int x, int y) {
        mPath.lineTo(startX+x,startY-y);
        invalidate();
    }
}
