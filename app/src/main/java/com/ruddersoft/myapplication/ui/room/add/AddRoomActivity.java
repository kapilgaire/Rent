package com.ruddersoft.myapplication.ui.room.add;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.ruddersoft.myapplication.R;
import com.ruddersoft.myapplication.model.RoomDetail;
import com.ruddersoft.myapplication.util.DateTimeUtil;
import com.ruddersoft.myapplication.util.ValidationUtil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddRoomActivity extends AppCompatActivity {

    @BindView(R.id.room_no_et_content_add_room)
    EditText roomNoEt;

    @BindView(R.id.room_no_til)
    TextInputLayout roomNoTil;

    @BindView(R.id.room_rent_til)
    TextInputLayout roomRentTil;

    @BindView(R.id.electricity_rate_til)
    TextInputLayout elecRateTil;

    @BindView(R.id.room_rent_et_content_add_room)
    EditText roomRentEt;

    @BindView(R.id.electrcity_rate_et_content_add_room)
    EditText electrcityRateEt;

    @BindView(R.id.toolbar_add_room)
    Toolbar toolbar;


    private RoomDetailViewModel roomDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        roomDetailViewModel = ViewModelProviders.of(this).get(RoomDetailViewModel.class);


    }


    @OnClick(R.id.submit_btn_content_add_room)
    void onSubmitClick() {
        RoomDetail roomDetail = new RoomDetail();

        String roomNo = roomNoEt.getText().toString();
        String roomRent = roomRentEt.getText().toString();
        String roomRate = electrcityRateEt.getText().toString();

        if (!ValidationUtil.isValidRoomNo(roomNo)) {
//            ToastUtil.showToast(this, "Enter Valid Room Number");

            roomNoTil.setError("Enter valid room number");

        } else if (TextUtils.isEmpty(roomRent)) {
            roomRentTil.setError("Enter valid room rent");

        } else if (TextUtils.isEmpty(roomRate)) {
            elecRateTil.setError("Enter valid room rate");

        } else {
            roomNoTil.setError(null);
            roomRentTil.setError(null);
            elecRateTil.setError(null);

            roomDetail.setRoomNo(roomNo);
            roomDetail.setCrDate(DateTimeUtil.getCurrentDateTime());
            roomDetail.setRoomRent(Float.parseFloat(roomRent));
            roomDetail.setRoomElectricityRatePerUnit(Float.parseFloat(roomRate));
            roomDetailViewModel.insert(roomDetail);
        }

    }

    @OnClick(R.id.cancel_btn_content_add_room)
    void onCancelClick() {

        onBackPressed();

    }


}
