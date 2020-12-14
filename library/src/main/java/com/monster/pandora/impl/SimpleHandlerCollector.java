//package com.monster.pandora.impl;
//
//import android.view.View;
//
//import com.monster.pandora.define.AnimatorPath;
//import com.monster.pandora.executor.ViewCollectorExecutor;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.WeakHashMap;
//
//public class SimpleHandlerCollector extends BaseHandlerCollector {
//
//    final WeakHashMap<View, BaseActionHandler> hashMap = new WeakHashMap<>();
//
//    @Override
//    BaseHandlerCollector collectActionHandler(BaseActionHandler handler, View view) {
//        if (hashMap.get(view) == null) {
//            hashMap.put(view, handler);
//        }
//        return this;
//    }
//
//    @Override
//    void onCollectOccur(boolean forward) {
//        ViewCollectorExecutor executor = new ViewCollectorExecutor(hashMap);
//        Set<View> views = hashMap.keySet();
//        Set<Map.Entry<View, BaseActionHandler>> entries = hashMap.entrySet();
//        Iterator<Map.Entry<View, BaseActionHandler>> iterator = entries.iterator();
//        while (iterator.hasNext()) {
//
//        }
//
//    }
//}
