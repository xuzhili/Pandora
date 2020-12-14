package com.monster.pandora.sample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.monster.pandora.sample.R;

/**
 * Created by $xuzhili on 2018/5/22.
 * dangbei network
 */

public class ShadowView extends View {

    private Paint paint;
    private int shadowColor;
    private int shadowAlpha;
    private int shadowRadius;
    private int shadowOffsetY;
    private boolean isFocused;
    private boolean isRect;
    private boolean isRoundRect;
    private RectF rectIn;

    private boolean clipShadow = true;

    public ShadowView(Context context) {
        super(context);
        initData(null);
    }

    public ShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(attrs);
    }

    public ShadowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(attrs);
    }

    private void initData(AttributeSet attrs) {
        //效率问题暂不使用该方式获取属性值
//        if (attrs != null) {
//            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ShadowView);
//            shadowAlpha = (int) (a.getFloat(R.styleable.ShadowView_sv_shadow_alpha, 0.5f) * 255);
//            shadowRadius = a.getInt(R.styleable.ShadowView_sv_radius, 20);
//            shadowColor = a.getColor(R.styleable.ShadowView_sv_shadow_color, Color.GRAY);
//            a.recycle();
//        }
        shadowAlpha = (int) (1f * 255);
        shadowRadius = 25;
        shadowColor = Color.RED;


        paint = new Paint(Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG | Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paint.setColor(shadowColor);
        paint.setStyle(Paint.Style.FILL);
        rectIn = new RectF();
    }

    /**
     * 设置是否矩形 默认true
     *
     * @param rect
     */
    public void setRect(boolean rect) {
        isRect = rect;
    }

    public void setRoundRect(boolean roundRect) {
        isRoundRect = roundRect;
    }

    public void setShadowColor(int shadowColor) {
        this.shadowColor = shadowColor;
        if (null != paint) {
            paint.setColor(this.shadowColor);
        }
    }

    public void setShadowOffsetY(int shadowOffsetY) {
        this.shadowOffsetY = shadowOffsetY;
    }

    public void setShadowRadius(int shadowRadius) {
        this.shadowRadius = shadowRadius;
    }

    public int getShadowRadius() {
        return shadowRadius;
    }

    public int getShadowAlpha() {
        return shadowAlpha;
    }

    public int getShadowColor() {
        return shadowColor;
    }

    public void setShadowAlpha(float shadowAlpha) {
        this.shadowAlpha = (int) (255 * shadowAlpha);
        if (null != paint) {
            paint.setAlpha(this.shadowAlpha);
        }
    }

    public void setFocused(boolean focused) {
        isFocused = focused;
        invalidate();
    }

    public boolean isFocuseds() {
        return isFocused;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    public void setClipShadow(boolean clipShadow) {
        this.clipShadow = clipShadow;
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        if (!isFocused) {
//            //去掉图层绘制，避免过度绘制
//            if (getLayerType() != View.LAYER_TYPE_NONE) {
//                setLayerType(View.LAYER_TYPE_NONE, null);
//            }
//            return;
//        }
//        if (getLayerType() != View.LAYER_TYPE_SOFTWARE) {
//            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//            return;
//        }
//        int width = getWidth();
//        int height = getHeight();
//
//        int dy = shadowOffsetY != 0 ? shadowOffsetY : shadowRadius;
//        paint.setShadowLayer(shadowRadius, 0, dy, shadowColor);
//        if (isRect) {
//            float bottom = height - (shadowOffsetY != 0 ? shadowOffsetY * 3.7f : shadowRadius * 3.1f);
//            float top = bottom - dy - shadowRadius;
//            if (clipShadow) {
//                canvas.save();
//            }
//            top = top > 0 ? top : 0;
//            if (clipShadow) {
//                canvas.clipRect(0, shadowOffsetY > 0 ? (height - shadowOffsetY * 3.6f) : bottom, width, height);
//            }
//            rectIn.set(shadowRadius * 1.7f, top, width - shadowRadius * 1.7f, bottom);
//            if (isRoundRect) {
//                canvas.drawRoundRect(rectIn, 50, 50, paint);
//            } else {
//                canvas.drawRoundRect(rectIn, 0, 0, paint);
//            }
//            if (clipShadow) {
//                canvas.restore();
//            }
//        } else {
//            canvas.drawCircle(width / 2, height / 2, (width - 4 * shadowRadius) / 2, paint);
//        }
        super.onDraw(canvas);
    }

}
