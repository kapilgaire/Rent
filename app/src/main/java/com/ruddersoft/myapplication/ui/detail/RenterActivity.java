package com.ruddersoft.myapplication.ui.detail;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ruddersoft.myapplication.R;
import com.ruddersoft.myapplication.model.RenterDetails;
import com.ruddersoft.myapplication.ui.fragment.RenterDetailFragment;
import com.ruddersoft.myapplication.util.AppConstant;

import org.parceler.Parcels;

import butterknife.BindView;

public class RenterActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_renter_detail)
    Toolbar toolbar;

    private RenterDetails renterDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_detail);
        renterDetails = Parcels.unwrap(getIntent().getParcelableExtra(AppConstant.RENTER_DETAIL));
        setSupportActionBar(toolbar);

         SelectedRenterViewModel selectedRenterViewModel
         = ViewModelProviders.of(this).get(SelectedRenterViewModel.class);

        selectedRenterViewModel.setSelectedRenter(renterDetails);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.screen_container, new RenterDetailFragment())
                    .commit();
        }

    }




}
