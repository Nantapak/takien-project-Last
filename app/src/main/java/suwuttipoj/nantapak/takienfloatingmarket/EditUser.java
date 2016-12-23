package suwuttipoj.nantapak.takienfloatingmarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class EditUser extends AppCompatActivity {

    //Explicit
    private String userIDString, tab = "23decV3";
    private MySynchronize mySynchronize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        //Setup
        userIDString = getIntent().getStringExtra("USER_ID");
        Log.d(tab, "USER_ID ==> " + userIDString);
        mySynchronize = new MySynchronize(EditUser.this);

        //Get Value From menID
        getValueFromMemID();




    }   // Main Method

    private void getValueFromMemID() {

        String urlJSON = "http://swiftcodingthai.com/ton/get_member_where_menID.php";

        try {

            mySynchronize.execute("MEM_ID", userIDString, urlJSON);
            String s = mySynchronize.get();
            Log.d(tab, "JSON of getValueFromMenID ==> " + s);

        } catch (Exception e) {
            Log.d(tab, "e getValue ==> " + e.toString());
        }

    }   // getValue

}   // Main Class
