package com.distudio.learn.demo.touch;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.distudio.learn.demo.R;


public class RotateWith2Fingers  extends android.support.v7.widget.AppCompatImageView{
    private Drawable mIcon;

    private float newRot = 0f;
    private float d = 0f;
    private float r = 0f;

    public RotateWith2Fingers(Context context) {
        this(context, null, 0);
    }

    public RotateWith2Fingers(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotateWith2Fingers(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mIcon = context.getResources().getDrawable(R.drawable.duran);
        mIcon.setBounds(0, 0, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(r);
        mIcon.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        final int action = ev.getAction();
        switch (action & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_POINTER_DOWN: // first and second finger down
                d = rotation(ev);
                break;
            case MotionEvent.ACTION_MOVE: {
                if(ev.getPointerCount() == 2){
                    newRot = rotation(ev);
                    r = newRot - d;
                    invalidate();
                    break;
                }
                break;
            }
        }

        return true;
    }



    private float rotation(MotionEvent event) {
        double delta_x = (event.getX(0) - event.getX(1));
        double delta_y = (event.getY(0) - event.getY(1));
        double radians = Math.atan2(delta_y, delta_x);
        return (float) Math.toDegrees(radians);
    }
}
