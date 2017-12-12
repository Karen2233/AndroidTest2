package com.example.karen.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>>dataList;

    private String[] text=new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] img=new int[] {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView=(ListView)findViewById(R.id.listview);
        dataList=new ArrayList<Map<String,Object>>();
        simpleAdapter=new SimpleAdapter(this,listItems(),R.layout.item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
    }
    private  List<Map<String,Object>>listItems(){
        for(int i=0;i<text.length;i++){
            Map<String,Object>map=new HashMap<String,Object>();
            map.put("image",img[i]);
            map.put("text",text[i]);
            dataList.add(map);
        }
        return dataList;
    }
    @Override
    public void onItemClick(AdapterView<?>parent, View view, int position,long id){
        Toast.makeText(this,text[position],Toast.LENGTH_SHORT).show();
    }

}
