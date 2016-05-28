package io.creativecode.hopperbus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.creativecode.hopperbus.R;

/**
 * Created by abc on 26-Jun-15.
 */
public class JSONActivityLocal extends ActionBarActivity {
    TextView lblinfo;
    Button btn;
    InputStream inputstream;
    BufferedReader reader;
    String m;
    String busId;
    String stopName;
    String title;
    ListView list;
    List<Map<String, String>> busdata;
    JSONArray jsonArray;
    JSONObject jsonObject;
    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.js);
        lblinfo = (TextView) findViewById(R.id.lblinfo);
        lblinfo.setText("JSON from Local File");
        btn = (Button) findViewById(R.id.btnparse);
        list = (ListView) findViewById(R.id.list);
        try {
            inputstream = getResources().getAssets().open("Example.json");
            reader = new BufferedReader(new InputStreamReader(inputstream));
            m = reader.toString();
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line);
            }
            m = total.toString();
        } catch (IOException ex) {
            Toast.makeText(JSONActivityLocal.this, ex.getMessage().toString(), Toast.LENGTH_LONG).show();
        }



        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                busdata = new ArrayList<Map<String, String>>();
                try {
                    jsonObject = new JSONObject(m);
                    jsonArray = jsonObject.optJSONArray("stop_times");
                    int arraylength = jsonArray.length();

                    for (int i = 0; i < arraylength; i++) {
                        Map<String, String> busmap = new HashMap<String, String>();
                        JSONObject jsonChildNode = jsonArray.getJSONObject(i);
                        busId = jsonChildNode.optString("id").toString();
                        stopName = jsonChildNode.optString("name").toString();
                        busmap.put("A", busId);
                        busmap.put("B", stopName);
                        busdata.add(busmap);
                    }
                    String[] from = {"A", "B"};
                    int[] views = {R.id.lblmoviename, R.id.lblcategory};
                    final SimpleAdapter myadapter = new SimpleAdapter(JSONActivityLocal.this, busdata, R.layout.jslist, from, views);
                    list.setAdapter(myadapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.otheractivity) {
            Intent i = new Intent(JSONActivityLocal.this, JSONActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}