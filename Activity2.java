package shreevardhan.slidenerd;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.view.View.OnClickListener;

public class Activity2 extends AppCompatActivity {

    Button btnMainActivity,btnEmailActivity,btnCustomToastActivity,btnFbLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        btnMainActivity = (Button) findViewById(R.id.buttonMainActivity);
        btnMainActivity.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent obj = new Intent();
                obj.setClassName("shreevardhan.slidenerd", "shreevardhan.slidenerd.MainActivity");
                startActivity(obj);
                                                /*As an alternative, you can use this way:
                                                 Intent obj=new Intent(context C, className.class);
                                                 startActivity(obj);

                                                 Here--> Intent obj=new Intent(this,MainActivity .class);
                                                         startActivity(obj);
                                                 But this won't actually work here as it is the anonymous inner class
                                                */

            }
        });
        btnEmailActivity=(Button)findViewById(R.id.buttonEmailActivity);
        btnEmailActivity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent();
                obj.setClassName("shreevardhan.slidenerd","shreevardhan.slidenerd.EmailActivity");
                startActivity(obj);
            }
        });

        btnCustomToastActivity=(Button)findViewById(R.id.buttonCustomToastActivity);
        btnCustomToastActivity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent();
                obj.setClassName("shreevardhan.slidenerd","shreevardhan.slidenerd.CustomToastActivity");
                startActivity(obj);
            }
        });

        btnFbLogin=(Button)findViewById(R.id.buttonFb);
        btnFbLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj =new Intent();
                obj.setClassName("shreevardhan.slidenerd","shreevardhan.slidenerd.FbLogin");
                startActivity(obj);
            }
        });

    }

    Intent obj = null, chooser = null;

    public void ImplicitIntentFunctionality(View v)
    {
        if (v.getId() == R.id.buttonLaunchMap) {
            obj = new Intent(Intent.ACTION_VIEW);
            obj.setData(Uri.parse("geo:19.076 72.8777"));
            chooser = Intent.createChooser(obj, "JO APP PASAND HO WO LELO");
            startActivity(chooser);
        }
        if (v.getId() == R.id.buttonGoogle) {
            obj = new Intent(Intent.ACTION_VIEW);
            obj.setData(Uri.parse("https://www.google.com"));
            chooser = Intent.createChooser(obj, "JO APP PASAND HO WO LELO");
            startActivity(chooser);
        }

        if(v.getId()==R.id.buttonEmail)
        {
            obj=new Intent(Intent.ACTION_SEND);
            obj.setData(Uri.parse("mailto:"));

            String[] friends={"kdpandey19@gmail.com","impelecmail@gmail.com"};
            obj.putExtra(Intent.EXTRA_EMAIL,friends);
            obj.putExtra(Intent.EXTRA_SUBJECT,"Blah Blah");
            obj.putExtra(Intent.EXTRA_TEXT,"Hi! This email is sent by me");

            obj.setType("message/rfc822");   //This statement must be written after all the putExtra() statements
            startActivity(Intent.createChooser(obj,"JO APP PASAND HO WO LELO"));
        }

        if(v.getId()==R.id.buttonSendImage)
        {
            obj=new Intent(Intent.ACTION_SEND);

            obj.putExtra(Intent.EXTRA_STREAM,Uri.parse("android.resource://shreevardhan.slidenerd/drawable/"+R.drawable.ironman));
            obj.putExtra(Intent.EXTRA_SUBJECT,"Blah Blah!!");
            obj.putExtra(Intent.EXTRA_TEXT,"HI! I've sent this image");

            obj.setType("image/*");         //This statement must be written after all the putExtra() statements
            startActivity(Intent.createChooser(obj,"JO APP PASAND HO WO LELO"));
        }

    }
}

