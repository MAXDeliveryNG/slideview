package ng.max.slideview.sample;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;

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
               if (slideView.getReverseSlide()) {
                   slideView.setReverseSlide(false);
                   slideView.setText("Accept");
                   slideView.setButtonBackgroundColor(getColor(R.color.colorAccent));
                   slideView.setTextColor(getColor(R.color.colorAccent));
                   slideView.setStokeColor(getColor(R.color.colorAccent));
               } else {
                   slideView.setReverseSlide(true);
                   slideView.setText("Reverse");
                   slideView.setButtonBackgroundColor(getColor(R.color.colorPrimary));
                   slideView.setTextColor(getColor(R.color.colorPrimary));
                   slideView.setStokeColor(getColor(R.color.colorPrimary));
               }
            }
        });
    }
}
