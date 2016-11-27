package suwuttipoj.nantapak.takienfloatingmarket;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MypageAdapter extends FragmentPagerAdapter {
    public MypageAdapter(FragmentManager fm){super(fm);}

    public int getCount() {
        return 3;}

    public Fragment getItem(int position) {
        if (position == 0)
            return new Tab1_htr_wtk();
        else if (position == 1)
            return new Tab2_htr_wtk();
        else if (position == 2)
            return new Tab3_htr_mk();
        return null;
    }
}
