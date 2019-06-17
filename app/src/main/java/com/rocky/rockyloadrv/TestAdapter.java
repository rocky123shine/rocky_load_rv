package com.rocky.rockyloadrv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author
 * @date 2019/6/17.
 * description：
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.InnerHolder> {
    private List<String> data = new ArrayList<>();

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    public void addAll(List<String> data1){
        data.addAll(data1);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new InnerHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_test, null));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder innerHolder, int i) {
        innerHolder.tv_test.setText(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private TextView tv_test;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            tv_test = itemView.findViewById(R.id.tv_test);
        }
    }
}
