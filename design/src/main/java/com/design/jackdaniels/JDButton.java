package com.design.jackdaniels;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;


public class JDButton extends AppCompatButton {


    public JDButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public JDButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public JDButton(Context context) {
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
                e.printStackTrace();
            }

            a.recycle();
        }
    }

}