package com.google.baikt3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    Button btnluungongu;
    ListView listluungonngu;
    EditText editTextngonngu;
    TextView txtdetalngongu;

    ArrayAdapter<String> adapter;
    ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnluungongu = (Button) findViewById(R.id.btnLưu);
        listluungonngu = (ListView) findViewById(R.id.listLuu);
        editTextngonngu = (EditText) findViewById(R.id.txtnhapvidu);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        listluungonngu.setAdapter(adapter);

       txtdetalngongu = (TextView) findViewById(R.id.txtngonngudetal);


        Intent intent= getIntent();
        txtdetalngongu.setText(intent.getStringExtra("ten"));

        ImageView btnthoat = (ImageView) findViewById(R.id.btnthoat);

        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this,MainActivity.class));
            }
        });
    }
    public void saveData(View view){
        if(editTextngonngu.getText().toString().isEmpty()){
            editTextngonngu.setError("Please enter text");
        }else{
            list.add(editTextngonngu.getText().toString());
            editTextngonngu.setText("");
            adapter.notifyDataSetChanged();
        }
    }
}