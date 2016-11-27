package suwuttipoj.nantapak.takienfloatingmarket;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;


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



        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // Main Method

}   // Main Class

