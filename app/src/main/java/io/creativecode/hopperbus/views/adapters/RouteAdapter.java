package io.creativecode.hopperbus.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import io.creativecode.hopperbus.R;

public class RouteAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;

    public RouteAdapter(Context context, LayoutInflater inflater) {
        mContext = context;
        mInflater = inflater;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public String getItem(int position) {
        return "x";
    }

    @Override
    public long getItemId(int position) {
        // your particular dataset uses String IDs
        // but you have to put something in this method
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.route_stop, null);

            holder = new ViewHolder();
            holder.timeTextView = (TextView) convertView.findViewById(R.id.text_time);
            holder.circleView = convertView.findViewById(R.id.circle);
            holder.stopNameTextView = (TextView) convertView.findViewById(R.id.text_stop_name);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        int circleDrawableID = position == 0 ? R.drawable.circle_filled  : R.drawable.circle_empty;

        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            holder.circleView.setBackgroundDrawable( mContext.getResources().getDrawable(circleDrawableID));
        } else {
            holder.circleView.setBackground(mContext.getResources().getDrawable(circleDrawableID));
        }

        return convertView;
    }

    private static class ViewHolder {
        public TextView timeTextView;
        public View circleView;
        public TextView stopNameTextView;
    }
}
