package com.ruddersoft.myapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import org.parceler.Parcel;

@Parcel
@Entity
public class RenterDetails {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "renter_id")
    private int renterId;
    @ColumnInfo(name = "renter_unique_id")
    private String renterUniqueId;
    @ColumnInfo(name = "renter_name")
    private String renterName;
    @ColumnInfo(name = "renter_dob")
    private String renterDob;
    @ColumnInfo(name = "renter_alternate_address")
    private String renterAlternateAddress;
    @ColumnInfo(name = "renter_adhar_no")
    private String renterAdharNumber;
    @ColumnInfo(name = "renter_joining_date")
    private String renterJoiningDate;
    @ColumnInfo(name = "room_number")
    private String roomNo;
    @ColumnInfo(name = "is_assigned")
    private boolean isAssigned;

    @NonNull
    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(@NonNull int renterId) {
        this.renterId = renterId;
    }

    public String getRenterUniqueId() {
        return renterUniqueId;
    }

    public void setRenterUniqueId(String renterUniqueId) {
        this.renterUniqueId = renterUniqueId;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getRenterDob() {
        return renterDob;
    }

    public void setRenterDob(String renterDob) {
        this.renterDob = renterDob;
    }

    public String getRenterAlternateAddress() {
        return renterAlternateAddress;
    }

    public void setRenterAlternateAddress(String renterAlternateAddress) {
        this.renterAlternateAddress = renterAlternateAddress;
    }

    public String getRenterAdharNumber() {
        return renterAdharNumber;
    }

    public void setRenterAdharNumber(String renterAdharNumber) {
        this.renterAdharNumber = renterAdharNumber;
    }

    public String getRenterJoiningDate() {
        return renterJoiningDate;
    }

    public void setRenterJoiningDate(String renterJoiningDate) {
        this.renterJoiningDate = renterJoiningDate;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }
}
