package com.example.secondpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NoticeAdapter extends ArrayAdapter<Notice> {

    Context context;
    List<Notice> arrayListNotice;
    public NoticeAdapter(@NonNull Context context, List<Notice> arrayListNotice) {
        super(context, R.layout.list_item,arrayListNotice);

        this.context = context;
        this.arrayListNotice = arrayListNotice;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null,true);

        TextView Id = view.findViewById(R.id.Id);
        TextView Title = view.findViewById(R.id.Title);
        TextView Desc = view.findViewById(R.id.Desc);
        TextView Date = view.findViewById(R.id.date);

        Id.setText(arrayListNotice.get(position).getId());
        Title.setText(arrayListNotice.get(position).getTitle());
        Desc.setText(arrayListNotice.get(position).getDesc());
        Date.setText(arrayListNotice.get(position).getDate());


        return view;
    }
}
