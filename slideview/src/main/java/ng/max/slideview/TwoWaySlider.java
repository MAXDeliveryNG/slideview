package ng.max.slideview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class TwoWaySlider extends AppCompatSeekBar {

    private Drawable thumb;
    private TwoWaySlideView.OnTwoWaySlideListener listener;
    private TwoWaySlideView slideView;

    public TwoWaySlider(Context context, AttributeSet attrs) {

        super(context, attrs);
        setProgress(50);
    }

    @Override
    public void setThumb(Drawable thumb) {
        this.thumb = thumb;
        super.setThumb(thumb);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (thumb.getBounds().contains((int) event.getX(), (int) event.getY())) {
                // This fixes an issue where the parent view (e.g ScrollView) receives
                // touch events along with the SlideView
                getParent().requestDisallowInterceptTouchEvent(true);
                super.onTouchEvent(event);
            } else {
                return false;
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (getProgress() > 90) {

                if (listener != null) listener.onSlideComplete(slideView, SlideDirection.END);
            }
            if (getProgress() < 10) {
                if (listener != null) listener.onSlideComplete(slideView, SlideDirection.START);

            }
            getParent().requestDisallowInterceptTouchEvent(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                setProgress(50, true);
            } else
                setProgress(50);
        } else
            super.onTouchEvent(event);

        return true;
    }

    void setOnSlideCompleteListenerInternal(TwoWaySlideView.OnTwoWaySlideListener listener, TwoWaySlideView slideView) {
        this.listener = listener;
        this.slideView = slideView;
    }

    @Override
    public Drawable getThumb() {
        // getThumb method was added in SDK 16 but our minSDK is 14
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return super.getThumb();
        } else {
            return thumb;
        }
    }

   public enum SlideDirection {
        END, START
    }
}
