package com.ruddersoft.myapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity
public class GenerateBill {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "room_number")
    private String roomNo;

    @ColumnInfo(name = "renter_unique_id")
    private String renterUniqueId;

    @ColumnInfo(name = "billing_month")
    private String billingMonth;

    @ColumnInfo(name = "prev_reading")
    private float prevReading;

    @ColumnInfo(name = "current_reading")
    private float currentReading;

    @ColumnInfo(name = "total_unit_per_month")
    private float totalUnitPerMonth;

    @ColumnInfo(name = "electricity_amt_per_month")
    private float electricityAmtPerMonth;

    @ColumnInfo(name = "balance_amt")
    private float balanceAmt;

    @ColumnInfo(name = "total_amt_payable")
    private float TotalAmtPayable;

    @ColumnInfo(name = "amount_received")
    private float amountReceived;

    @ColumnInfo(name = "remarks")
    private String remarks;

    @ColumnInfo(name = "bill_creation_date")
    private String billCreationDate;


    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getBillingMonth() {
        return billingMonth;
    }

    public void setBillingMonth(String billingMonth) {
        this.billingMonth = billingMonth;
    }

    public float getPrevReading() {
        return prevReading;
    }

    public void setPrevReading(float prevReading) {
        this.prevReading = prevReading;
    }

    public float getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(float currentReading) {
        this.currentReading = currentReading;
    }

    public float getTotalUnitPerMonth() {
        return totalUnitPerMonth;
    }

    public void setTotalUnitPerMonth(float totalUnitPerMonth) {
        this.totalUnitPerMonth = totalUnitPerMonth;
    }

    public float getElectricityAmtPerMonth() {
        return electricityAmtPerMonth;
    }

    public void setElectricityAmtPerMonth(float electricityAmtPerMonth) {
        this.electricityAmtPerMonth = electricityAmtPerMonth;
    }

    public float getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(float balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public float getTotalAmtPayable() {
        return TotalAmtPayable;
    }

    public void setTotalAmtPayable(float totalAmtPayable) {
        TotalAmtPayable = totalAmtPayable;
    }

    public float getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(float amountReceived) {
        this.amountReceived = amountReceived;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRenterUniqueId() {
        return renterUniqueId;
    }

    public String getBillCreationDate() {
        return billCreationDate;
    }

    public void setBillCreationDate(String billCreationDate) {
        this.billCreationDate = billCreationDate;
    }

    public void setRenterUniqueId(String renterUniqueId) {

        this.renterUniqueId = renterUniqueId;
    }
}
