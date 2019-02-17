package com.ruddersoft.myapplication.ui.room.add;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import com.ruddersoft.myapplication.model.RoomDetail;
import com.ruddersoft.myapplication.repo.RoomRepository;

import java.util.List;

public class RoomDetailViewModel extends AndroidViewModel {
    private RoomRepository roomRepository;

    public RoomDetailViewModel(@NonNull Application application) {
        super(application);
        roomRepository = new RoomRepository(application);

    }

    public LiveData<List<RoomDetail>> getAllRoomDetail() {
        return roomRepository.getAllRoom();

    }

    public void insert(RoomDetail roomDetail) {
        roomRepository.insert(roomDetail);
    }

    public LiveData<RoomDetail> getRoomById(String roomNo) {
      return   roomRepository.getRoomById(roomNo);
    }

    public LiveData<List<String>> getAllRoomNo(){
        return roomRepository.getAllRoomNo();
    }

}
