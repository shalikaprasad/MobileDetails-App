package com.sit11.msprasad.mobille_phones;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SignActivity extends AppCompatActivity{

    DatabaseHelper db;


    //public DBHelper mydb ;
    private EditText name;
    private EditText mobile;
    private EditText email;
    private EditText password;
    private EditText cpassword;
    private Button sign;

    RelativeLayout relative11;
    Handler handler = new Handler (  );
    Runnable runnable = new Runnable () {
        @Override
        public void run() {
            relative11.setVisibility ( View.VISIBLE );

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_sign );


        relative11 = (RelativeLayout) findViewById ( R.id.relative11 );


        handler.postDelayed ( runnable, 5000 );

        //mydb = new DBHelper ( this );
        db =new DatabaseHelper(this);
        //name = (EditText) findViewById ( R.id.name1 );
        //mobile = (EditText) findViewById ( R.id.mobile1 );
        email = (EditText) findViewById ( R.id.email1 );
        password = (EditText) findViewById ( R.id.password1 );
        cpassword = (EditText) findViewById ( R.id.cpassword1 );

        sign = (Button) findViewById ( R.id.email_Sign_in_button1 );




        sign.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                //String dbname = name.getText ().toString ();
                //String dbmobile = mobile.getText ().toString ();
                String dbemail = email.getText ().toString ();
                String dbpassword = password.getText ().toString ();
                String dbcpassword = cpassword.getText ().toString ();

                if(dbemail.equals ( "" )||dbpassword.equals ( "" )||dbcpassword.equals ( "" )){

                    Toast.makeText ( SignActivity.this, "Field are Empty", Toast.LENGTH_SHORT ).show ();

                }else {

                    if(dbpassword.equals ( dbcpassword )){
                        Boolean checkemail = db.checkmail ( dbemail );

                        if(checkemail==true){
                            Boolean insert = db.insert ( dbemail,dbpassword);


                            if(insert==true) {
                                Toast.makeText ( SignActivity.this, "SignUp Successfully", Toast.LENGTH_SHORT ).show ();
                                handler.postDelayed ( runnable, 2000 );
                                Intent intent = new Intent ( getApplicationContext (), LoginActivity.class );
                                startActivity ( intent );
                            }


                        }else {
                            Toast.makeText ( SignActivity.this, "Email Already Exists", Toast.LENGTH_SHORT ).show ();
                        }
                    }
                    else
                        Toast.makeText ( SignActivity.this, "Password do not match", Toast.LENGTH_SHORT ).show ();



                }


                /**
                 boolean result = mydb.insertdata ( dbname, dbmobile, dbemail, dbpassword );

                 if (result == true) {
                 Toast.makeText ( SignActivity.this, "Data inserted Successfully", Toast.LENGTH_SHORT ).show ();
                 } else {
                 Toast.makeText ( SignActivity.this, "Data insertion fail", Toast.LENGTH_SHORT ).show ();
                 }

                 handler.postDelayed ( runnable, 2000 );
                 Intent intent = new Intent ( getApplicationContext (), LoginActivity.class );
                 startActivity ( intent );
                 **/


            }
        } );


    }



}

