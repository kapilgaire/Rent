package com.ruddersoft.myapplication.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ruddersoft.myapplication.model.RoomDetail;

import java.util.List;

@Dao
public interface RoomDetailDao {

    @Query("Select * from roomdetail")
    LiveData<List<RoomDetail>> getAll();

    @Query("Select room_number from roomdetail")
    LiveData<List<String>> getAllRoomNo();


    @Query("Select * from roomdetail where room_number =:roomNumber")
    LiveData<RoomDetail> fetchRoomById(String roomNumber);

    @Insert
    void insert(RoomDetail roomDetail);

    @Update
    void update(RoomDetail roomDetail);

    @Delete
    void delete(RoomDetail roomDetail);

}
