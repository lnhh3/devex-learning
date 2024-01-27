package com.project.devexlearning.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.devexlearning.R;
import com.project.devexlearning.adapter.CoursesAdapter;
import com.project.devexlearning.entity.Course;

import java.util.ArrayList;

public class CoursesActivity extends AppCompatActivity {
    private RecyclerView.Adapter coursesAdapter;
    private RecyclerView coursesRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        initRecycleView();

        ConstraintLayout back = findViewById(R.id.backBtn);
        back.setOnClickListener(v -> finish());
    }

    private void initRecycleView() {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Advanced Certification Program in AI", 169, "ic_1"));
        courses.add(new Course("Google Cloud Platform Architecture", 69, "ic_2"));
        courses.add(new Course("Fundamental of Java Programming", 150, "ic_3"));
        courses.add(new Course("Introduction to UI Design History", 79, "ic_4"));
        courses.add(new Course("PG Program in Big Data Engineering", 49, "ic_5"));
        courses.add(new Course("PG Program in Big Data Engineering", 49, "ic_5"));
        courses.add(new Course("PG Program in Big Data Engineering", 49, "ic_5"));
        courses.add(new Course("PG Program in Big Data Engineering", 49, "ic_5"));
        courses.add(new Course("PG Program in Big Data Engineering", 49, "ic_5"));
        courses.add(new Course("PG Program in Big Data Engineering", 49, "ic_5"));
        courses.add(new Course("PG Program in Big Data Engineering", 49, "ic_5"));
        courses.add(new Course("PG Program in Big Data Engineering", 49, "ic_5"));
        courses.add(new Course("PG Program in Big Data Engineering", 49, "ic_5"));

        coursesRecycleView = findViewById(R.id.coursesRecycle);
        coursesRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        coursesAdapter = new CoursesAdapter(courses);
        coursesRecycleView.setAdapter(coursesAdapter);
    }
}