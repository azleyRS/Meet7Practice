package com.example.khomyakovruslan.meet7practice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] test = {"test1","test2","test3"};

    public MyAdapter() {
    }

    //this method need for testing
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = test[position];
        holder.mTextView.setText(text);
    }

    @Override
    public int getItemCount() {
        return test.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.cell_1_textview);
        }
    }
}
