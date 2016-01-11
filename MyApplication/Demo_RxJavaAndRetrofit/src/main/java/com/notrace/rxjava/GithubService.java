package com.notrace.rxjava;

import java.util.Map;

import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * Created by notrace on 2015/12/29.
 */
public interface GithubService {
    @GET("/search/repositories")
    Observable<GithubResults> getTopNewAndroidRepos(@QueryMap Map<String,String> querymap);
}
