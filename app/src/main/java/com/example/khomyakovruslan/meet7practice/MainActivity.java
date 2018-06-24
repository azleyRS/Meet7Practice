package com.example.khomyakovruslan.meet7practice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String BROADCAST = "myservice";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    BroadcastReceiver mBroadcastReceiver;
    IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemTypes> mData = new ArrayList<>();
        mData.add(ItemTypes.ITEM1);
        mData.add(ItemTypes.ITEM2);
        mData.add(ItemTypes.ITEM3);

        mAdapter = new MyAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);

        Intent i = MyService.newIntent(this);
        startService(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mRecyclerView.findViewHolderForAdapterPosition(0).itemView.setBackgroundColor(intent.getIntExtra("color1",0));
                mRecyclerView.findViewHolderForAdapterPosition(1).itemView.setBackgroundColor(intent.getIntExtra("color2",0));
                mRecyclerView.findViewHolderForAdapterPosition(2).itemView.setBackgroundColor(intent.getIntExtra("color3",0));
                //mRecyclerView.findViewHolderForAdapterPosition(0).itemView.findViewById(R.id.cell_1_textview).setBackgroundColor(intent.getIntExtra("color1",0));
                //mRecyclerView.findViewHolderForAdapterPosition(1).itemView.findViewById(R.id.cell_2_textview).setBackgroundColor(intent.getIntExtra("color2",0));
                //mRecyclerView.findViewHolderForAdapterPosition(2).itemView.findViewById(R.id.cell_3_textview).setBackgroundColor(intent.getIntExtra("color3",0));
            }
        };
        mIntentFilter = new IntentFilter(BROADCAST);
        registerReceiver(mBroadcastReceiver,mIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mBroadcastReceiver);
        stopService(MyService.newIntent(this));
    }
}
