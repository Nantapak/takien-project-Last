package suwuttipoj.nantapak.takienfloatingmarket;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by MI6 on 12/23/2016.
 */

public class MySynAll extends AsyncTask<String, Void, String>{

    private Context context;

    public MySynAll(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {

            Log.d("23decV5", "e doin ==>" + e.toString());
            return null;
        }


    }
}   //Main Class
