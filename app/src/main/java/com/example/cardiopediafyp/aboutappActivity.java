package com.example.cardiopediafyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class aboutappActivity extends AppCompatActivity {
    private LinearLayout expandableLayout2;
    private LinearLayout expandableLayout3;
    private RecyclerView recyclerView;
    BottomNavigationView bottomNavigationView;
    private ArrayList<ParentItem> parentList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutapp);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        recyclerView = findViewById(R.id.parentRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addDataToList();
        ParentAdapter adapter = new ParentAdapter(parentList);
        recyclerView.setAdapter(adapter);

        expandableLayout2 = findViewById(R.id.expandable_layout2);
        expandableLayout3 = findViewById(R.id.expandable_layout3);

        // Set click listener for the second CardView (expandable)
        findViewById(R.id.cardView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of the expandable content
                if (expandableLayout2.getVisibility() == View.GONE) {
                    expandableLayout2.setVisibility(View.VISIBLE);
                } else {
                    expandableLayout2.setVisibility(View.GONE);
                }
            }
        });

        findViewById(R.id.cardView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility of the expandable content
                if (expandableLayout3.getVisibility() == View.GONE) {
                    expandableLayout3.setVisibility(View.VISIBLE);
                } else {
                    expandableLayout3.setVisibility(View.GONE);
                }
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.bottom_about);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                startActivity(new Intent(aboutappActivity.this, PatientDashboardActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_services) {
                startActivity(new Intent(aboutappActivity.this, sercvicesActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_about) {
                return true;
            } else if (item.getItemId() == R.id.bottom_chatbot) {
                startActivity(new Intent(aboutappActivity.this, chatbotActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });
    }

    private void addDataToList() {
        ArrayList<ChildItem> childItems1 = new ArrayList<>();
        childItems1.add(new ChildItem("Shahzada Husnain", R.drawable.husnain));
        childItems1.add(new ChildItem("Furqan", R.drawable.husnain));
        childItems1.add(new ChildItem("Ibtisam", R.drawable.husnain));
        parentList.add(new ParentItem("Prof. Dr. Ali Raza", R.drawable.husnain, childItems1));
    }
}
