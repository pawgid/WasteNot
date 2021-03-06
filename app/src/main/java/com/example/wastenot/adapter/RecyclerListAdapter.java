package com.example.wastenot.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wastenot.activities.MainActivity;
import com.example.wastenot.R;
import com.example.wastenot.activities.DescriptionActivity;
import com.example.wastenot.model.RetroList;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.CustomViewHolder> {

    private List<RetroList> dataList;
    private Context context;
    public MainActivity mainActivity;

    public RecyclerListAdapter(Context context, List<RetroList> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final View mView;

        TextView txtTitle;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            itemView.setOnClickListener(this);

            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.coverImage);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick " + getPosition() + " " + mView);
            Toast.makeText(context, "You clicked item number: " + getAdapterPosition() + "\n" + "Total items: " + getItemCount(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), DescriptionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("TITLE", dataList.get(getAdapterPosition()).getTitle());
            bundle.putString("IMAGE_URL", dataList.get(getAdapterPosition()).getUrl());
            bundle.putInt("ID", dataList.get(getAdapterPosition()).getId());
            intent.putExtras(bundle);
            v.getContext().startActivity(intent);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());

        Picasso.Builder builder = new Picasso.Builder(context);
//        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}


