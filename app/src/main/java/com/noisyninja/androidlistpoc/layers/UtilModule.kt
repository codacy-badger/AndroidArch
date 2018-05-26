package com.noisyninja.androidlistpoc.layers

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.net.ConnectivityManager
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.google.gson.GsonBuilder
import timber.log.Timber
import java.lang.reflect.Type
import javax.inject.Inject

/**
 * Module to hold all utility methods
 * Created by sudiptadutta on 27/04/18.
 */
open class UtilModule @Inject
constructor(private val mContext: Context) {

    val isNetworkConnected: Boolean
        get() {
            val cm = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm != null && cm.activeNetworkInfo != null
        }

    fun getStringRes(@StringRes resId: Int): String {
        return mContext.getString(resId)
    }

    fun getStringPref(key: String): String? {
        return mContext.getSharedPreferences(DEFAULT_PREF, MODE_PRIVATE).getString(key, null)
    }

    fun setStringPref(key: String, value: String) {
        val editor = mContext.getSharedPreferences(DEFAULT_PREF, MODE_PRIVATE).edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun deleteStringPref(key: String) {
        mContext.getSharedPreferences(DEFAULT_PREF, MODE_PRIVATE).edit().remove(key).apply()
    }

    fun showSnackBar(view: View, text: String) {
        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
        val contentLay = snackbar.view.findViewById<View>(android.support.design.R.id.snackbar_text).parent as ViewGroup
        val item = ProgressBar(view.context)
        contentLay.addView(item)
        snackbar.show()
        //.setAction("Action", null).show();
    }

    fun logI(text: String) {
        Timber.i(text)
    }

    fun toast(string: String) {
        Toast.makeText(mContext, string,
                Toast.LENGTH_SHORT).show()
    }

    fun toJson(`object`: Any): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(`object`)
    }

    fun <T> fromJson(string: String, t: Class<T>): T {
        return GsonBuilder().setPrettyPrinting().create().fromJson(string, t)
    }

    fun <T> fromJson(string: String, type: Type): T? {
        return GsonBuilder().setPrettyPrinting().create().fromJson<T>(string, type)
    }

    companion object {
        private val DEFAULT_PREF = "DEFAULT_PREF"
    }
    /*
    public void loadImage(Context context, String url, ImageView imageView) {
        String imageUrl = BuildConfig.POSTER_URI + url;
        //Utils.logI(Utils.class, "Loading image:" + imageUrl);
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .into(imageView);
    }

    public void share(Context context, String name, String title) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(BuildConfig.MIME_TYPE);
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT, getStringRes(context, R.string.share_tag) + name);
        context.startActivity(intent);
    }

    public void getAllShared(Context context) {
        Map<String, ?> allEntries = context.getSharedPreferences(DEFAULT_PREF, MODE_PRIVATE).getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
        }
    }
*/

}