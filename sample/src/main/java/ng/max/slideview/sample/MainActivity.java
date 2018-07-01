package ng.max.slideview.sample;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ng.max.slideview.SlideView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((SlideView) findViewById(R.id.slider5)).setOnSlideCompleteListener(new SlideView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideView slideView) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                slideView.setEnabled(false);
                slideView.setText("Disabled");
            }
        });
        ((SlideView) findViewById(R.id.slider6)).setOnSlideCompleteListener(new SlideView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideView slideView) {
               if (slideView.isReversed()) {
                   slideView.setReversed(false);
                   slideView.setText("Normal");
                   final int color = ContextCompat.getColor(slideView.getContext(), R.color.colorAccent);
                   ((TextView) findViewById(R.id.reverseText)).setTextColor(color);
                   slideView.setButtonBackgroundColor(color);
                   slideView.setTextColor(color);
                   slideView.setStokeColor(color);
               } else {
                   slideView.setReversed(true);
                   slideView.setText("Reversed");
                   final int color = ContextCompat.getColor(slideView.getContext(), R.color.colorPrimary);
                   ((TextView) findViewById(R.id.reverseText)).setTextColor(color);
                   slideView.setButtonBackgroundColor(color);
                   slideView.setTextColor(color);
                   slideView.setStokeColor(color);
               }
            }
        });
    }
}
