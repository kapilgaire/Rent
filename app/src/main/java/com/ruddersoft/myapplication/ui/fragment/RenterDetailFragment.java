package com.ruddersoft.myapplication.ui.fragment;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ruddersoft.myapplication.R;
import com.ruddersoft.myapplication.ui.detail.SelectedRenterViewModel;
import com.ruddersoft.myapplication.ui.generateBill.GenerateBillFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RenterDetailFragment extends Fragment {

    private Unbinder unbinder;

    @BindView(R.id.renter_unique_id_et_content_renter_detail)
    EditText renterUniqueIdEtContentRenterDetail;

    @BindView(R.id.renter_name_et_content_renter_detail)
    EditText renterNameEtContentRenterDetail;

    @BindView(R.id.renter_dob_et_content_renter_detail)
    EditText renterDobEtContentRenterDetail;

    @BindView(R.id.renter_address_et_content_renter_detail)
    EditText renterAddressEtContentRenterDetail;

    @BindView(R.id.adhar_no_et_content_renter_detail)
    EditText adharNoEtContentRenterDetail;

    @BindView(R.id.joining_date_et_content_renter_detail)
    EditText joiningDateEtContentRenterDetail;

    @BindView(R.id.room_no_txv_content_renter_detail)
    TextView roomNoTxvContentRenterDetail;


    private SelectedRenterViewModel selectedRenterViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.renter_detail_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        selectedRenterViewModel = ViewModelProviders.of(getActivity()).get(SelectedRenterViewModel.class);


        displayRenterDetail();
    }

    @OnClick(R.id.generate_bill_btn_content_renter_detail)
    void onClickGenerateBill() {

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.screen_container, new GenerateBillFragment())
                .addToBackStack(null)
                .commit();

    }

    private void displayRenterDetail() {
        selectedRenterViewModel.getSelectedRenter().observe(this, renterDetails -> {
            if (renterDetails != null) {
                renterUniqueIdEtContentRenterDetail.setText(renterDetails.getRenterUniqueId());
                renterNameEtContentRenterDetail.setText(renterDetails.getRenterName());
                renterDobEtContentRenterDetail.setText(renterDetails.getRenterDob());
                renterAddressEtContentRenterDetail.setText(renterDetails.getRenterAlternateAddress());
                adharNoEtContentRenterDetail.setText(renterDetails.getRenterAdharNumber());
                joiningDateEtContentRenterDetail.setText(renterDetails.getRenterJoiningDate());
                roomNoTxvContentRenterDetail.setText(renterDetails.getRoomNo());
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

