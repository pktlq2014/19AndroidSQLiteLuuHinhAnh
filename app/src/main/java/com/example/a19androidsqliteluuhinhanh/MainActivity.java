package com.example.a19androidsqliteluuhinhanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Button butTon1;
    ListView listView1;
    ArrayList<DoVat> arrayList;
    DoVatAdapter adapter;
    // để class khác có thể gọi dc
    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butTon1 = findViewById(R.id.butTon1);
        listView1 = findViewById(R.id.listView1);
        arrayList = new ArrayList<>();
        adapter = new DoVatAdapter(MainActivity.this, R.layout.dong_do_vat, arrayList);
        listView1.setAdapter(adapter);
        // bước 2
        database = new Database(MainActivity.this, "QuanLy.sqlite", null , 1);
        // bước 3
        database.QueryData("CREATE TABLE IF NOT EXISTS DoVat(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(150), MoTa VARCHAR(250), HinhAnh BLOB)");
        butTon1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
        // get data
        Cursor cursor = database.GetData("SELECT * FROM DoVat");
        while (cursor.moveToNext())
        {
            arrayList.add(new DoVat
                    (
                       cursor.getInt(0),
                       cursor.getString(1),
                       cursor.getString(2),
                       cursor.getBlob(3)
                    ));
        }
        adapter.notifyDataSetChanged();
    }
}
