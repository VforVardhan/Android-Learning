package shreevardhan.slidenerd;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/* Button1 and Button2 have been listened using onClick attribute
   Button3 and Button4 have been listened using implements OnClickListener on MainActivity
   Button5 has been listened using implements OnClickListener on an inner class called HandlerClass
   Button6 has been listened using the Anonymous Inner Class (super-duper way :))
 */

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button btn3,btn4,btn5,btn6,btnActivity2;

    int stateCounter=0;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("life","Create");

        btn3=(Button)findViewById(R.id.button3);
        btn3.setOnClickListener(this);

        btn4=(Button)findViewById(R.id.button4);
        btn4.setOnClickListener(this);

        btn5=(Button)findViewById(R.id.button5);
        btn5.setOnClickListener(new HandlerClass());

        btn6=(Button)findViewById(R.id.button6);
        btn6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Click","Button 6 was clicked");
            }
        });       //NOTE THAT YOU SHOULDN'T USE implements OnClickListener IN MainActivity FOR CREATING LISTENERS IN THIS WAY AS FOR BUTTON 6

        btnActivity2=(Button)findViewById(R.id.buttonActivity2);
        btnActivity2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent obj=new Intent();
                obj.setClassName("shreevardhan.slidenerd","shreevardhan.slidenerd.Activity2");
                startActivity(obj);
                                               /*As an alternative, you can use this way:
                                                 Intent obj=new Intent(context C, className.class);
                                                 startActivity(obj);

                                                 Here--> Intent obj=new Intent(this,Activity2.class);
                                                         startActivity(obj);
                                                */
            }
        });
       Toast obj=Toast.makeText(this,"YOU HAVE LEFT VIDEO 31",Toast.LENGTH_LONG);
       obj.setGravity(Gravity.CENTER,0,0);
       obj.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life","start");
    }
    @Override
    protected void onResume() {
        super.onResume();
        stateCounter++;
        Log.d("life","resume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("life","pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life","stop");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life","restart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life","destroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("counter",stateCounter);
        Log.d("life","onSave");
        Log.d("state","state "+stateCounter+" was saved");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        stateCounter=savedInstanceState.getInt("counter");
        Log.d("life","onRestore");
        Log.d("state","state "+stateCounter+" was saved");
    }

    @Override
    public void onConfigurationChanged(Configuration obj) {
        super.onConfigurationChanged(obj);
       // if(obj.orientation==Configuration.ORIENTATION_LANDSCAPE)
             //Log.d("life",""+obj.orientation);
       // if(obj.orientation==Configuration.ORIENTATION_PORTRAIT)
            //Log.d("life","portrait");
    }

    public void ButtonClickMethod(View obj){
        if(obj.getId()==R.id.button1)
            Log.d("Click","Button 1 was clicked");
        if(obj.getId()==R.id.button2)
            Log.d("Click","Button 2 was clicked");
    }
    @Override
    public void onClick(View obj){
        if(obj.getId()==R.id.button3)
            Log.d("Click","Button 3 was clicked");
        if(obj.getId()==R.id.button4)
            Log.d("Click","Button 4 was clicked");
    }
    public class HandlerClass implements OnClickListener{
        @Override
        public void onClick(View obj){
            Log.d("Click","Button 5 was clicked");
        }

    }


}
