package com.ruddersoft.myapplication.ui.renterList;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.PopupMenu;

import com.ruddersoft.myapplication.R;
import com.ruddersoft.myapplication.adapter.RenterDetailAdapter;
import com.ruddersoft.myapplication.ui.addRenter.AddRenterActivity;
import com.ruddersoft.myapplication.ui.addRenter.RenterViewModel;
import com.ruddersoft.myapplication.ui.detail.RenterActivity;
import com.ruddersoft.myapplication.ui.room.RoomListActivity;
import com.ruddersoft.myapplication.ui.room.add.AddRoomActivity;
import com.ruddersoft.myapplication.util.AppConstant;
import com.ruddersoft.myapplication.util.SimpleDividerItemDecoration;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RenterListActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @BindView(R.id.toolbar_renter_list)
     Toolbar toolbar;

    @BindView(R.id.renter_list_rv)
     RecyclerView renterListRv;

    private RenterViewModel renterViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


        renterViewModel = ViewModelProviders.of(this).get(RenterViewModel.class);
        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(this, R.anim.layoout_anim_from_bottom);
        renterListRv.setLayoutManager(new LinearLayoutManager(RenterListActivity.this));
        renterListRv.addItemDecoration(new SimpleDividerItemDecoration(this));
        renterListRv.setLayoutAnimation(animationController);


        renterViewModel.getAllRenterDetail().observe(this, renterDetails -> {

            if (renterDetails != null) {
                RenterDetailAdapter renterDetailAdapter = new RenterDetailAdapter(this, renterDetails);
                renterListRv.setAdapter(renterDetailAdapter);
                renterDetailAdapter.setRenterDetailClickListener(renterDetailClickListner);
            }

        });


    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.add_renter:
                startActivity(new Intent(RenterListActivity.this, AddRenterActivity.class));
                return true;
            case R.id.add_room:
                startActivity(new Intent(RenterListActivity.this, AddRoomActivity.class));
                return true;
            case R.id.room_list_Detail:
                startActivity(new Intent(RenterListActivity.this, RoomListActivity.class));
                return true;

        }
        return true;
    }




    RenterDetailAdapter.RenterDetailClickListener renterDetailClickListner = renterDetails -> {


        Intent intent = new Intent(RenterListActivity.this, RenterActivity.class);
        intent.putExtra(AppConstant.RENTER_DETAIL, Parcels.wrap(renterDetails));
        startActivity(intent);
    };

    @OnClick(R.id.fab)
     void OnFabClick(View view) {
        PopupMenu popupMenu = new PopupMenu(RenterListActivity.this, view);
        popupMenu.setOnMenuItemClickListener(RenterListActivity.this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }


}
