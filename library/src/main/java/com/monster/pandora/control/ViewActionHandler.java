package com.monster.pandora.control;

import android.view.View;

/**
 * Created by $xuzhili on 2018/12/28.
 */

public interface ViewActionHandler <T> {

    /**
     * view开始一个动画
     *
     * @param forward true开始动画，false返回动画
     */
    void onViewActionOccur(View view, boolean forward);

    void onViewActionOccur(View view);

//    /**
//     * 设置动画差值器
//     *
//     * @param interpolator interpolator
//     */
//    void setInterpolator(Interpolator interpolator);
//
////    /**
////     * @return interpolator
////     */
////    Interpolator getInterpolator();
//
//    void setDelay(int delay);
//
//    void setDuration(int duration);
//
//    void setAnimatorValue(float animatorValue);

//    /**
//     * 设置动画 路径
//     *
//     * @param animationPath animationPath
//     */
//    void setAnimatorPath(@NonNull AnimatorPath animationPath);


}
