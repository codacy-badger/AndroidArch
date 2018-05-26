package com.noisyninja.androidlistpoc.layers.network;

import com.noisyninja.androidlistpoc.BuildConfig;
import com.noisyninja.androidlistpoc.model.MeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * retrofit interface for moviedb calls
 * Created by sudiptadutta on 06/02/18.
 */

public interface INetworkDao {

    @GET(BuildConfig.API_URI)
    Observable<MeResponse> getPeople(@Query(BuildConfig.PAGE_URI) int page, @Query(BuildConfig.RESULTS_URI) int count, @Query(BuildConfig.NETSYNC_SEED) int seed);

}
