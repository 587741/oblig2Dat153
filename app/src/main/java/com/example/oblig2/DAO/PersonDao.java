package com.example.oblig2.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.oblig2.Classes.Person;

import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM person")
    List<Person> getAll();

    @Insert
    void addPerson(Person person);

    @Delete
    void deletePerson(Person person);
}
