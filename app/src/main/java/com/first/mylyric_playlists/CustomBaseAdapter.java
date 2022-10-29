package com.first.mylyric_playlists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String plNames[];
    String plDesc[];
    String plCreated[];
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, String[] plNames, String[] plDesc, String[] plCreated) {
        this.context = ctx;
        this.plNames = plNames;
        this.plDesc = plDesc;
        this.plCreated = plCreated;
        inflater = LayoutInflater.from(ctx);


    }

    @Override
    public int getCount() {
        return plNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view,null);
        TextView txtView = (TextView) convertView.findViewById(R.id.listTitle2);
        TextView desc = (TextView) convertView.findViewById(R.id.listDetails2);
        TextView create = (TextView) convertView.findViewById(R.id.listCreated2);
        txtView.setText(plNames[position]);
        desc.setText(plDesc[position]);
        create.setText(plCreated[position]);
        return convertView;
    }
}
