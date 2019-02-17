package com.ruddersoft.myapplication.ui.room;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.ruddersoft.myapplication.R;
import com.ruddersoft.myapplication.adapter.RoomDetailAdapter;
import com.ruddersoft.myapplication.adapter.SwipeController;
import com.ruddersoft.myapplication.database.AppDatabase;
import com.ruddersoft.myapplication.model.RoomDetail;
import com.ruddersoft.myapplication.ui.room.add.RoomDetailViewModel;
import com.ruddersoft.myapplication.util.SimpleDividerItemDecoration;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RoomListActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView roomListRv;
    private AppDatabase appDatabase;
    private List<RoomDetail> roomDetailList;
    private RoomDetailAdapter roomDetailAdapter;
    private SwipeController swipeController = null;
    private RoomDetailViewModel roomDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();

        roomDetailViewModel = ViewModelProviders.of(this).get(RoomDetailViewModel.class);
//        swipeController = new SwipeController(new SwipeControllerActions() {
//            @Override
//            public void onLeftClicked(int position) {
//                super.onLeftClicked(position);
//            }
//
//            @Override
//            public void onRightClicked(int position) {
//                roomDetailAdapter.notifyItemRemoved(position);
//                roomDetailAdapter.notifyItemRangeChanged(position, roomDetailAdapter.getItemCount());
//            }
//        });
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation( this,R.anim.layout_anim_fall_down);
        roomDetailAdapter = new RoomDetailAdapter(this);
        roomListRv.setLayoutManager(new LinearLayoutManager(RoomListActivity.this));
        roomListRv.addItemDecoration(new SimpleDividerItemDecoration(this));

        roomListRv.setLayoutAnimation(animationController);
        roomListRv.setAdapter(roomDetailAdapter);

//        itemTouchHelper.attachToRecyclerView(roomListRv);
//        roomListRv.addItemDecoration(new RecyclerView.ItemDecoration() {
//            @Override
//            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//                swipeController.onDraw(c);
//            }
//        });

            roomDetailViewModel.getAllRoomDetail().observe(this, new Observer<List<RoomDetail>>() {
                @Override
                public void onChanged(@Nullable List<RoomDetail> roomDetails) {
                    roomDetailAdapter.setRoomDetail(roomDetails);
                }
            });

    }


    private void initViews() {
        roomListRv = findViewById(R.id.room_list_rv_content_room_list);
    }


}
