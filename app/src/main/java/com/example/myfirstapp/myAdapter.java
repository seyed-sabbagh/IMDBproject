package com.example.myfirstapp;

import android.content.Context;
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


    ArrayList<String> menuLst;
    //OnItemClickListener listener;

    myAdapter(ArrayList<String> lst){

        menuLst=lst;
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
        final Class c;
       // holder.myBtn.setText(name);
        Log.d("adapter","item is "+ name);



        if (position==0)
        {
            holder.myBtn.setText("Dial");
            //Log.d("adapter","position is "+ position);
            c = DialActivityHw4.class;
        }


        else
        {
            holder.myBtn.setText("Profile");
            Log.d("adapter","position is "+ position);
            c = ProfileActivityHw4.class;
        }
        final Button b=holder.myBtn;

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("adapter","onClick ");
                Intent intent = new Intent(b.getContext(),c);
                b.getContext().startActivity(intent);
            }
        });


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
            itemView.setClickable(true);
        }


    }

    }


