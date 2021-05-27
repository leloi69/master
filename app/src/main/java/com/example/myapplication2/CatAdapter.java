package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.model.Cat;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{
    private Context mContext;
    private List<Cat> mlist;
    public CatAdapter(Context context){
        this.mContext=context;
    }
    public void setData(List<Cat> list){
        this.mlist=list;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat,parent,false);

        return new CatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat c=mlist.get(position);
        if(c==null)
            return;
            holder.img.setImageResource(c.getResouceImg());
            holder.txt.setText(c.getName());
            holder.bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mlist.remove(position);
                    notifyDataSetChanged();
                }
            });
    }

    @Override
    public int getItemCount() {
        if(mlist!=null){
            return mlist.size();
        }
        return 0;
    }

    public Cat getItem(int pos ) {
        return mlist.get(pos);
    }

    public class CatViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txt;
        private Button bt;

        public CatViewHolder(@NonNull View View) {
            super(View);
            img=View.findViewById(R.id.img);
            txt=View.findViewById(R.id.tv);
            bt = View.findViewById(R.id.bt);

        }
    }
    }
