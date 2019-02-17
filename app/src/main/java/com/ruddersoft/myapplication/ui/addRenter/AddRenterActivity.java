package com.ruddersoft.myapplication.ui.addRenter;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ruddersoft.myapplication.R;
import com.ruddersoft.myapplication.model.RenterDetails;
import com.ruddersoft.myapplication.ui.room.add.RoomDetailViewModel;
import com.ruddersoft.myapplication.util.AppConstant;
import com.ruddersoft.myapplication.util.ValidationUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddRenterActivity extends AppCompatActivity {


    @BindView(R.id.renter_photo_iv_add_renter)
     ImageView renterPhotoIvAddRenter;

    @BindView(R.id.renter_full_name_et_add_renter)
     EditText renterFullNameEtAddRenter;

    @BindView(R.id.renter_address_et_add_renter)
     EditText renterAddressEtAddRenter;

    @BindView(R.id.renter_adhar_et_add_renter)
     EditText renterAdharEtAddRenter;

    @BindView(R.id.renter_joining_date_tv_add_renter)
     TextView renterJoiningDateTvAddRenter;

    @BindView(R.id.renter_dob_tv_add_renter)
     TextView renterDobTvAddRenter;

    @BindView(R.id.room_list_spinner_activity_add_renter)
     Spinner roomListSpinnerActivityAddRenter;



    Calendar myCalendar = Calendar.getInstance();

    private RenterViewModel renterViewModel;
    private RoomDetailViewModel roomDetailViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_renter);
        ButterKnife.bind(this);
        roomListSpinnerActivityAddRenter.setOnItemSelectedListener(onItemSelectedListener);

        renterViewModel = ViewModelProviders.of(this).get(RenterViewModel.class);
        roomDetailViewModel = ViewModelProviders.of(this).get(RoomDetailViewModel.class);



        roomDetailViewModel.getAllRoomNo().observe(this, roomNoList -> {
             ArrayAdapter<String> roomNoListAdapter= new ArrayAdapter<String>(AddRenterActivity.this, android.R.layout.simple_spinner_item, roomNoList);
            roomNoListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            roomListSpinnerActivityAddRenter.setAdapter(roomNoListAdapter);

        });
    }


    DatePickerDialog.OnDateSetListener dobDate = (view, year, monthOfYear, dayOfMonth) -> {


        // TODO Auto-generated method stub
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateRenterDob();
    };
    DatePickerDialog.OnDateSetListener dateOfJoiningDate = (view, year, monthOfYear, dayOfMonth) -> {


        // TODO Auto-generated method stub
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateRenterDateOfJoining();
    };

    private void updateRenterDateOfJoining() {
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstant.DATE_TIME_FORMAT_DISPLAY, Locale.US);

        renterJoiningDateTvAddRenter.setText(sdf.format(myCalendar.getTime()));
    }


    private void updateRenterDob() {
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstant.DATE_FORMAT_DISPLAY, Locale.US);

        renterDobTvAddRenter.setText(sdf.format(myCalendar.getTime()));
    }


    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            String item = adapterView.getItemAtPosition(position).toString();

            // Showing selected spinner item
//            Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    @OnClick(R.id.renter_dob_tv_add_renter)
    void onDOBClick() {
        new DatePickerDialog(AddRenterActivity.this, dobDate, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.renter_joining_date_tv_add_renter)
    void onJoiningDateClick() {
        new DatePickerDialog(AddRenterActivity.this, dateOfJoiningDate, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.submit_btn_add_renter)
     void onSubmitClick() {
        String name = renterFullNameEtAddRenter.getText().toString();
        String address = renterAddressEtAddRenter.getText().toString();
        String adhaar = renterAdharEtAddRenter.getText().toString();
        String roomNo = roomListSpinnerActivityAddRenter.getSelectedItem().toString();
        String renterDob = renterDobTvAddRenter.getText().toString();
        String renterJoiningDate = renterJoiningDateTvAddRenter.getText().toString();
        if (!ValidationUtil.nameValidation(name)) {
            renterFullNameEtAddRenter.setError("Enter Valid Name");

        } else if (!ValidationUtil.addressValidation(address)) {
            renterAddressEtAddRenter.setError("Enter valid address");
        } else if (!ValidationUtil.adharNumberValidation(adhaar)) {

            renterAdharEtAddRenter.setError("Enter Valid Adhaar number");
        } else if (TextUtils.isEmpty(renterDob)) {
            renterDobTvAddRenter.setError("Enter Date of Birth");
        } else if (TextUtils.isEmpty(renterJoiningDate)) {
            renterJoiningDateTvAddRenter.setError("Enter Joining Date");
        } else {
            RenterDetails renterDetails = new RenterDetails();
            renterDetails.setRenterAdharNumber(adhaar);
            renterDetails.setRenterAlternateAddress(address);
            renterDetails.setRenterDob(renterDob);
            renterDetails.setRenterJoiningDate(renterJoiningDate);
            renterDetails.setRenterName(name);
            renterDetails.setRoomNo(roomNo);
            Toast.makeText(this, roomNo, Toast.LENGTH_SHORT).show();

            renterViewModel.insert(renterDetails);
        }

    }



}
