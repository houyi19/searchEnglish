package com.example.study.serachenglish;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHodler> {
    private ArrayList<WordBean> mWordModels;

    public WordAdapter() {
        mWordModels = new ArrayList<>();
    }

    public void setData(ArrayList<WordBean> mModels) {
        mWordModels.clear();
        if (mModels.isEmpty()) {
            return;
        }
        mWordModels.addAll(mModels);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHoler, int i) {

    }

    @Override
    public int getItemCount() {
        return mWordModels.size();
    }


    protected class ViewHodler extends RecyclerView.ViewHolder {

        public ViewHodler(@NonNull View itemView) {
            super(itemView);
        }
    }

}
