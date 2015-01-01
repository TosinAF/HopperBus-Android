package io.creativecode.hopperbus.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import io.creativecode.hopperbus.R;

public class RouteStopTimesAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;

    public RouteStopTimesAdapter(Context context, LayoutInflater inflater) {
        mContext = context;
        mInflater = inflater;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.route_stop_times, null);

            holder = new ViewHolder();
            holder.stopName = (TextView) convertView.findViewById(R.id.text_time);
            holder.stopTime1 = (TextView) convertView.findViewById(R.id.text_time1);
            holder.stopTime2 = (TextView) convertView.findViewById(R.id.text_time2);
            holder.stopTime3 = (TextView) convertView.findViewById(R.id.text_time3);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    private static class ViewHolder {
        public TextView stopName;
        public TextView stopTime1;
        public TextView stopTime2;
        public TextView stopTime3;
    }

    @Override
    public String getItem(int position) {
        return "";
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
