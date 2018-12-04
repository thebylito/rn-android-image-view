
package com.thebylito;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNImageViewModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNImageViewModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNImageView";
  }

  @ReactMethod
  public void acao(){
    Log.d("RNNA", "OLAAAAA");
  }

}
