package shreevardhan.slidenerd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorage extends AppCompatActivity {

    TextView tv;
    EditText et;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        tv=(TextView)findViewById(R.id.textView15);
        et=(EditText)findViewById(R.id.editText3);
        btn1=(Button)findViewById(R.id.button11);
        btn2=(Button)findViewById(R.id.button12);
    }

    public void saveMethod(View v)
    {
        FileOutputStream fos= null;
        byte[] buf=et.getText().toString().getBytes(); //converting the string content to a byte array
        try
           {
            fos = openFileOutput("myfile.txt", Context.MODE_PRIVATE); //Use MODE_APPEND if you want to keep appending to this file
            fos.write(buf);
           }
        catch (FileNotFoundException e)
           {
            e.printStackTrace();  // Log.d("hoho",e.toString()); can be used here during development period
           }
        catch (IOException e)
           {
            e.printStackTrace();  // Log.d("hoho",e.toString()); can be used here during development period
           }
        finally
           {
               if(fos != null)  // //if any error occurs as soon as the try block begins then the fis won't be intialized and so closing it without checking, is meaningless
               {
                   try {
                       fos.close();
                   }
                   catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }

        File fileKiLocation=getFilesDir(); // Generates the location of the fos as a String ---> data/data/Slidenerd/files.
                                           // Actually this is done as soon as you FileOutputStream fos = null;
        Toast.makeText(this,"This text has been saved successfully in "+fileKiLocation+"/myfile.txt",Toast.LENGTH_LONG).show();
    }

    public void nextActivityMethod(View v)
    {
        startActivity(new Intent(this,InternalStorageActivity2.class));
    }
}
