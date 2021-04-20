package com.erikaosgue.motivationalapp.controller

import android.app.Application
import android.text.TextUtils
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class AppController : Application() {

    private var mRequestQueue: RequestQueue? = null

    // Registering the RequestQueue
    private val requestQueue: RequestQueue
        get() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(applicationContext)
            }
            return this.mRequestQueue!!
        }

    override fun onCreate() {
        super.onCreate()
        //appControllerInstance = Instance of AppController
        appControllerInstance = this
    }

   /*     public ImageLoader getImageLoader() {
            getRequestQueue();
            if (mImageLoader == null) {
                mImageLoader = new ImageLoader(this.mRequestQueue,
                        new LruBitmapCache());
            }
            return this.mImageLoader;
        }*/

    fun <T> addToRequestQueue(req: Request<T>, tag: String) {
        // set the default tag if tag is empty
        req.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueue.add(req)
    }

    fun <T> addToRequestQueue(req: Request<T>) {

        req.tag = TAG
        Log.d("request Tag:", req.tag.toString())
        Log.d("TAG:", TAG.toString())
        requestQueue.add(req)
    }

    fun cancelPendingRequests(tag: Any) {
        if (mRequestQueue != null) {
            mRequestQueue!!.cancelAll(tag)
        }
    }

    companion object {
        //TAG  = AppController (the Name of the class)
        val TAG: String = AppController::class.java
            .simpleName

        @get:Synchronized
        var appControllerInstance: AppController? = null
            private set
    }
}