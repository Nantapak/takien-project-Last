package suwuttipoj.nantapak.takienfloatingmarket;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


import suwuttipoj.nantapak.takienfloatingmarket.fragments.MarketDetailFragment;
import suwuttipoj.nantapak.takienfloatingmarket.fragments.MarketMenuFragment;


public class MarketfloatingActivity extends AppCompatActivity implements MarketMenuFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketfloating);

        Log.d("DEBUG", getResources().getConfiguration().orientation + "");

        if (savedInstanceState == null) {
            // Instance of first fragment
            MarketMenuFragment firstFragment = new MarketMenuFragment();

            // Add Fragment to FrameLayout (flContainer), using FragmentManager
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); // begin  FragmentTransaction
            ft.add(R.id.flContainer, firstFragment);                                   // add    Fragment
            ft.commit();                                                                // commit FragmentTransaction
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            MarketMenuFragment secondFragment = new MarketMenuFragment();
            Bundle args = new Bundle();
            args.putInt("position", 0);
            secondFragment.setArguments(args);                                         // (1) Communicate with Fragment using Bundle
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();   // begin  FragmentTransaction
            ft2.add(R.id.flContainer2, secondFragment);
            ft2.commit();
        }
    }

    @Override
    public void onShopItemSelected(int position) {
        Toast.makeText(this, "รายละเอียดของร้าน", Toast.LENGTH_SHORT).show();

        // Load Shop Detail Fragment
        MarketDetailFragment secondFragment = new MarketDetailFragment();


        Bundle arg = new Bundle();
        arg.putInt("position", position);
        secondFragment.setArguments(arg);                               // (1) Communicate with Fragment using Bundle


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer2, secondFragment) // replace flContainer
                    //.addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, secondFragment)  // replace flContainer
                    .addToBackStack(null)
                    .commit();
        }
    }

}

