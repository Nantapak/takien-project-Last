package suwuttipoj.nantapak.takienfloatingmarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class EditUser extends AppCompatActivity {

    //Explicit
    private String  tab = "23decV3", tag1 = "23decV4", tag2 = "23decV5";
    private String userIDString, PREFIX_ID, showPREFIX;
    private TextView prefixTextView;
    private Spinner prefixSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        //Bind Widget
        bindWidget();

        //Setup
        userIDString = getIntent().getStringExtra("USER_ID");
        Log.d(tab, "USER_ID ==> " + userIDString);

        //Get Value From menID
        getValueFromMemID();

        //Create Prefix Spinner
        createPrefixSpinner();



    }   // Main Method

    private void createPrefixSpinner() {

        String urlJSON = "http://swiftcodingthai.com/ton/get_prefix.php";

        try {

            MySynAll mySynAll = new MySynAll(EditUser.this);
            mySynAll.execute(urlJSON);
            String s = mySynAll.get();
            Log.d(tag2, "JSON ==> " + s);

            JSONArray jsonArray = new JSONArray(s);
            String[] prefixStrings = new String[jsonArray.length()];
            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                prefixStrings[i] = jsonObject.getString("PREFIX_NAME");

            }   // for

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(EditUser.this,
                    android.R.layout.simple_list_item_1, prefixStrings);
            prefixSpinner.setAdapter(stringArrayAdapter);


        } catch (Exception e) {
            Log.d(tag2, "e createSpinner ==> " + e.toString());
        }

    }

    private void bindWidget() {

        prefixTextView = (TextView) findViewById(R.id.textView24);
        prefixSpinner = (Spinner) findViewById(R.id.spinner4);

    }

    private void getValueFromMemID() {

        String urlJSON = "http://swiftcodingthai.com/ton/get_member_where_menID.php";

        try {

            MySynchronize mySynchronize = new MySynchronize(EditUser.this);
            mySynchronize.execute("MEM_ID", userIDString, urlJSON);
            String s = mySynchronize.get();
            Log.d(tab, "JSON of getValueFromMenID ==> " + s);

            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            PREFIX_ID = jsonObject.getString("PREFIX_ID");
            Log.d(tag1, "PREFIX_ID ==> " + PREFIX_ID);
            showPREFIX = findPREFIX(PREFIX_ID);
            prefixTextView.setText(showPREFIX);


            mySynchronize.cancel(true);
        } catch (Exception e) {
            Log.d(tab, "e getValue ==> " + e.toString());
        }

    }   // getValue

    private String findPREFIX(String prefix_id) {

        String result = null;
        String urlJSON = "http://swiftcodingthai.com/ton/get_prefix_where.php";

        try {

            MySynchronize mySynchronize = new MySynchronize(EditUser.this);
            mySynchronize.execute("PREFIX_ID", prefix_id, urlJSON);
            String s = mySynchronize.get();
            Log.d(tag1, "JSON ==> " + s);

            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            result = jsonObject.getString("PREFIX_NAME");


        } catch (Exception e) {
            Log.d(tag1, "e findPREFIX ==> " + e.toString());
        }

        return result;
    }

}   // Main Class
