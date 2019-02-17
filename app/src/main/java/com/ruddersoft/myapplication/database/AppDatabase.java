package com.ruddersoft.myapplication.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.ruddersoft.myapplication.dao.GenerateBillDao;
import com.ruddersoft.myapplication.dao.RenterDetailDao;
import com.ruddersoft.myapplication.dao.RoomDetailDao;
import com.ruddersoft.myapplication.model.GenerateBill;
import com.ruddersoft.myapplication.model.RenterDetails;
import com.ruddersoft.myapplication.model.RoomDetail;

@Database(entities = {RenterDetails.class, RoomDetail.class, GenerateBill.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "rent_db";

    public abstract RenterDetailDao renterDetailDao();

    public abstract RoomDetailDao roomDetailDao();

     public abstract GenerateBillDao generateBillDao();

    private static AppDatabase appDatabase;

    public static AppDatabase getDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .build();

        }
        return appDatabase;
    }

    public static void destroyRenterDetailDatabase() {
        appDatabase = null;
    }
}
