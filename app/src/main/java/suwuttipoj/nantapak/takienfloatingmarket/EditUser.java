package suwuttipoj.nantapak.takienfloatingmarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class EditUser extends AppCompatActivity {

    //Expilcit
    private String tab = "23DecV3", tag1 = "23decV4", tag2 = "23decV5";
    private String userIDString, PREFIX_ID, showPREFIX;
    private TextView prefixTextView;
    private Spinner prefixSpinner;
    private EditText MEM_FIRSTNAMEditText;
    private Button button;
    private String updateMEM_FIRSTNAME, updatePREFIX_ID;
    private boolean prefixABoolean = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        //Bind Widget
        bindWidget();

        //Setup
        userIDString = getIntent().getStringExtra("USER_ID");
        Log.d(tab, "USER_ID ==>" + userIDString);


        //Get Value From menID
        getValueFormMemID();

        //Create Prefix Spinner
        createPrefixSpinner();

        //Button Controller
        buttonController();


    }   // Main method

    private void buttonController() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateMEM_FIRSTNAME = MEM_FIRSTNAMEditText.getText().toString();

                Log.d("23decV6", "updateMEM ==>" + updateMEM_FIRSTNAME);
                Log.d("23decV6", "updatePREFIX ==>" + updatePREFIX_ID);


            }   // onClick
        });

    }

    private void createPrefixSpinner() {

        String urlJSON = "http://swiftcodingthai.com/ton/get_prefix.php";

        try {

            MySynAll mySynAll = new MySynAll(EditUser.this);
            mySynAll.execute(urlJSON);
            String s = mySynAll.get();
            Log.d(tag2, "JSON ==>" + s);
            final boolean[] b = {false};

            JSONArray jsonArray = new JSONArray(s);
            final String[] prefixStrings = new String[jsonArray.length()];
            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                prefixStrings[i] = jsonObject.getString("PREFIX_NAME");

            }//for

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(EditUser.this,
                    android.R.layout.simple_list_item_1, prefixStrings);
            prefixSpinner.setAdapter(stringArrayAdapter);

            prefixSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if (b[0]) {
                        prefixTextView.setText(prefixStrings[position]);

                        Log.d("23decV6", "Work in onItem");

                        if (prefixABoolean) {
                            updatePREFIX_ID = Integer.toString(position + 1);
                        } else {

                            prefixABoolean = true;
                        }

                        Log.d("23decV6", "updatePRE ==>" + updatePREFIX_ID);

                    } else {
                        b[0] = true;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        } catch (Exception e) {
            Log.d(tag2, "e createSpinner ==>" + e.toString());

        }
    }

    private void bindWidget() {

        prefixTextView = (TextView) findViewById(R.id.textView24);
        prefixSpinner = (Spinner) findViewById(R.id.spinner4);
        MEM_FIRSTNAMEditText = (EditText) findViewById(R.id.editText5);
        button = (Button) findViewById(R.id.button);


    }

    public void  getValueFormMemID() {

        String urlJSON = "http://swiftcodingthai.com/ton/get_member_where_menID.php";

        try {
            MySynchronize mySynchronize = new MySynchronize(EditUser.this);
            mySynchronize.execute("MEM_ID", userIDString, urlJSON);
            String s = mySynchronize.get();
            Log.d(tab, "JSON of getValueFromMenID ==>" + s);

            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            PREFIX_ID = jsonObject.getString("PREFIX_ID");
            updatePREFIX_ID = PREFIX_ID;
            Log.d(tag1, "PREFIX_ID ==>" + PREFIX_ID);
            showPREFIX = findPREFIX(PREFIX_ID);
            prefixTextView.setText(showPREFIX);

            MEM_FIRSTNAMEditText.setText(jsonObject.getString("MEM_FIRSTNAME"));

            mySynchronize.cancel(true);

        } catch (Exception e) {

            Log.d(tab, "e getValue ==>" + e.toString());
        }
    }   //getValue

    private String findPREFIX(String prefix_id) {

        String result = null;
        String urlJSON = "http://swiftcodingthai.com/ton/get_prefix_where.php";

        try {

            MySynchronize mySynchronize = new MySynchronize(EditUser.this);
            mySynchronize.execute("PREFIX_ID", prefix_id, urlJSON);
            String s = mySynchronize.get();
            Log.d(tag1, "JSON ==>" + s);

            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            result = jsonObject.getString("PREFIX_NAME");



        } catch (Exception e) {
            Log.d(tag1, "e findPREFIX ==> " + e.toString());
        }

        return result;
    }
}   //Main Class
