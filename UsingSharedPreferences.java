package shreevardhan.slidenerd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UsingSharedPreferences extends AppCompatActivity {

    TextView tv1,tv2;
    EditText et1,et2;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_shared_preferences);
        tv1=(TextView)findViewById(R.id.textView9);
        tv2=(TextView)findViewById(R.id.textView10);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        btn1=(Button)findViewById(R.id.button7);
        btn2=(Button)findViewById(R.id.button8);

        Toast.makeText(this,"Here you will save your data !!",Toast.LENGTH_SHORT).show();
    }

    public void saveMethod(View v){
        SharedPreferences sp=getSharedPreferences("MyPreferenceFile", Context.MODE_PRIVATE); //your data will be store in a .xml file named MyPreferenceFile
        SharedPreferences.Editor edt=sp.edit();
        edt.putString("name",et1.getText().toString());
        edt.putString("password",et2.getText().toString());
        edt.commit();

        Toast.makeText(this,"Data saved successfully",Toast.LENGTH_SHORT).show();


    }

    public void nextActivityMethod(View v){
        Toast.makeText(this,"Here you will load the saved data !!",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,UsingSharedPreferencesActivity2.class));
    }
}
