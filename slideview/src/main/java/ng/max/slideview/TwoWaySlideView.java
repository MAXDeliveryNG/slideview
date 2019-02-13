package ng.max.slideview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import static ng.max.slideview.Util.spToPx;

/**
 * @author Kizito Nwose
 */

public class TwoWaySlideView extends RelativeLayout implements SeekBar.OnSeekBarChangeListener {

    protected TwoWaySlider slider;
    protected Drawable slideBackground;
    protected Drawable buttonBackground;
    protected Drawable buttonImage;
    protected Drawable buttonImageDisabled;
    protected TextView slideEndTextView;
    protected TextView slideStartTextView;
    protected LayerDrawable buttonLayers;
    protected ColorStateList slideBackgroundColor;
    protected ColorStateList buttonBackgroundColor;
    protected boolean animateSlideText;

    public TwoWaySlideView(Context context) {
        super(context);
        init(null, 0);
    }

    public TwoWaySlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public TwoWaySlideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TwoWaySlideView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr);
    }

    void init(AttributeSet attrs, int defStyle) {
        inflate(getContext(), R.layout.sv_two_way_slide_view, this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(ContextCompat.getDrawable(getContext(), R.drawable.sv_view_bg));
        } else {
            setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.sv_view_bg));
        }
        slideEndTextView = findViewById(R.id.sv_text_end);
        slideStartTextView = findViewById(R.id.sv_text_start);
        slider = findViewById(R.id.sv_slider);
        slider.setOnSeekBarChangeListener(this);
        slideBackground = getBackground();
        buttonLayers = (LayerDrawable) slider.getThumb();

        buttonBackground = buttonLayers.findDrawableByLayerId(R.id.buttonBackground);

        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.TwoWaySlideView,
                defStyle, defStyle);

        int strokeColor;
        float slideEndTextSize = spToPx(16, getContext());
        float slideStartTextSize = spToPx(16, getContext());
        String slideEndText;
        String slideStartText;

        ColorStateList sliderEndTextColor;
        ColorStateList sliderStartTextColor;
        try {
            animateSlideText = a.getBoolean(R.styleable.TwoWaySlideView_tsv_animateSlideText, true);
            strokeColor = a.getColor(R.styleable.TwoWaySlideView_tsv_strokeColor, ContextCompat.
                    getColor(getContext(), R.color.sv_stroke_color_default));


            slideEndText = a.getString(R.styleable.TwoWaySlideView_tsv_slideEndText);
            slideStartText = a.getString(R.styleable.TwoWaySlideView_tsv_slideStartText);

            sliderEndTextColor = a.getColorStateList(R.styleable.TwoWaySlideView_tsv_slideEndTextColor);
            sliderStartTextColor = a.getColorStateList(R.styleable.TwoWaySlideView_tsv_slideStartTextColor);

            slideEndTextSize = a.getDimension(R.styleable.TwoWaySlideView_tsv_slideEndTextSize, slideEndTextSize);
            slideStartTextSize = a.getDimension(R.styleable.TwoWaySlideView_tsv_slideStartTextSize, slideStartTextSize);
            slideEndTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, slideEndTextSize);
            slideStartTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, slideStartTextSize);

            setEndText(slideEndText);
            setStartText(slideStartText);
            setEndTextColor(sliderEndTextColor == null ? slideEndTextView.getTextColors() : sliderEndTextColor);
            setStartTextColor(sliderStartTextColor == null ? slideStartTextView.getTextColors() : sliderStartTextColor);
            int buttonImageId = a.getResourceId(R.styleable.TwoWaySlideView_tsv_buttonImage, R.drawable.sv_ic_chevron_double_right);
            setButtonImage(ContextCompat.getDrawable(getContext(), buttonImageId));
            setButtonImageDisabled(ContextCompat.getDrawable(getContext(), a.getResourceId
                    (R.styleable.TwoWaySlideView_tsv_buttonImageDisabled, buttonImageId)));

            setButtonBackgroundColor(a.getColorStateList(R.styleable.TwoWaySlideView_tsv_buttonBackgroundColor));
            setSlideBackgroundColor(a.getColorStateList(R.styleable.TwoWaySlideView_tsv_slideBackgroundColor));

            if (a.hasValue(R.styleable.TwoWaySlideView_tsv_strokeColor)) {
                Util.setDrawableStroke(slideBackground, strokeColor);
            }
        } finally {
            a.recycle();
        }
    }

    private void setStartTextColor(ColorStateList colors) {
        slideStartTextView.setTextColor(colors);
    }

    private void setStartText(String slideStartText) {
        slideStartTextView.setText(slideStartText);
    }

    public void setStartTextColor(@ColorInt int color) {
        slideStartTextView.setTextColor(color);
    }

    public void setEndTextColor(ColorStateList colors) {
        slideEndTextView.setTextColor(colors);
    }

    public void setEndText(CharSequence text) {
        slideEndTextView.setText(text);
    }


    public void setTextSize(int size) {
        slideEndTextView.setTextSize(size);
    }

    public TextView getTextView() {
        return slideEndTextView;
    }

    public void setButtonImage(Drawable image) {
        buttonImage = image;
        buttonLayers.setDrawableByLayerId(R.id.buttonImage, image);
    }

    public void setButtonImageDisabled(Drawable image) {
        buttonImageDisabled = image;
    }


    public void setButtonBackgroundColor(ColorStateList color) {
        buttonBackgroundColor = color;
        Util.setDrawableColor(buttonBackground, color.getDefaultColor());
    }


    public void setSlideBackgroundColor(ColorStateList color) {
        slideBackgroundColor = color;
        Util.setDrawableColor(slideBackground, color.getDefaultColor());
    }

    public TwoWaySlider getSlider() {
        return slider;
    }

    public void setOnSlideCompleteListener(OnTwoWaySlideListener listener) {
        slider.setOnSlideCompleteListenerInternal(listener, this);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setEnabled(enabled);
        }
        buttonLayers.setDrawableByLayerId(R.id.buttonImage, enabled ? buttonImage :
                buttonImageDisabled == null ? buttonImage : buttonImageDisabled);
        Util.setDrawableColor(buttonBackground, buttonBackgroundColor.getColorForState(
                enabled ? new int[]{android.R.attr.state_enabled} : new int[]{-android.R.attr.state_enabled}
                , ContextCompat.getColor(getContext(), R.color.sv_button_color_default)));
        Util.setDrawableColor(slideBackground, slideBackgroundColor.getColorForState(
                enabled ? new int[]{android.R.attr.state_enabled} : new int[]{-android.R.attr.state_enabled}
                , ContextCompat.getColor(getContext(), R.color.sv_button_color_default)));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (animateSlideText) {
            if (!fromUser){
                slideEndTextView.setAlpha(1f);
                slideStartTextView.setAlpha(1f );
                return;
            }
            float alpha = (1 - (progress / 100f));
            slideEndTextView.setAlpha(alpha);
            slideStartTextView.setAlpha(1f - alpha);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    public interface OnTwoWaySlideListener {
        void onSlideComplete(TwoWaySlideView slideView, TwoWaySlider.SlideDirection slideDirection);
    }
}
