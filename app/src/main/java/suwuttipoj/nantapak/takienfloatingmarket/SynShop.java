package suwuttipoj.nantapak.takienfloatingmarket;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by MI6 on 11/27/2016.
 */

public class SynShop extends AsyncTask<Void,Void,String> {

    //Ecplicit
    private Context context;
    private static final String urlJSON = "http://swiftcodingthai.com/ton/get_shop.php";


    public SynShop(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            Log.d("27novV1", "e doIn ==>" + e.toString());
            return null;
        }


    }
} //Main Class
