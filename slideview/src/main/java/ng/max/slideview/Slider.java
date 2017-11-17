package ng.max.slideview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class Slider extends AppCompatSeekBar {

    private Drawable thumb;
    private SlideView.OnSlideCompleteListener listener;
    private SlideView slideView;

    public Slider(Context context, AttributeSet attrs) {
        super(context, attrs);
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
            if (getProgress() > 85) {
                if (listener != null) listener.onSlideComplete(slideView);
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            setProgress(0);
        } else
            super.onTouchEvent(event);

        return true;
    }

    void setOnSlideCompleteListenerInternal(SlideView.OnSlideCompleteListener listener, SlideView slideView) {
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
}
