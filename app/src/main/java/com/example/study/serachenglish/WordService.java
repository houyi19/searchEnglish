package com.example.study.serachenglish;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WordService {

    @GET("server/public/words/")
    Observable<WordBean>getCall(@Query("word") String word);
}
