package io.creativecode.hopperbus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import io.creativecode.hopperbus.R;
import io.creativecode.hopperbus.views.adapters.RouteAdapter;
import io.creativecode.hopperbus.views.adapters.RouteStopTimesAdapter;
import io.creativecode.hopperbus.views.widgets.SlidingTabLayout;


public class RouteFragment extends Fragment {

    static final String LOG_TAG = "RouteFragment";

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_routes, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new RoutePagerAdapter());

        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);

    }

    class RoutePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return "90" + (position + 1);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item, container, false);
            container.addView(view);

            TextView routeTitleTextView = (TextView) view.findViewById(R.id.text_route_title);
            final ListView routeStopsListView = (ListView) view.findViewById(R.id.list_route_stops);

            switch (position) {
                // Possibly use an enum here
                case 0:
                    routeTitleTextView.setText(R.string.route_901_title);
                    break;
                case 1:
                    routeTitleTextView.setText(R.string.route_902_title);
                    break;
                case 2:
                    routeTitleTextView.setText(R.string.route_903_title);
                    break;
                case 3:
                    routeTitleTextView.setText(R.string.route_904_title);
                    break;
                default:
                    routeTitleTextView.setText(R.string.route_901_title);
                    break;
            }

            // Manage List View
            // Create an array of route adapters

            if (position == 0) {

                RouteStopTimesAdapter routeAdapter = new RouteStopTimesAdapter(getActivity(), getActivity().getLayoutInflater());
                routeStopsListView.setAdapter(routeAdapter);

            } else {

                RouteAdapter routeAdapter = new RouteAdapter(getActivity(), getActivity().getLayoutInflater(), position);
                routeStopsListView.setAdapter(routeAdapter);
            }

            routeStopsListView.setClickable(true);
            routeStopsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View v, int index, long arg3) {
                    Log.i("click", "click detected");

                }
            });

            routeStopsListView.setLongClickable(true);
            routeStopsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                public boolean onItemLongClick(AdapterView<?> arg0, View v, int index, long arg3) {
                    Log.i("click", "long click detected");
                    return true;

                }
            });

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
}

