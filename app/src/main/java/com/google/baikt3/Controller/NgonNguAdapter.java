package com.google.baikt3.Controller;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.baikt3.Model.NgonNgu;
import com.google.baikt3.R;

import java.util.List;

public class NgonNguAdapter extends BaseAdapter {
    Activity activity;
    List<NgonNgu> ngonNgus;

    public NgonNguAdapter(Activity activity, List<NgonNgu> phepTinhs) {
        this.activity = activity;
        this.ngonNgus = phepTinhs;
    }

    @Override
    public int getCount() {
        return ngonNgus.size();
    }

    @Override
    public Object getItem(int i) {
        return ngonNgus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();

        // Đổ dữ liệu vào biến View, view này chính là những gì nằm trong item_name.xml
        view = inflater.inflate(R.layout.item_ngonngu, null);

        // Đặt chữ cho từng view trong danh sách.
        TextView tvName = (TextView) view.findViewById(R.id.txtNgonNgu);
        ImageView img = (ImageView)view.findViewById(R.id.iconngonngu);
        tvName.setText(ngonNgus.get(i).getTenNgonNgu());
        img.setImageResource(ngonNgus.get(i).getIcon());
        // Trả về view kết quả.
        return view;
    }
}
