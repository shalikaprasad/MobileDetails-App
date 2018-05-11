package com.sit11.msprasad.mobille_phones;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    DatabaseHelper db;
    //public DBHelper mydb ;
    //SQLiteDatabase db;
    //SQLiteOpenHelper openHelper;

    RelativeLayout relative1,relative2;
    Handler handler = new Handler (  );
    Runnable runnable = new Runnable () {
        @Override
        public void run() {
            relative1.setVisibility ( View.VISIBLE );
            relative2.setVisibility ( View.VISIBLE );
        }
    };

    private EditText mEmailView;
    private EditText mPasswordView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );

        db =new DatabaseHelper(this);

        //mydb = new DBHelper(this);


        relative1 = (RelativeLayout) findViewById ( R.id.relative1 );
        relative2 = (RelativeLayout) findViewById ( R.id.relative2 );

        handler.postDelayed ( runnable,5000 );



        // Set up the login form.
        mEmailView = (EditText) findViewById ( R.id.email );
        mPasswordView = (EditText) findViewById ( R.id.password );


        Button mEmailLogInButton = (Button) findViewById ( R.id.email_login_in_button );
        mEmailLogInButton.setOnClickListener ( new OnClickListener () {
            @Override
            public void onClick(View view) {

                String dbname = mEmailView.getText ().toString ();
                String dbpassword = mPasswordView.getText ().toString ();
                Boolean Checkemailpass = db.emailpass ( dbname,dbpassword );
                if(Checkemailpass == true){
                    Toast.makeText ( LoginActivity.this, "Successfully Login", Toast.LENGTH_SHORT ).show ();
                    Intent intent3=new Intent(getApplicationContext(),Tab.class);
                    handler.postDelayed ( runnable, 5000 );
                    startActivity ( intent3 );
                }else {
                    Toast.makeText ( LoginActivity.this, "Fail Login", Toast.LENGTH_SHORT ).show ();
                }
                // StringBuffer buffer = new StringBuffer (  );







            }
        } );

        Button mEmailSignInButton = (Button) findViewById ( R.id.email_Sign_in_button );
        mEmailSignInButton.setOnClickListener ( new OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent1=new Intent(getApplicationContext(),SignActivity.class);
                startActivity ( intent1 );


            }
        } );


    }



}

