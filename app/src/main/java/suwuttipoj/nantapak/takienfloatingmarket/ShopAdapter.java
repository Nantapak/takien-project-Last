package suwuttipoj.nantapak.takienfloatingmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 11/27/2016 AD.
 */

public class ShopAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] iconStrings, nameStrings, detailStrings;
    private ImageView imageView;
    private TextView nameTextView, detailTextView;

    public ShopAdapter(Context context,
                       String[] iconStrings,
                       String[] nameStrings,
                       String[] detailStrings) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.nameStrings = nameStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return iconStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.shop_listview, viewGroup, false);

        //Bind Widget
        imageView = (ImageView) view1.findViewById(R.id.imageView12);
        nameTextView = (TextView) view1.findViewById(R.id.textView12);
        detailTextView = (TextView) view1.findViewById(R.id.textView18);

        //Show View
        Picasso.with(context).load(iconStrings[i]).into(imageView);
        nameTextView.setText(nameStrings[i]);
        detailTextView.setText(setupDetail(detailStrings[i]));


        return view1;
    }

    private String setupDetail(String detailString) {

        String strResult = null;

        if (detailString.length() <= 80) {
            strResult = detailString;
        } else {
            strResult = detailString.substring(0, 80) + "...";
        }

        return strResult;
    }
}   // Main Class
