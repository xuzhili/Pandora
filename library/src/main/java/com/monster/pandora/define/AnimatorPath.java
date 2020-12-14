package com.monster.pandora.define;

import android.support.annotation.RestrictTo;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Created by $xuzhili on 2018/12/28.
 */
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class AnimatorPath {

    /**
     * 差值器
     */
    public Interpolator interpolator;

    /**
     * 动画回调
     */
    public OnPandoraListener onListener;

    public OnPandoraUpdateListener onPandoraUpdateListener;

    /**
     * 时长
     */
    public int duration;

    /**
     * 延时执行时间
     */
    public int delay;

    /**
     * 动画类型 {@link AnimatorType}
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
    public int animatorType;

    public AnimatorAction animatorAction;

    public static AnimatorPath buildNewAnimationPath(final AnimatorPath animatorPathFrom) {
        AnimatorPath animatorPath = new AnimatorPath();
        animatorPath.interpolator = animatorPathFrom.interpolator;
        animatorPath.onListener = animatorPathFrom.onListener;
        animatorPath.onPandoraUpdateListener = animatorPathFrom.onPandoraUpdateListener;
        animatorPath.duration = animatorPathFrom.duration;
        animatorPath.delay = animatorPathFrom.delay;
        animatorPath.animatorType = animatorPathFrom.animatorType;
        animatorPath.animatorAction = new AnimatorAction() {
            @Override
            public void setAnimatorValue(View view, float valueLevel, AnimatorAction animatorAction, boolean singleTrack) {
                animatorPathFrom.animatorAction.setAnimatorValue(view, valueLevel, animatorAction, singleTrack);
            }

            @Override
            public void onActionStart(View view, AnimatorAction animatorAction) {
                animatorPathFrom.animatorAction.onActionStart(view, animatorAction);
            }
        };
        animatorPath.animatorAction.value1 = animatorPathFrom.animatorAction.value1;
        animatorPath.animatorAction.value2 = animatorPathFrom.animatorAction.value2;
        return animatorPath;
    }

    @Override
    public String toString() {
        return "AnimatorPath{" +
                "interpolator=" + interpolator +
                ", duration=" + duration +
                ", delay=" + delay +
                ", animatorType=" + animatorType +
                ", animatorAction=" + animatorAction +
                '}';
    }
}
