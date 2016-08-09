package com.example.newuser.myapplication;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by new user on 8/7/2016.
 */
public class VolleySingleton {
    private static VolleySingleton Instance=null;
    private ImageLoader imageloder;
    private RequestQueue requestQueue;

    private VolleySingleton(){
        requestQueue = Volley.newRequestQueue(Appcontrolller.getAppContext());

        imageloder = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            int size = (int)(Runtime.getRuntime().maxMemory()/1024/8);
            private LruCache<String,Bitmap> lruCache = new LruCache<>(size);
            @Override
            public Bitmap getBitmap(String url) {

                return lruCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
              lruCache.put(url,bitmap);
            }
        });



    }

    public  static VolleySingleton getInstance(){
        if (Instance == null){
            Instance = new VolleySingleton();

        }
        return Instance;
    }
    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
    public ImageLoader getImageLoader (){
        return  imageloder;
    }
}
