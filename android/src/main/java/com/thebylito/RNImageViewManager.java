
package com.thebylito;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewManager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNImageViewManager extends ViewGroupManager<RNImageView> {
    public static final String REACT_CLASS = "RNImageViewManager";
    public static String DEBUG = "RNIMAGEVIEW";
    private ThemedReactContext mContext = null;

    private ResourceDrawableIdHelper mResourceDrawableIdHelper;

    RNImageViewManager() {
        mResourceDrawableIdHelper = new ResourceDrawableIdHelper();
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected RNImageView createViewInstance(ThemedReactContext mContext) {
        this.mContext = mContext;
        return new RNImageView(mContext);
    }

   /* @ReactProp(name = "width")
    public void setWidth(RNImageView view, @Nullable Integer width) {
        view.setMaxWidth(width);
        view.setMinimumWidth(width);
    }*/

/*    @ReactProp(name = "height")
    public void setHeight(RNImageView view, @Nullable Integer height) {
        view.setMaxHeight(height);
        view.setMinimumHeight(height);
    }
*/
    @ReactProp(name = "src")
    public void setSource(RNImageView view, @Nullable ReadableMap source) {
        Log.d(DEBUG, source.toString());
        view.setSource(source, mResourceDrawableIdHelper);
    }
}
