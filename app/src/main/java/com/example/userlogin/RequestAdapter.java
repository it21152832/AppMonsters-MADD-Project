package com.example.userlogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.userlogin.ui.RequestType;

import java.util.List;

public class RequestAdapter extends BaseAdapter{
    private Context context;
    private List<RequestType> list;

    public RequestAdapter(Context context, List<RequestType> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_request, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.spinner);

        txtName.setText(list.get(i).getName());

        return rootView;
    }
}
