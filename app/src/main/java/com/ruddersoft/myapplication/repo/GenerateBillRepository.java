package com.ruddersoft.myapplication.repo;

import android.app.Application;
import androidx.lifecycle.LiveData;
import android.os.AsyncTask;

import com.ruddersoft.myapplication.dao.GenerateBillDao;
import com.ruddersoft.myapplication.database.AppDatabase;
import com.ruddersoft.myapplication.model.GenerateBill;

/**
 * Created by kapil gaire on 10-11-2018.
 */

public class GenerateBillRepository {
    private GenerateBillDao generateBillDao;

    public GenerateBillRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        generateBillDao = appDatabase.generateBillDao();

    }

    public void insert(GenerateBill generateBill) {

        new InsertBillDetail(generateBillDao).execute(generateBill);
    }

    public LiveData<GenerateBill> getBillDetailByRoomId(String roomNo) {
        return generateBillDao.getBillDetailByRoomId(roomNo);
    }

    private static class InsertBillDetail extends AsyncTask<GenerateBill, Void, Void> {
        private GenerateBillDao generateBillDao;


        public InsertBillDetail(GenerateBillDao generateBillDao) {
            this.generateBillDao = generateBillDao;
        }

        @Override
        protected Void doInBackground(final GenerateBill... generateBills) {
            generateBillDao.insert(generateBills[0]);

            return null;
        }
    }
}
