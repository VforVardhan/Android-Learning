package shreevardhan.slidenerd;

import android.content.Intent;
import android.os.Environment;
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

public class CacheAndExternalStorageReadingData extends AppCompatActivity {

    TextView tv;
    Button btn1,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache_and_external_storage_reading_data);
        tv=(TextView)findViewById(R.id.textView17);
        btn1=(Button)findViewById(R.id.button19);
        btn2=(Button)findViewById(R.id.button20);
        btn3=(Button)findViewById(R.id.button21);
        btn4=(Button)findViewById(R.id.button22);
        btn5=(Button)findViewById(R.id.button23);
    }

    public void loadFromInternalCache(View v){
        File internalCacheReference = getCacheDir();
        File myfile = new File(internalCacheReference,"myfile1.txt");
        StringBuffer buf = new StringBuffer(); //buf is created and initialized to null
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(myfile);
            int token;
            while((token=fis.read())!= -1){
                buf.append((char)token);
            }
            if(buf.toString() != "")
            {
                tv.setText(buf.toString());
                Toast.makeText(this,internalCacheReference+" /myfile1.txt",Toast.LENGTH_LONG).show();

            }
            else
            {
                tv.setText("<eRroR> :(");
                Toast.makeText(this,"Couldn't find myfile1.txt",Toast.LENGTH_LONG).show();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if(fis!=null)
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void loadFromExternalCache(View v){
        File externalCacheReference = getExternalCacheDir();
        File myfile = new File(externalCacheReference,"myfile2.txt");
        StringBuffer buf = new StringBuffer(); //buf is created and initialized to null
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(myfile);
            int token;
            while((token=fis.read())!= -1){
                buf.append((char)token);
            }
            if(buf.toString() != "")
            {
                tv.setText(buf.toString());
                Toast.makeText(this,externalCacheReference+" /myfile2.txt",Toast.LENGTH_LONG).show();
            }
            else
            {
                tv.setText("<eRroR> :(");
                Toast.makeText(this,"Couldn't find myfile2.txt",Toast.LENGTH_LONG).show();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if(fis!=null)
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void loadFromPrivateExternalStorage(View v){
        File privateExternalStorageReference = getExternalFilesDir("PrivateExternalStorageFolder");
        File myfile = new File(privateExternalStorageReference,"myfile3.txt");
        StringBuffer buf = new StringBuffer(); //buf is created and initialized to null
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(myfile);
            int token;
            while((token=fis.read())!= -1){
                buf.append((char)token);
            }
            if(buf.toString() != "")
            {
                tv.setText(buf.toString());
                Toast.makeText(this,privateExternalStorageReference+" /myfile3.txt",Toast.LENGTH_LONG).show();
            }
            else
            {
                tv.setText("<eRroR> :(");
                Toast.makeText(this,"Couldn't find myfile3.txt",Toast.LENGTH_LONG).show();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if(fis!=null)
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void loadFromPublicExternalStorage(View v){
        File publicExternalStorageReference = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File myfile = new File(publicExternalStorageReference,"myfile4.txt");
        StringBuffer buf = new StringBuffer(); //buf is created and initialized to null
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(myfile);
            int token;
            while((token=fis.read())!= -1){
                buf.append((char)token);
            }
            if(buf.toString() != "")
            {
                tv.setText(buf.toString());
                Toast.makeText(this,publicExternalStorageReference+" /myfile4.txt",Toast.LENGTH_LONG).show();
            }
            else
            {
                tv.setText("<eRroR> :(");
                Toast.makeText(this,"Couldn't find myfile4.txt",Toast.LENGTH_LONG).show();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if(fis!=null)
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void back(View v){
        startActivity(new Intent(this,CacheAndExternalStorageWritingData.class));
    }
    }


