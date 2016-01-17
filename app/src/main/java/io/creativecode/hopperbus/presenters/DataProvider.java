package io.creativecode.hopperbus.presenters;


import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class DataProvider {

    private Context mContext;

    public DataProvider(Context context) {

        this.mContext = context;

        String json = "hshshshs";

        Log.i("hi hi hi", "hi hi hi");

        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(mContext.getAssets().open(
                    "Routes.json")));
            Log.i("im here", "json file");
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("failes", "json file");
        } finally {
            try {
                br.close(); // stop reading
                Log.i("stop", "json file");
            } catch (IOException e) {
                e.printStackTrace();
                Log.i("failed again", "json file");
            }
        }
        String myjsonstring = sb.toString();
        Log.i(myjsonstring, "json file");


        //JSONObject obj = new JSONObject(json_return_by_the_function);

    }
}
