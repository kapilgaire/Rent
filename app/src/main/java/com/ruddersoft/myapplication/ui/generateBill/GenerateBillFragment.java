package com.ruddersoft.myapplication.ui.generateBill;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ruddersoft.myapplication.R;
import com.ruddersoft.myapplication.ui.detail.SelectedRenterViewModel;
import com.ruddersoft.myapplication.ui.room.add.RoomDetailViewModel;
import com.ruddersoft.myapplication.viewModel.GenerateBillViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GenerateBillFragment extends Fragment {
    private Unbinder unbinder;

    @BindView(R.id.month_spinner_content_generate_bill)
     Spinner monthSpinnerContentGenerateBill;

    @BindView(R.id.prev_reading_et_content_generate_bill)
     EditText prevReadingEtContentGenerateBill;

    @BindView(R.id.current_reading_et_content_generate_bill)
     EditText currentReadingEtContentGenerateBill;

    @BindView(R.id.total_unit_txv_content_generate_bill)
     TextView totalUnitTxvContentGenerateBill;

    @BindView(R.id.rate_per_unit_txv_content_generate_bill)
     TextView ratePerUnitTxvContentGenerateBill;

    @BindView(R.id.electricity_amt_txv_content_generate_bill)
     TextView electricityAmtTxvContentGenerateBill;

    @BindView(R.id.room_rent_txv_content_generate_bill)
     TextView roomRentTxvContentGenerateBill;

    @BindView(R.id.balance_txv_content_generate_bill)
     TextView balanceTxvContentGenerateBill;

    @BindView(R.id.total_payable_txv_content_generate_bill)
     TextView totalPayableTxvContentGenerateBill;

    @BindView(R.id.amount_received_content_generate_bill)
     EditText amountReceivedContentGenerateBill;


    private RoomDetailViewModel roomDetailViewModel;
    private GenerateBillViewModel generateBillViewModel;
    private SelectedRenterViewModel selectedRenterViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.generate_bill_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        roomDetailViewModel = ViewModelProviders.of(this).get(RoomDetailViewModel.class);
        generateBillViewModel = ViewModelProviders.of(this).get(GenerateBillViewModel.class);
        selectedRenterViewModel = ViewModelProviders.of(getActivity()).get(SelectedRenterViewModel.class);

        selectedRenterViewModel.getSelectedRenter().observe(this, renterDetails -> {
            if (renterDetails != null) {
                generateBillViewModel.getBillDetailByRoomId(renterDetails.getRoomNo()).observe(this, generateBill -> {
                    if (generateBill != null) {
                        prevReadingEtContentGenerateBill.setText(String.valueOf(generateBill.getPrevReading()));
                        balanceTxvContentGenerateBill.setText("Balance " + String.valueOf(generateBill.getBalanceAmt()));
                    }
                });

                roomDetailViewModel.getRoomById(renterDetails.getRoomNo()).observe(this, roomDetail -> {


                    if (roomDetail != null) {
                        roomRentTxvContentGenerateBill.setText("Room Rent:-" + String.valueOf(roomDetail.getRoomRent()));
                        ratePerUnitTxvContentGenerateBill.setText("Electricity Rate per unit :- " + String.valueOf(roomDetail.getRoomElectricityRatePerUnit()));
                    }
                });
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
