package com.example.secondpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NoticesAdapter extends ArrayAdapter<Notices> {

    Context context;
    List<Notices> arrayListNotices;


    public NoticesAdapter(@NonNull Context context, List<Notices> arrayListNotices) {
        super(context, R.layout.custom_notices_item,arrayListNotices);

        this.context = context;
        this.arrayListNotices = arrayListNotices;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_notices_item,null,true);

        TextView Id = view.findViewById(R.id.Id);
        TextView Title = view.findViewById(R.id.Title);
        TextView Desc = view.findViewById(R.id.Desc);
        TextView Date = view.findViewById(R.id.date);

        Id.setText(arrayListNotices.get(position).getId());
        Title.setText(arrayListNotices.get(position).getTitle());
        Desc.setText(arrayListNotices.get(position).getDesc());
        Date.setText(arrayListNotices.get(position).getDate());


        return view;
    }
}
