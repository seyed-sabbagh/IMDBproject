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

public class myAdapter2 extends RecyclerView.Adapter<myAdapter2.myHolder> {

    public interface OnItemClickListener {
        void onItemClick(String itemTitle);
    }

    ArrayList<String> menuLst;
    //OnItemClickListener listener;

    myAdapter2(ArrayList<String> lst){

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
            holder.setAdapterPostion(position);
            c = DialActivityHw4.class;
        }


        else
        {
            holder.myBtn.setText("Profile");
            Log.d("adapter","position is "+ position);
            holder.setAdapterPostion(position);
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

    class myHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Button myBtn;
        private final Context context;
        private int adapterPostion;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            myBtn = itemView.findViewById(R.id.btnMenuItem);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            context=itemView.getContext();


        }

        @Override
        public void onClick(View v) {

            Log.d("adapter","LonClick event ");


            final Intent intent;
            switch (getAdapterPostion()){
                case 0:
                    intent =  new Intent(context, DialActivityHw4.class);
                    break;

                case 1:
                    intent =  new Intent(context, ProfileActivityHw4.class);
                    break;
                default:
                    intent =  new Intent(context, MainActivity.class);
                    break;
            }
            context.startActivity(intent);
        }

        public int getAdapterPostion() {
            return adapterPostion;
        }

        public void setAdapterPostion(int adapterPostion) {
            this.adapterPostion = adapterPostion;
        }
    }

    }


