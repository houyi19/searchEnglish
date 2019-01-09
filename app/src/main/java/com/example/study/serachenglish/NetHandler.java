package com.example.study.serachenglish;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class NetHandler {

    private static String URL = "http://120.79.193.54/";
    public static Retrofit newInstance(String URL) {
        Retrofit mRetrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return mRetrofit;
    }

    //进行数据下拉下载；
    public static Observable<WordBean> FetchWord(String word) {
        Observable<WordBean> response = NetHandler.newInstance(URL).create(WordService.class).getCall(word);
        return response;
    }
}
