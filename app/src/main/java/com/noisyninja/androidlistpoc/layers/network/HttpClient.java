package com.noisyninja.androidlistpoc.layers.network;

import android.content.Context;

import com.noisyninja.androidlistpoc.layers.UtilModule;
import com.noisyninja.androidlistpoc.layers.Utils;

import java.io.IOException;

import javax.inject.Inject;

import dagger.Module;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.noisyninja.androidlistpoc.BuildConfig.BASE_URL;
import static com.noisyninja.androidlistpoc.BuildConfig.CACHE_SIZE;

/**
 * Http client
 * Created by sudiptadutta on 27/04/18.
 */


@Module
public class HttpClient {

    private static Retrofit retrofit = null;
    private Context mContext;
    private UtilModule mUtilModule;

    @Inject
    public HttpClient(Context context, UtilModule utilModule) {
        mContext = context;
        mUtilModule = utilModule;
    }

    public Retrofit getClient() {

        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    //.addInterceptor(new ForceCacheInterceptor())//for network cache
                    .cache(new Cache(mContext.getCacheDir(), Long.parseLong(CACHE_SIZE)))
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    /**
     * to force cached data to be served when network not available
     * we skip this as it's already in room
     */
    public class ForceCacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            if (!mUtilModule.isNetworkConnected()) {
                builder.cacheControl(CacheControl.FORCE_CACHE);
            }

            return chain.proceed(builder.build());
        }
    }
}
