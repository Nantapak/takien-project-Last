package suwuttipoj.nantapak.takienfloatingmarket;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import suwuttipoj.nantapak.takienfloatingmarket.fragments.MarketDetailFragment;


public class MarketfloatingActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketfloating);

        listView = (ListView) findViewById(R.id.livShop);

        try {

            SynShop synShop = new SynShop(MarketfloatingActivity.this);
            synShop.execute();

            String strJSON = synShop.get();

            Log.d("27novV1", "JSON ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);

            String[] nameStrings = new String[jsonArray.length()];
            String[] detailStrings = new String[jsonArray.length()];
            String[] iconStrings = new String[jsonArray.length()];

            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                nameStrings[i] = jsonObject.getString("SHOP_NAME");
                detailStrings[i] = jsonObject.getString("SHOP_DETAIL");
                iconStrings[i] = jsonObject.getString("SHOP_IMAGE_FILE");

            }   // for

            ShopAdapter shopAdapter = new ShopAdapter(MarketfloatingActivity.this,
                    iconStrings, nameStrings, detailStrings);
            listView.setAdapter(shopAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    startActivity(new Intent(MarketfloatingActivity.this, MarketDetailFragment.class));

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // Main Method

}   // Main Class

