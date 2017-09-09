package com.example.maha.login;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button okk;
    Button ok;
    EditText emailMsg;
    EditText phone;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok = (Button) findViewById(R.id.ok);
        email = (EditText) findViewById(R.id.email);
        emailMsg = (EditText) findViewById(R.id.emailMsg);



       final String toMail= email.getText().toString();
       final String email_Msg=emailMsg.getText().toString();




        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailer = new Intent(Intent.ACTION_SEND);
                mailer.setType("vnd.android.cursor.item/email");
                mailer.putExtra(Intent.EXTRA_EMAIL, new String[]{toMail});
                mailer.putExtra(Intent.EXTRA_SUBJECT, "Test Send Mail");
                mailer.putExtra(Intent.EXTRA_TEXT, email_Msg );
                startActivity(Intent.createChooser(mailer, "Send email..."));
            }
        });



        okk = (Button) findViewById(R.id.okk);
        phone = (EditText) findViewById(R.id.phone);
        final String tel = phone.getText().toString();

        okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                    Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tel));
                    startActivity(i);
                } catch (SecurityException e) {
                }


            }
        });


    }
}
