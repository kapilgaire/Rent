package com.ruddersoft.myapplication.repo;

import android.app.Application;
import androidx.lifecycle.LiveData;
import android.os.AsyncTask;

import com.ruddersoft.myapplication.dao.RoomDetailDao;
import com.ruddersoft.myapplication.database.AppDatabase;
import com.ruddersoft.myapplication.model.RoomDetail;

import java.util.List;

public class   RoomRepository {
    private RoomDetailDao roomDetailDao;

    public RoomRepository(Application application) {


        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        roomDetailDao = appDatabase.roomDetailDao();


    }

    public LiveData<List<RoomDetail>> getAllRoom() {
        return roomDetailDao.getAll();
    }

    public LiveData<List<String>> getAllRoomNo(){
        return roomDetailDao.getAllRoomNo();
    }

    public void insert(RoomDetail roomDetail) {

        new InsertRoomDetail(roomDetailDao).execute(roomDetail);
    }

    public LiveData<RoomDetail> getRoomById(String roomNo) {
        return roomDetailDao.fetchRoomById(roomNo);
    }

    private static class InsertRoomDetail extends AsyncTask<RoomDetail, Void, Void> {
        private RoomDetailDao roomDetailDao;

        public InsertRoomDetail(RoomDetailDao roomDetailDao) {
            this.roomDetailDao = roomDetailDao;
        }

        @Override
        protected Void doInBackground(final RoomDetail... roomDetails) {
            roomDetailDao.insert(roomDetails[0]);

            return null;
        }


    }
}
