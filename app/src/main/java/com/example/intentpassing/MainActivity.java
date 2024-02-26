package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnM, btnC, btnE, btnS;
        btnM = findViewById(R.id.btnM);
        btnE = findViewById(R.id.btnE);
        btnC = findViewById(R.id.btnC);
        btnS = findViewById(R.id.btnS);

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent message = new Intent(Intent.ACTION_SENDTO);
                message.setData(Uri.parse("smsto:" +Uri.encode("9350258225")));
                message.putExtra("sms_body","Please solve this");
                startActivity(Intent.createChooser(message, "Send message..."));
            }
        });


        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel: 9999999999"));
                startActivity(Intent.createChooser(call, "Calling"));
            }
        });

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mail = new Intent(Intent.ACTION_SEND);
               mail.setType("message/rfc822");
                mail.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
                mail.putExtra(Intent.EXTRA_SUBJECT, "Subject of the email");
                mail.putExtra(Intent.EXTRA_TEXT, "Body of the email");
                startActivity(Intent.createChooser(mail, "Send email..."));
            }

        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plan");
                share.putExtra(Intent.EXTRA_TEXT,"Himmat hai to click kar https://chat.openai.com/c/9bab244f-50e4-4447-8e42-1f82fbb2a1b6");
                startActivity(Intent.createChooser(share,"Send via"));
            }
        });

    }
}