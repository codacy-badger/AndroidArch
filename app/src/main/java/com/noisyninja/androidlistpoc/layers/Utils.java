package com.noisyninja.androidlistpoc.layers;

import android.util.Log;

import com.google.gson.GsonBuilder;

/**
 * utils class
 * Created by sudiptadutta on 27/04/18.
 */
@Deprecated
public class Utils {

    public static void logI(Class clazz, String text) {
        Log.i(clazz.getSimpleName(), text);
    }

    public static String toJson(Object object) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(object);
    }

    public static <T> T fromJson(String string, Class<T> t) {
        return new GsonBuilder().setPrettyPrinting().create().fromJson(string, t);
    }
}