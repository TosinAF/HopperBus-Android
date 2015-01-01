package io.creativecode.hopperbus.views.adapters;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import io.creativecode.hopperbus.R;

public class RouteAdapter extends BaseAdapter {

    private int type;
    private Context mContext;
    private LayoutInflater mInflater;

    public RouteAdapter(Context context, LayoutInflater inflater, int type) {
        this.type = type;
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

            convertView = mInflater.inflate(R.layout.route_stop, null);

            holder = new ViewHolder();
            holder.timeTextView = (TextView) convertView.findViewById(R.id.text_time);
            holder.circleView = convertView.findViewById(R.id.circle);
            holder.lineView = convertView.findViewById(R.id.line);
            holder.stopNameTextView = (TextView) convertView.findViewById(R.id.text_stop_name);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        int circleDrawableID = position == 0 ? R.drawable.circle_filled  : R.drawable.circle_empty;

        // Will refactor into method later

        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            holder.circleView.setBackgroundDrawable(mContext.getResources().getDrawable(circleDrawableID));
        } else {
            holder.circleView.setBackground(mContext.getResources().getDrawable(circleDrawableID));
        }

        int lineViewHeightDP = position == 9 ? 35 : 65 ;
        int lineViewHeightPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, lineViewHeightDP, mContext.getResources().getDisplayMetrics());

        holder.lineView.getLayoutParams().height = lineViewHeightPixels;

        return convertView;
    }

    private static class ViewHolder {
        public TextView timeTextView;
        public View circleView;
        public View lineView;
        public TextView stopNameTextView;
    }

    @Override
    public String getItem(int position) {
        return String.valueOf(type);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
