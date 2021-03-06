package com.example.oblig2.Classes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.oblig2.DAO.PersonDao;

@Database(entities = {Person.class}, version = 6)
@TypeConverters({Converter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
    public static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "appDatabase").
                    fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }

    public PersonDao getPersonDao(){
        return personDao();
    }
}
