package com.example.myfirstapp;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myHolder> {

    public interface OnItemClickListener {
        void onItemClick(String itemTitle);
    }

    ArrayList<String> menuLst;
    OnItemClickListener listener;
    myAdapter(ArrayList<String> lst, OnItemClickListener lsn){

        menuLst=lst;
        listener=lsn;

    }


    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        myHolder holder=new myHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        String name= menuLst.get(position);
       // holder.myBtn.setText(name);
        Log.d("adapter","item is "+ name);

        if (position==0)
        {
            holder.myBtn.setText("Dial");
            //Log.d("adapter","position is "+ position);
            holder.bind("Dial",listener);}

        else
        {
            holder.myBtn.setText("Profile");
            Log.d("adapter","position is "+ position);
            holder.bind("Profile",listener);
        }



    }

    @Override
    public int getItemCount() {
        int listSize=menuLst.size();
        //Log.d("adapter","List size is "+ listSize);
        return listSize;
    }

    class myHolder extends RecyclerView.ViewHolder{
        Button myBtn;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            myBtn = itemView.findViewById(R.id.btnMenuItem);
        }

        public void bind(final String itemTitle,final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(itemTitle);
                }
            });

        }

    }

}
