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
import com.ruddersoft.myapplication.model.RenterDetails;

import java.util.List;

public class RenterDetailAdapter extends RecyclerView.Adapter<RenterDetailAdapter.MyViewHolder> {

    private Context context;
    private List<RenterDetails> renterDetailsList;

    public RenterDetailClickListener renterDetailClickListener;

    public void setRenterDetailClickListener(RenterDetailClickListener renterDetailClickListener) {
        this.renterDetailClickListener = renterDetailClickListener;
    }

    public RenterDetailAdapter(Context context, List<RenterDetails> renterDetailsList) {
        this.context = context;
        this.renterDetailsList = renterDetailsList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView renterIvDetailLayout;
        private TextView renterNameTvDetailLayout;


        public MyViewHolder(View view) {
            super(view);
            renterIvDetailLayout = view.findViewById(R.id.renter_iv_detail_layout);
            renterNameTvDetailLayout = view.findViewById(R.id.renter_name_tv_detail_layout);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (renterDetailClickListener != null) {
                        renterDetailClickListener.onRenterSelected(renterDetailsList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.renter_detail_layout, parent, false);
        return new RenterDetailAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RenterDetails renterDetails = renterDetailsList.get(position);

        holder.renterNameTvDetailLayout.setText(renterDetails.getRenterName());

    }

    @Override
    public int getItemCount() {
        return renterDetailsList.size();
    }

    public interface RenterDetailClickListener {
        void onRenterSelected(RenterDetails renterDetails);
    }
}
