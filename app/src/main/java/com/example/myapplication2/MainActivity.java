package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication2.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView revCat;
    private CatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        revCat=findViewById(R.id.rev);
        adapter=new CatAdapter(this);
        GridLayoutManager manager=new GridLayoutManager(this,3);
        revCat.setLayoutManager(manager);
        adapter.setData(getListCat());
        revCat.setAdapter(adapter);
    }

    private List<Cat> getListCat() {
        List<Cat> list=new ArrayList<>();
        list.add(new Cat(R.drawable.index,"Cat 1"));
        list.add(new Cat(R.drawable.index,"Cat 2"));
        list.add(new Cat(R.drawable.index,"Cat 3"));
        list.add(new Cat(R.drawable.index,"Cat 4"));
        list.add(new Cat(R.drawable.index,"Cat 5"));
        list.add(new Cat(R.drawable.index,"Cat 6"));

        return list;
    }
}