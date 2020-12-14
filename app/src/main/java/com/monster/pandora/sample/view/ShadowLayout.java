package com.monster.pandora.sample.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by $xuzhili on 2018/5/22.
 * dangbei network
 * <p>
 * 带有投影效果的layout。
 * 如果该layout可获取焦点，则投影效果会根据焦点变化自动出现和消失。
 * 如果该layout不可获取焦点，则需要手动调用{@link #toggleShow(boolean)} 控制投影的出现和消失。
 * 现支持圆形和方形投影，默认为圆形投影
 * 投影方式，{@link #setRect(boolean)} 更换投影方式
 * 投影颜色，{@link #setShadowColor(int)}
 * 投影颜色alpha度数，{@link #setShadowAlpha(float)}
 * 投影度数,度数越大，投影越大，一般不需要设置，{@link #setShadowRadius(int)}
 */

public class ShadowLayout extends FrameLayout {
    private ShadowView shadowView;
    private boolean isRect;
    private String symbol;

    private boolean showShadow = true;

    public ShadowLayout(Context context) {
        super(context);
        initData();
    }

    public ShadowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public ShadowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        setClipChildren(false);

        /**
         * shadow View
         */
        shadowView = new ShadowView(getContext());
        super.addView(shadowView, 0, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void setClipShadow(boolean clipShadow){
        shadowView.setClipShadow(clipShadow);
    }

    public void setRect(boolean rect) {
        isRect = rect;
        shadowView.setRect(isRect);
    }

    public void setRoundRect(boolean roundRect) {
        shadowView.setRoundRect(roundRect);
    }

    public void setShadowColor(int shadowColor) {
        this.shadowView.setShadowColor(shadowColor);
    }

    public void setShadowRadius(int shadowRadius) {
        this.shadowView.setShadowRadius(shadowRadius);
    }

    public void setShadowAlpha(float shadowAlpha) {
        this.shadowView.setShadowAlpha(shadowAlpha);
    }

    public void toggleShow(boolean focused) {
        this.shadowView.setFocused(focused);
    }
    public boolean isToggleShow(){
        return shadowView.isFocuseds();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(showShadow) {
            int width = r - l;
            int height = b - t;
            if (isRect) {
                int shadowOffsetY = (int) ((b - t) * 0.15f);
                shadowView.setShadowOffsetY(shadowOffsetY);
                int shadowHeight = (int) (shadowOffsetY * 3f);
                shadowView.layout(
                        -shadowView.getShadowRadius(),
                        height - shadowHeight,
                        width + shadowView.getShadowRadius(),
                        (int) (height + shadowHeight * 1.2f)
                );
            } else {
                shadowView.layout(
                        -shadowView.getShadowRadius(),
                        0,
                        width + shadowView.getShadowRadius(),
                        height + shadowView.getShadowRadius() * 2
                );
            }
        }
    }


    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if(showShadow) {
            toggleShow(gainFocus);
        }
    }
    /**
     * add after shadowView
     */
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (index == 0) {
            index = 1;
        }
        super.addView(child, index, params);
    }

    /**
     * remove exclude shadowView
     */
    @Override
    public void removeAllViews() {
        int childCount = getChildCount();
        if (childCount <= 1) {
            return;
        }
        removeViews(1, childCount - 1);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setShowShadow(boolean showShadow) {
        this.showShadow = showShadow;
    }
}
