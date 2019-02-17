package com.ruddersoft.myapplication.viewModel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import com.ruddersoft.myapplication.model.GenerateBill;
import com.ruddersoft.myapplication.repo.GenerateBillRepository;

/**
 * Created by kapil gaire on 10-11-2018.
 */

public class GenerateBillViewModel extends AndroidViewModel {

    private GenerateBillRepository generateBillRepository;

    public GenerateBillViewModel(@NonNull Application application) {
        super(application);
        generateBillRepository = new GenerateBillRepository(application);
    }

    public void insert(GenerateBill generateBill) {
        generateBillRepository.insert(generateBill);
    }

    public LiveData<GenerateBill> getBillDetailByRoomId(String roomNo) {
        return generateBillRepository.getBillDetailByRoomId(roomNo);
    }
}
