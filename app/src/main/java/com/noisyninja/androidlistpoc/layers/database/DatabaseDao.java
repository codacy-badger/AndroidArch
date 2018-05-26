package com.noisyninja.androidlistpoc.layers.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.noisyninja.androidlistpoc.model.Me;

import java.util.List;

/**
 * Database data access object
 * Created by sudiptadutta on 30/04/18.
 */

@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM me")
    LiveData<List<Me>> getAll();

    /*
        @Query("SELECT * FROM me where name LIKE  :name")
        LiveData<Me> findById(Name name);
        */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Me customer);

    @Delete
    void delete(Me customer);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Me> customers);

}