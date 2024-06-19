package com.example.sportsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListenerForCard{

    RecyclerView recyclerView;

    private List<SportsClass> sportslist;
    private CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        sportslist=new ArrayList<>();

        sportslist.add(new SportsClass(R.drawable.football, "Football"));
        sportslist.add(new SportsClass(R.drawable.basketball, "Basketball"));
        sportslist.add(new SportsClass(R.drawable.cricket, "Cricket"));
        sportslist.add(new SportsClass(R.drawable.hokcey, "Hockey"));

        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter=new CardAdapter(getApplicationContext(),sportslist);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);



    }


    @Override
    public void onItemClick(View view, int position) {
        SportsClass sports=sportslist.get(position);
        Toast.makeText(MainActivity.this,"You clicked on "+ sports.getSportname(),Toast.LENGTH_LONG).show();
    }
}