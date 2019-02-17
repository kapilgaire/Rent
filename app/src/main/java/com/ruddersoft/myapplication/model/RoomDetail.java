package com.ruddersoft.myapplication.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomDetail {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "room_id")
    private int roomId;
    @ColumnInfo(name = "room_number")
    private String roomNo;
    @ColumnInfo(name = "room_rent")
    private float roomRent;
    @ColumnInfo(name = "room_electricity_rate_per_unit")
    private float roomElectricityRatePerUnit;
    @ColumnInfo(name = "creation_date")
    private String crDate;


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCrDate() {
        return crDate;
    }

    public void setCrDate(String crDate) {
        this.crDate = crDate;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public float getRoomElectricityRatePerUnit() {
        return roomElectricityRatePerUnit;
    }

    public void setRoomElectricityRatePerUnit(float roomElectricityRatePerUnit) {
        this.roomElectricityRatePerUnit = roomElectricityRatePerUnit;
    }

    public float getRoomRent() {
        return roomRent;
    }

    public void setRoomRent(float roomRent) {
        this.roomRent = roomRent;
    }


}
