package com.example.oblig2;


import android.content.Context;

import androidx.core.content.ContextCompat;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.oblig2.Activities.DatabaseActivity;
import com.example.oblig2.Classes.AppDatabase;
import com.example.oblig2.Classes.Person;
import com.example.oblig2.DAO.PersonDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DatabaseTest {

    private AppDatabase appDatabase;
    private PersonDao personDao;
    private Person per;

    @Rule
    public ActivityScenarioRule<DatabaseActivity> activityRule =
            new ActivityScenarioRule<>(DatabaseActivity.class);

    @Before
    public void beforeEntryTest(){
        Context context = ApplicationProvider.getApplicationContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        personDao = appDatabase.getPersonDao();

        // Create  Per
        per = new Person("Per", ContextCompat.getDrawable(context, R.drawable.per));

        // Add Per to the database
        personDao.addPerson(per);
    }

    @After
    public void afterEntryTest(){
        appDatabase.close();
    }

    @Test
    public void entryTest() {
        // Check that Per was added to the database
        assertThat(personDao.getAll().size(), equalTo(1));
    }

    @Test
    public void removalTest() {
        // Delete Per from the database
        personDao.deletePerson(per);

        // Assert that Per was removed from the database
        assertThat(personDao.getAll().size(), equalTo(1));
    }

}
