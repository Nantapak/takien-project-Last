package suwuttipoj.nantapak.takienfloatingmarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickMaps(View view) {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    public void clickMember(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);

    }
    public void clickWattakien(View view) {
        Intent intent = new Intent(MainActivity.this, WattakienActivity.class);
        startActivity(intent);

    }
    public void clickMarketfloting(View view) {

//        Intent intent = new Intent(MainActivity.this, MarketfloatingActivity.class);
        Intent intent = new Intent(MainActivity.this, TabsMarketActivity.class);
        startActivity(intent);

    }
    public void clickInformation(View view) {
        Intent intent = new Intent(MainActivity.this, InformationActivity.class);
        startActivity(intent);

    }
    public void clickReligious(View view) {
        Intent intent = new Intent(MainActivity.this, ReligiousActivity.class);
        startActivity(intent);

    }
    public void clickHistory (View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);

    }
}
