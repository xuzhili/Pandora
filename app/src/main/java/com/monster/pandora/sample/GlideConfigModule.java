package com.monster.pandora.sample;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by $xuzhili on 2018/8/30.
 */

@GlideModule
public class GlideConfigModule extends AppGlideModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        int memoryCacheSizeBytes = 1024 * 1024 * 5; // 20mb
        builder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));

        int bitmapPoolSizeBytes = 1024 * 1024 * 5; // 30mb
        builder.setBitmapPool(new LruBitmapPool(bitmapPoolSizeBytes));

        builder.setDefaultRequestOptions(
                new RequestOptions()
                        .format(DecodeFormat.PREFER_RGB_565)
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .disallowHardwareConfig());
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
