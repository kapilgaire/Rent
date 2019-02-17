package com.ruddersoft.myapplication.repo;

import android.app.Application;
import androidx.lifecycle.LiveData;
import android.os.AsyncTask;

import com.ruddersoft.myapplication.dao.RenterDetailDao;
import com.ruddersoft.myapplication.database.AppDatabase;
import com.ruddersoft.myapplication.model.RenterDetails;

import java.util.List;

public class RenterRepository {
    private RenterDetailDao renterDetailDao;

    public RenterRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        renterDetailDao = appDatabase.renterDetailDao();
    }

    public void insert(RenterDetails renterDetails){
        new InsertRenterDetail(renterDetailDao).execute(renterDetails);
    }

    public LiveData<List<RenterDetails>> getAllRenterDetail(){
       return renterDetailDao.getAll();
    }
    private static class InsertRenterDetail extends AsyncTask<RenterDetails, Void, Void> {
        private RenterDetailDao renterDetailDao;

        public InsertRenterDetail(RenterDetailDao renterDetailDao) {
            this.renterDetailDao = renterDetailDao;
        }

        @Override
        protected Void doInBackground(final RenterDetails... renterDetails) {
            renterDetailDao.insert(renterDetails[0]);

            return null;
        }


    }
}
