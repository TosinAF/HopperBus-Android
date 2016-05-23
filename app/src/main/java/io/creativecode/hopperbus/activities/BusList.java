package io.creativecode.hopperbus.activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import io.creativecode.hopperbus.R;

/**
 * Created by EmmanuelAbiola on 23/05/16.
 */
public class BusList extends MainActivity {

    String[] NAMES = {"BusTimetable"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_stop_times);
        Context context = null;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,NAMES);
        ListView mListView = (ListView) findViewById(R.id.list_route_stops);
        mListView.setAdapter(adapter);

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray dataArray = obj.getJSONArray("stop_times");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject jo_inside = dataArray.getJSONObject(i);
                Log.d("Details-->", jo_inside.getString("name"));
                String stop_value = jo_inside.getString("name");
                String time_value = jo_inside.getString("term_time");

                //Add your values in your `ArrayList` as below:
                m_li = new HashMap<String, String>();
                m_li.put("name", stop_value);
                m_li.put("term_time", time_value);
                formList.add(m_li);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("Routes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}