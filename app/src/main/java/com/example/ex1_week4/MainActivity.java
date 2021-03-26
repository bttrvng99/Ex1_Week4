package com.example.ex1_week4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private int[] icon = {R.drawable.android_ico, R.drawable.ios_icon, R.drawable.blackberry_ico,
    R.drawable.windows_ico};
    private String[] title = {"Android","iOS","Blackberry","Windows Phone"};
    private String[] sub = {"Sub1","Sub2","Sub3","Sub4"};
    private String[] content = {"C1", "C2", "C3", "C4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ListView);
        MyListAdapter adapter = new MyListAdapter(this, icon,title, sub,content);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i=0; i<adapter.getCount();i++){
                    parent.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                parent.getChildAt(position).setBackgroundColor(Color.LTGRAY);
                Toast.makeText(MainActivity.this, "Selected: "+ adapter.getTitle(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}