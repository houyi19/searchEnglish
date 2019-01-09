package com.example.study.serachenglish;

import com.google.gson.annotations.SerializedName;

public class WordBean {
    @SerializedName("word")
    private String word;

    @SerializedName("phonetic")
    private String phonetic;

    @SerializedName("definition")
    private String definition;

    @SerializedName("translation")
    private String translation;

    @SerializedName("pos")
    private String pos;

    @SerializedName("collins")
    private String collins;

    @SerializedName("oxford")
    private int oxford;

    @SerializedName("tag")
    private String tag;

    @SerializedName("bnc")
    private String bnc;

    @SerializedName("frq")
    private String frq;

    @SerializedName("exchange")
    private String exchange;

    @SerializedName("detail")
    private String detail;

    @SerializedName("audio")
    private String audio;

    @Override
    public String toString() {
        return "WordBean{" +
                "word='" + word + '\'' +
                ", phonetic='" + phonetic + '\'' +
                ", definition='" + definition + '\'' +
                ", translation='" + translation + '\'' +
                ", pos='" + pos + '\'' +
                ", collins='" + collins + '\'' +
                ", oxford=" + oxford +
                ", tag='" + tag + '\'' +
                ", bnc='" + bnc + '\'' +
                ", frq='" + frq + '\'' +
                ", exchange='" + exchange + '\'' +
                ", detail='" + detail + '\'' +
                ", audio='" + audio + '\'' +
                '}';
    }
}
