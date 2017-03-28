package com.example.android.nio1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.android.nio1.R.id.aadhar;
import static com.example.android.nio1.R.id.email;
import static com.example.android.nio1.R.id.fname;
import static com.example.android.nio1.R.id.home_pin;
import static com.example.android.nio1.R.id.lname;
import static com.example.android.nio1.R.id.login_layout;
import static com.example.android.nio1.R.id.office_pin;
import static com.example.android.nio1.R.id.signup_email;
import static com.example.android.nio1.R.id.signup_layout;
import static com.example.android.nio1.R.id.signup_password;

public class Map extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    EditText et_fname,et_lname,et_aadhar,et_office_pin,et_home_pin,et_signup_email,et_signup_password,et_mobile, et_email,et_password;
    String u_fname,u_lname,u_gender,u_aadhar,u_designation,u_office_pin,u_home_pin,u_signup_email,u_signup_password,u_mobile,u_email,u_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);






        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void showSignUp(View view) {
        LinearLayout s = (LinearLayout) findViewById(R.id.signup_layout);
        LinearLayout l = (LinearLayout) findViewById(R.id.login_layout);

        l.setVisibility(View.GONE);
        s.setVisibility(View.VISIBLE);
    }

    public void showLogIn(View view) {
        LinearLayout s = (LinearLayout) findViewById(R.id.signup_layout);
        LinearLayout l = (LinearLayout) findViewById(R.id.login_layout);

        s.setVisibility(View.GONE);
        l.setVisibility(View.VISIBLE);

    }


    public void register(View view)
    {
        et_fname               =   (EditText) findViewById(R.id.fname);
        et_lname               =   (EditText) findViewById(R.id.lname);
        et_aadhar              =   (EditText) findViewById(R.id.aadhar);
        et_office_pin          =   (EditText) findViewById(R.id.office_pin);
        et_home_pin            =   (EditText) findViewById(R.id.home_pin);
        et_signup_email        =   (EditText) findViewById(R.id.signup_email);
        et_signup_password     =   (EditText) findViewById(R.id.signup_password);
        et_mobile              =    (EditText) findViewById(R.id.mobile);

        u_fname                   =   et_fname.getText().toString();
        u_lname                   =   et_lname.getText().toString();
        u_gender                  =   "Male";
        u_aadhar                  =   et_aadhar.getText().toString();
        u_designation             =   "Center Head";
        u_office_pin              =   et_office_pin.getText().toString();
        u_home_pin                =   et_home_pin.getText().toString();
        u_signup_email            =   et_signup_email.getText().toString();
        u_signup_password         =   et_signup_password.getText().toString();
        u_mobile                  =   et_mobile.getText().toString();

        String method   =   "register";

        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,u_fname,u_lname,u_gender,u_aadhar,u_designation,u_office_pin,u_home_pin,u_signup_email,u_signup_password,u_mobile);
        finish();
    }
    public void login(View view)
    {
        et_email        =   (EditText) findViewById(email);
        et_password     =   (EditText) findViewById(R.id.password);
        u_email         =   et_email.getText().toString();
        u_password      =   et_password.getText().toString();
        String method   =   "login";

        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,u_email,u_password);
        finish();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Map Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
