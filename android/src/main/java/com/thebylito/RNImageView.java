package com.thebylito;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.views.image.ReactImageView;
import com.facebook.react.views.view.ReactViewGroup;
import com.squareup.picasso.Picasso;

public class RNImageView extends FrameLayout {
    private Uri mUri;
    private ReadableMap mHeaders;
    private boolean mIsDirty;
    private boolean mIsLocalImage;
    private Activity mActivity = null;
    final ImagePopup imagePopup;
    private ThemedReactContext mContext = null;

    @Override
    public void requestLayout() {
        super.requestLayout();
        post(measureAndLayout);
    }

    private final Runnable measureAndLayout = new Runnable() {
        @Override
        public void run() {
            measure(
                    MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.EXACTLY));
            layout(getLeft(), getTop(), getRight(), getBottom());
        }
    };

    public RNImageView(final ThemedReactContext mContext) {
        super(mContext);
        this.mContext = mContext;
        imagePopup = new ImagePopup(mContext.getCurrentActivity());

        //init();
    }

    public void init() {
        RelativeLayout.LayoutParams math = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams mathImage = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        ImageView img = new ImageView(mContext);
        Picasso.with(getContext()).load(mUri).into(img);

       /* TextView textView = new TextView(mContext);
        textView.setText("hello world");
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundColor(Color.GRAY);
        addView(textView, math);*/
        addView(img, mathImage);
        setClickable(true);
        //setBackgroundColor(Color.RED);
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }

    public void show(){
        ImageView img = new ImageView(mContext);
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setImageOnClickClose(true);  // Optional
        imagePopup.setBackgroundColor(Color.BLACK);
        Picasso.with(getContext()).load(mUri).into(img);
        imagePopup.initiatePopupWithPicasso(mUri);
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePopup.viewPopup();

            }
        });
    }

    public void setSource(@Nullable ReadableMap source,
                          @NonNull ResourceDrawableIdHelper resourceDrawableIdHelper) {
        mUri = null;
        if (source != null) {
            String uri = source.getString("uri");
            try {
                mUri = Uri.parse(uri);
                // Verify scheme is set, so that relative uri (used by static resources) are not handled.
                if (mUri.getScheme() == null) {
                    mUri = null;
                }
            } catch (Exception e) {
                // ignore malformed uri, then attempt to extract resource ID.
            }
            if (mUri == null) {
                mUri = resourceDrawableIdHelper.getResourceDrawableUri(getContext(), uri);
                mIsLocalImage = true;
            } else {
                mIsLocalImage = false;
            }
        }
        mIsDirty = true;
        init();
    }
}
