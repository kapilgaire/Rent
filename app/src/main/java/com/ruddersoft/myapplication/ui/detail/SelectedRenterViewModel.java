package com.ruddersoft.myapplication.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ruddersoft.myapplication.model.RenterDetails;

public class SelectedRenterViewModel extends ViewModel {
    private final MutableLiveData<RenterDetails> selectedRenter = new MutableLiveData<>();

    public SelectedRenterViewModel() {
    }

    public LiveData<RenterDetails> getSelectedRenter() {
        return selectedRenter;
    }

    public  void setSelectedRenter(RenterDetails renter){
        selectedRenter.setValue(renter);
    }


}
