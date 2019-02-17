package com.ruddersoft.myapplication.dao;

import com.ruddersoft.myapplication.model.RenterDetails;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface RenterDetailDao {

    @Query("Select * from renterdetails")
    LiveData<List<RenterDetails> >getAll();



    @Insert
    void insert(RenterDetails renterDetails);


    @Update
    void updateRenterDetail(RenterDetails renterDetails);

    @Delete
    void deleteRenterDetail(RenterDetails renterDetails);
}
