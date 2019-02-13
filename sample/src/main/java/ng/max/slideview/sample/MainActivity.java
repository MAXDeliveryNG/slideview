package ng.max.slideview.sample;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import ng.max.slideview.SlideView;
import ng.max.slideview.TwoWaySlideView;
import ng.max.slideview.TwoWaySlider;

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
        ((TwoWaySlideView) findViewById(R.id.twoWaySlideView)).setOnSlideCompleteListener(new TwoWaySlideView.OnTwoWaySlideListener() {
            @Override
            public void onSlideComplete(TwoWaySlideView slideView, TwoWaySlider.SlideDirection slideDirection) {
                if (slideDirection== TwoWaySlider.SlideDirection.END)
                    Toast.makeText(MainActivity.this, "Thank you for accepting", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "did you just decline my offer?", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
