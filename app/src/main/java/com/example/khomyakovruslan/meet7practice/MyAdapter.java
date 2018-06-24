package com.example.khomyakovruslan.meet7practice;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<ItemTypes> mDate;

    public MyAdapter(ArrayList<ItemTypes> date) {
        mDate = date;
    }

    @Override
    public int getItemViewType(int position) {
        if (mDate.get(position).getType()==ItemTypes.ITEM1.type){
            return ItemTypes.ITEM1.type;
        } else if (mDate.get(position).getType()==ItemTypes.ITEM2.type){
            return ItemTypes.ITEM2.type;
        } else if (mDate.get(position).getType()==ItemTypes.ITEM3.type){
            return ItemTypes.ITEM3.type;
        }else if (mDate.get(position).getType()==ItemTypes.ITEM4.type){
            return ItemTypes.ITEM4.type;
        }
        return mDate.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case 1: return new ViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_1,parent,false));
            case 2: return new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_2,parent,false));
            case 3: return new ViewHolder3(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_3,parent,false));
            case 4: return new ViewHolder4(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_4,parent,false));
        }
        return new ViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case 1: ViewHolder1 viewHolder1 = (ViewHolder1)holder;
            //viewHolder1.mTextView.setText("Test1");
            break;
            case 2: ViewHolder2 viewHolder2 = (ViewHolder2)holder;
            break;
            case 3: ViewHolder3 viewHolder3 = (ViewHolder3)holder;
            break;
            case 4: ViewHolder4 viewHolder4 = (ViewHolder4)holder;
            break;
        }
    }

    @Override
    public int getItemCount() {
        return mDate.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView mTextView;
        public ViewHolder1(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.cell_1_textview);
        }
    }
    private class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView mTextView;
        public ViewHolder2(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.cell_2_textview);
        }
    }
    private class ViewHolder3 extends RecyclerView.ViewHolder {
        TextView mTextView;
        public ViewHolder3(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.cell_3_textview);
        }
    }

    private class ViewHolder4 extends RecyclerView.ViewHolder {
        private RecyclerView mRecyclerView2;
        private RecyclerView.Adapter mAdapter2;
        private RecyclerView.LayoutManager mLayoutManager2;

        public ViewHolder4(View itemView) {
            super(itemView);

            mRecyclerView2 = itemView.findViewById(R.id.recycler_view2);
            mLayoutManager2 = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
            mRecyclerView2.setLayoutManager(mLayoutManager2);
            mAdapter2 = new MyAdapter2();
            mRecyclerView2.setAdapter(mAdapter2);
        }
    }
}
