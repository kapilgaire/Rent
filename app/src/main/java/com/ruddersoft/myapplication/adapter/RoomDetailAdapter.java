package com.ruddersoft.myapplication.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ruddersoft.myapplication.R;
import com.ruddersoft.myapplication.model.RoomDetail;

import java.util.List;

public class RoomDetailAdapter extends RecyclerView.Adapter<RoomDetailAdapter.MyViewHolder> {

    private Context context;
    private List<RoomDetail> roomDetailList;


    public RoomDetailAdapter(Context context) {
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView roomIvRoomDetailLayout;
        private TextView roomNoTvRoomDetailLayout;


        public MyViewHolder(View view) {
            super(view);
            roomIvRoomDetailLayout = view.findViewById(R.id.room_iv_room_detail_layout);
            roomNoTvRoomDetailLayout = view.findViewById(R.id.room_no_tv_room_detail_layout);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_detail_layout, parent, false);

        return new RoomDetailAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (roomDetailList != null) {
            RoomDetail roomDetail = roomDetailList.get(position);

            holder.roomNoTvRoomDetailLayout.setText(roomDetail.getRoomNo());
        }

    }

    @Override
    public int getItemCount() {
        if (roomDetailList != null)
            return roomDetailList.size();
        else
            return 0;
    }

    public void setRoomDetail(List<RoomDetail> roomDetailList) {
        this.roomDetailList = roomDetailList;
        notifyDataSetChanged();

    }
}
