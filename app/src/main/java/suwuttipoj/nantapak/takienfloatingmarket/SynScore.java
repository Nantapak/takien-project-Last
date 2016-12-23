package suwuttipoj.nantapak.takienfloatingmarket;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 12/23/2016 AD.
 */

public class SynScore extends AsyncTask<Void, Void, String>{

    //Explicit
    private static final String urlJSON = "http://swiftcodingthai.com/ton/get_shop_desc.php";
    private Context context;

    public SynScore(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("23decV1", "e doin ==> " + e.toString());
            return null;
        }


    }
}   // Main Class
