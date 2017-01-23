package shreevardhan.slidenerd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InternalStorageActivity2 extends AppCompatActivity {

    Button btn1,btn2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage2);
        btn1=(Button)findViewById(R.id.button13);
        btn2=(Button)findViewById(R.id.button14);
        tv=(TextView)findViewById(R.id.textView16);
    }

    public void loadMethod(View v)
    {
        FileInputStream fis=null;
        StringBuffer buf=new StringBuffer();

        try
        {
            fis=openFileInput("myfile.txt");
            int asciiCodeofToken;
            while((asciiCodeofToken=fis.read())!=-1)  /* The FileInputStream stores corresponding ASCII values of the content of the file
                                                         character by character. So ASCII value -1 means endoffile i.e. no more characters*/
            {
                buf.append((char)asciiCodeofToken);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
         catch (IOException e)
         {
             e.printStackTrace();
         }
        finally
        {
            if(fis != null)  // //if any error occurs as soon as the try block begins then the fis won't be intialized and so closing it without checking, is meaningless
            {
                try {
                    fis.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        tv.setText(buf);
        File f=getFilesDir();
        Toast.makeText(this,"The content of "+f+"/myfile.txt is displayed !!",Toast.LENGTH_LONG).show();
    }

    public void previousActivityMethod(View v)
    {
        startActivity(new Intent(this,InternalStorage.class));
    }
}
