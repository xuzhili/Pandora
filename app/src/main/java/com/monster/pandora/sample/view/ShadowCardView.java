package com.monster.pandora.sample.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;

public class ShadowCardView extends CardView {
    public ShadowCardView(@NonNull Context context) {
        super(context);
    }

    public ShadowCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShadowCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        Log.d("ShadowCardView", "gainFocus:" + gainFocus);
        if (gainFocus) {
            setBackgroundColor(Color.RED);
        } else {
            setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
