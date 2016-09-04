package views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by dbland on 9/2/16.
 */
public class TabletopLayout extends RelativeLayout {

    public TabletopLayout(Context context) {
        super(context);
    }

    public TabletopLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, heightMeasureSpec);
    }
}

