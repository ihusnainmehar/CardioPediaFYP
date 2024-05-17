package com.example.cardiopediafyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class aboutappActivity extends AppCompatActivity {
    private LinearLayout expandableLayout2;
    private LinearLayout expandableLayout3;
    private RecyclerView recyclerView;
    private ArrayList<ParentItem> parentList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutapp);
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
    }
    private void addDataToList() {
        ArrayList<ChildItem> childItems1 = new ArrayList<>();
        childItems1.add(new ChildItem("Shahzada Husnain", R.drawable.husnain));
        childItems1.add(new ChildItem("Muhammad Furqan Tahir", R.drawable.husnain));
        childItems1.add(new ChildItem("Ibtisam", R.drawable.husnain));
        parentList.add(new ParentItem("Prof. Dr. Ali Raza", R.drawable.husnain, childItems1));




    }
}