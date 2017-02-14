package ng.max.slideview.sample;

import android.os.Bundle;
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
                slideView.setEnabled(false);
                slideView.setText("Disabled");
            }
        });
    }
}
