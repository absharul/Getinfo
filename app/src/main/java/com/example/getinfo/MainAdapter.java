package com.example.getinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<Object> mDetails;
    public MainAdapter(ArrayList<Object> mDetails) {
        mDetails = mDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.mSaved_name.setText((String) mDetails.get(position));
      holder.mSaved_number.setText((Integer) mDetails.get(position));
      holder.mSaved_email.setText((String) mDetails.get(position));

    }

    @Override
    public int getItemCount() {
        return mDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mSaved_name;
        public TextView mSaved_number;
        public TextView mSaved_email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mSaved_name = itemView.findViewById(R.id.dp_name);
            mSaved_number = itemView.findViewById(R.id.dp_number);
            mSaved_email = itemView.findViewById(R.id.dp_email);
        }
    }
}
