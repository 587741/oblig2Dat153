package com.example.oblig2.Activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.oblig2.Classes.AppDatabase;
import com.example.oblig2.DAO.PersonDao;
import com.example.oblig2.R;


public class MainActivity extends AppCompatActivity {
    private PersonDao personDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        personDao = appDatabase.getPersonDao();
    }

    public void quiz(View view) {
        if (personDao.getAll().isEmpty()) {
            Toast.makeText(this, "No persons in database.", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(this, QuizActivity.class);
            startActivity(i);
        }

    }

    public void database(View view) {
        Intent i = new Intent(this, DatabaseActivity.class);
        startActivity(i);
    }

    public void newPerson(View view) {
        Intent i = new Intent(this, NewPersonActivity.class);
        startActivity(i);
    }
}