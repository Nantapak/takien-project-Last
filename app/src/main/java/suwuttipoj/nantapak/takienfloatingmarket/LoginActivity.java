package suwuttipoj.nantapak.takienfloatingmarket;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;
    private static final String urlJSON = "http://swiftcodingthai.com/ton/get_data.php";

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