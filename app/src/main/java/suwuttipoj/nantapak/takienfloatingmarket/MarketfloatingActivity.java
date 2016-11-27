package suwuttipoj.nantapak.takienfloatingmarket;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;


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

        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // Main Method

}   // Main Class

