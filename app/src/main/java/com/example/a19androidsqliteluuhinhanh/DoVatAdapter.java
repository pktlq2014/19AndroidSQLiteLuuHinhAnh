package com.example.a19androidsqliteluuhinhanh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DoVatAdapter extends BaseAdapter
{
    private Context context;
    private int layout;
    private ArrayList<DoVat> arrayList;

    public DoVatAdapter(Context context, int layout, ArrayList<DoVat> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class viewHolder
    {
        ImageView imageView2;
        TextView textView2, textView3;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        viewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new viewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            viewHolder.textView2 = convertView.findViewById(R.id.textView2);
            viewHolder.textView3 = convertView.findViewById(R.id.textView3);
            viewHolder.imageView2 = convertView.findViewById(R.id.imageView2);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (DoVatAdapter.viewHolder) convertView.getTag();
        }

        DoVat doVat = arrayList.get(position);
        viewHolder.textView2.setText(doVat.getTen());
        viewHolder.textView3.setText(doVat.getMoTa());
        // chuyển byte[] -> bitmap lại
        byte[] hinhAnh = doVat.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh, 0, hinhAnh.length);
        viewHolder.imageView2.setImageBitmap(bitmap);
        return convertView;
    }

}
