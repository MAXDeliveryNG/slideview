package ng.max.slideview.sample;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
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
               if (slideView.isReverse()) {
                   slideView.setReversed(false);
                   slideView.setText("Accept");
                   slideView.setButtonBackgroundColor(ContextCompat.getColor(slideView.getContext(),R.color.colorAccent));
                   slideView.setTextColor(ContextCompat.getColor(slideView.getContext(),R.color.colorAccent));
                   slideView.setStokeColor(ContextCompat.getColor(slideView.getContext(),R.color.colorAccent));
               } else {
                   slideView.setReversed(true);
                   slideView.setText("Reverse");
                   slideView.setButtonBackgroundColor(ContextCompat.getColor(slideView.getContext(),R.color.colorPrimary));
                   slideView.setTextColor(ContextCompat.getColor(slideView.getContext(),R.color.colorPrimary));
                   slideView.setStokeColor(ContextCompat.getColor(slideView.getContext(),R.color.colorPrimary));
               }
            }
        });
    }
}
