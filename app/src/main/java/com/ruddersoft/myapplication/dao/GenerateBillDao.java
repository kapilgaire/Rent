package com.ruddersoft.myapplication.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ruddersoft.myapplication.model.GenerateBill;

import java.util.List;

@Dao
public interface GenerateBillDao {

    @Query("Select * from generatebill")
    List<GenerateBill> getAll();

    @Query("Select * from generatebill where room_number =:roomNumber order by bill_creation_date desc")
    LiveData<GenerateBill> getBillDetailByRoomId(String roomNumber);

    @Insert
    void insert(GenerateBill generateBill);

    @Update
    void update(GenerateBill generateBill);

    @Delete
    void delete(GenerateBill generateBill);
}
