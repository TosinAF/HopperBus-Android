package io.creativecode.hopperbus.presenters;


import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class DataProvider {

    private Context mContext;

    private JSONObject json;

    public DataProvider(Context context) {

        this.mContext = context;

        String jsonString = loadJSONFromAsset();

        try {

            this.json = new JSONObject(jsonString);
            JSONObject o = json.getJSONObject("route903");
            Log.i("Data Provider Route 903", o.toString());
            RouteViewModel viewModel = new RouteViewModel(o);

        } catch (JSONException ex) {
            ex.printStackTrace();
            Log.i("Error Parsing", "Error occurred when reading json");
        }

       // RouteViewModel viewModel = new RouteViewModel()

    }



    public String loadJSONFromAsset() {

        String json = null;

        try {

            InputStream is = mContext.getAssets().open("Routes.json");
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
