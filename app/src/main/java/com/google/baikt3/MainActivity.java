package com.google.baikt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.baikt3.Controller.NgonNguAdapter;
import com.google.baikt3.Model.NgonNgu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<NgonNgu> items = new ArrayList<>();
    NgonNguAdapter adapter;
    ListView listNgonNgu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNgonNgu = (ListView) findViewById(R.id.listngonngu);


        items.add(new NgonNgu("Tiếng Anh",R.drawable.icon_tienganh)) ;
        items.add(new NgonNgu("Tiếng Pháp",R.drawable.icon_tiengphap)) ;
        items.add(new NgonNgu("Tiếng Nga",R.drawable.icon_tiengnga)) ;
        items.add(new NgonNgu("Tiếng Việt",R.drawable.icon_tiengviet)) ;
        items.add(new NgonNgu("Tiếng Trung",R.drawable.icon_tiengtrung));
        items.add(new NgonNgu("Tiếng Ý",R.drawable.icon_tiengy));


        adapter = new NgonNguAdapter(MainActivity.this,items);
        listNgonNgu.setAdapter(adapter);
        listNgonNgu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("ten",items.get(i).getTenNgonNgu());
                startActivity(intent);
            }
        });
    }
}