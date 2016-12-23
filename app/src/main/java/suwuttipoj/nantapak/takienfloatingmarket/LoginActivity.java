package suwuttipoj.nantapak.takienfloatingmarket;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString, truePasswordString, user_idString;
    private static final String urlJSON = "http://swiftcodingthai.com/ton/get_data.php";
    private boolean aBoolean = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText12);
        passwordEditText = (EditText) findViewById(R.id.editText13);

    } //Main Method

    public void clickMyLogin(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "Have Space",
                    "Please Fill All Every Blank");

        } else {

            //No Space
            try {

                SynUserPass synUserPass = new SynUserPass(LoginActivity.this);
                synUserPass.execute();
                String s = synUserPass.get();
                Log.d("23decV2", "JSON ==> " + s);

                JSONArray jsonArray = new JSONArray(s);

                for (int i=0;i<jsonArray.length();i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (userString.equals(jsonObject.getString("USER_NAME"))) {
                        aBoolean = false;
                        truePasswordString = jsonObject.getString("USER_PASSWORD");
                        user_idString = jsonObject.getString("USER_ID");
                    }   // if
                }   // for

                if (aBoolean) {
                    //User False
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(LoginActivity.this, "User False",
                            "No this User in my Database");
                } else if (passwordString.equals(truePasswordString)) {
                    //Password True
                    Intent intent = new Intent(LoginActivity.this, EditUser.class);
                    intent.putExtra("USER_ID", user_idString);
                    startActivity(intent);
                    finish();

                } else {
                    //Password False
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(LoginActivity.this, "Password False",
                            "Please Try Again Password False");
                }



            } catch (Exception e) {
                Log.d("23devV2", "e Thread ==> " + e.toString());
            }   //try

        }   // if

    }   //clickMyLogin




    public void clickCancel(View view) {
        finish();
    }

    public void clickNewRegis(View view) {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }

}     // Main Class