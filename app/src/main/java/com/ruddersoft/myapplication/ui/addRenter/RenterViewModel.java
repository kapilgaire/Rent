package com.ruddersoft.myapplication.ui.addRenter;

import android.app.Application;

import com.ruddersoft.myapplication.model.RenterDetails;
import com.ruddersoft.myapplication.repo.RenterRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class RenterViewModel extends AndroidViewModel {

    private RenterRepository renterRepository;

    public RenterViewModel(@NonNull Application application) {
        super(application);
        renterRepository = new RenterRepository(application);
    }

    public void insert(RenterDetails renterDetails) {

        renterRepository.insert(renterDetails);
    }

    public LiveData<List<RenterDetails>> getAllRenterDetail(){
        return renterRepository.getAllRenterDetail();
    }
}
