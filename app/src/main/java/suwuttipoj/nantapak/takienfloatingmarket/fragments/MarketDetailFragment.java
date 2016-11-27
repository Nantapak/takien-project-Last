package suwuttipoj.nantapak.takienfloatingmarket.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import suwuttipoj.nantapak.takienfloatingmarket.R;
import suwuttipoj.nantapak.takienfloatingmarket.datamarket.Shop;

/**
 * Created by MI6 on 11/24/2016.
 */

public class MarketDetailFragment extends Fragment {
    int position = 0;
    TextView tvTitle;
    TextView tvDetail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            //Get back arguments
            if (getArguments() != null) {
                position = getArguments().getInt("position", 0);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        //Inflate the xml file for the fragment
        return inflater.inflate(R.layout.fragment_market_detail, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Set values for view here
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvDetail = (TextView) view.findViewById(R.id.tvDetails);

        // update view
//        tvTitle.setText(Shop.marketMenu[position]);
//        tvDetail.setText(Shop.marketDetail[position]);

        tvTitle.setText("title Master");
        tvDetail.setText("detail Master");

    }

    // Activity is calling this to update view on Fragment
    public void updateView(int position) {
        tvTitle.setText(Shop.marketMenu[position]);
        tvDetail.setText(Shop.marketDetail[position]);
    }
}   // Main Class
