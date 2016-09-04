package io.proxylabs.tablegen;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import views.TabletopLayout;

public class MainActivity extends AppCompatActivity {

    TextView sizeTextBox;
    TabletopLayout tabletopLayout;
    float height;
    float width;
    int tableSizeInInches = 48; //TODO This needs to come from the user


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sizeTextBox = (TextView) findViewById(R.id.sizeTextBox);
        tabletopLayout = (TabletopLayout) findViewById(R.id.tabletopLayout);

        tabletopLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tabletopLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                height = tabletopLayout.getHeight();
                width = tabletopLayout.getWidth();

                init();
            }
        });
    }

    public void init(){
        Random rand = new Random();
            int inches = rand.nextInt(tableSizeInInches + 1);
            Log.d("Test", Integer.toString(inches) + " inches selected.");

            float px = convertInchToPx(inches, tableSizeInInches, width);

//            float dp = convertPixelsToDp(px);

//            int dpi = (int) dp;

            int pxi = (int) px;

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(pxi, 0, 0, 0);
        sizeTextBox.setLayoutParams(lp);

    }

    public float convertPixelsToDp(float px){
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public float convertInchToPx(float inch, float inchTotal, float pxTotal){
        float px = (inch * pxTotal) / inchTotal;
        return px;
    }
}
