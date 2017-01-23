package shreevardhan.slidenerd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UsingSharedPreferencesActivity2 extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_shared_preferences2);
        tv1=(TextView)findViewById(R.id.textView11);
        tv2=(TextView)findViewById(R.id.textView12);
        tv3=(TextView)findViewById(R.id.textView13);
        tv4=(TextView)findViewById(R.id.textView14);

        btn1=(Button)findViewById(R.id.button9);
        btn2=(Button)findViewById(R.id.button10);


    }

    public void loadMethod(View v){
        SharedPreferences sp=getSharedPreferences("MyPreferenceFile", Context.MODE_PRIVATE);
        String nameObtained=sp.getString("name","N/A");
        String passwordObtained=sp.getString("password","N/A");
        tv2.setText(nameObtained);
        tv4.setText(passwordObtained);

        if(nameObtained.equals("N/A") || passwordObtained.equals("N/A"))
        {
            Toast.makeText(this,"Sorry !! No data was found",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Data loaded successfully",Toast.LENGTH_SHORT).show();

        }

    }

    public void previousActivityMethod(View v){
        Toast.makeText(this,"Here you will save your data !!",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,UsingSharedPreferences.class));
    }
}
