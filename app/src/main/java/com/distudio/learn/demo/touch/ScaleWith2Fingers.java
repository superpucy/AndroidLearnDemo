package com.distudio.learn.demo.touch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.Toast;

import com.distudio.learn.demo.R;

public class ScaleWith2Fingers extends android.support.v7.widget.AppCompatImageView{
    private Drawable mIcon;
    private ScaleGestureDetector mScaleDetector;
    private float mScaleFactor = 1.f;

    public ScaleWith2Fingers(Context context) {
        this(context, null, 0);
    }

    public ScaleWith2Fingers(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleWith2Fingers(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mIcon = context.getResources().getDrawable(R.drawable.duran);
        mIcon.setBounds(0, 0, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.scale(mScaleFactor, mScaleFactor);
        mIcon.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Let the ScaleGestureDetector inspect all events.
        mScaleDetector.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();

            // Don't let the object get too small or too large.
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));

            //重劃onDraw
            invalidate();
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Toast.makeText(getContext(),"onScaleBegin",Toast.LENGTH_SHORT).show();
            return super.onScaleBegin(detector);
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            Toast.makeText(getContext(),"onScaleEnd",Toast.LENGTH_SHORT).show();
            super.onScaleEnd(detector);
        }
    }
}
