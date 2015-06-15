package com.exemple.tipso;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Hadrich-Hatem on 26/04/2015.
 */
public class CategorieSquareImageView extends ImageView {
    public CategorieSquareImageView(Context context) {
        super(context);
    }

    public CategorieSquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CategorieSquareImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth()); //Snap to width
    }
}
