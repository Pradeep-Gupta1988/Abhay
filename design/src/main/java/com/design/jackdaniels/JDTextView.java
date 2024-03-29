package com.design.jackdaniels;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;


public class JDTextView extends AppCompatTextView {


    public JDTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public JDTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public JDTextView(Context context) {
        super(context);
        init(null);
    }


    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);

            String fontName = a.getString(R.styleable.CustomView_font_name);

            try {
                if (fontName != null) {
                    Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
                    setTypeface(myTypeface);
                }else {
                    Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Niramit-Regular.ttf" );
                    setTypeface(myTypeface);
                }
            } catch (Exception e) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Niramit-Regular.ttf" );
                setTypeface(myTypeface);
                e.printStackTrace();
            }

            a.recycle();
        }
    }

}