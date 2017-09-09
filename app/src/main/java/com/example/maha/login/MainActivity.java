package com.example.maha.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button okk;
    Button ok;
    EditText emailMsg;
    EditText phone;
    EditText email;


    static final int REQUEST_IMAGE_CAPTURE = 1;





        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            camera = (ImageView) findViewById(R.id.mImageView);



        ok = (Button) findViewById(R.id.ok);
        email = (EditText) findViewById(R.id.email);
        emailMsg = (EditText) findViewById(R.id.emailMsg);



      //// final String toMail= email.getText().toString();

       final String email_Msg=emailMsg.getText().toString();




        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toMail= email.getText().toString();
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
    ImageView camera ;

    public void Camera(View v){


        dispatchTakePictureIntent();

    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            camera.setImageBitmap(imageBitmap);
        }
    }


}
