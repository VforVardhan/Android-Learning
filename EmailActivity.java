package shreevardhan.slidenerd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {

   EditText etTo,etSubject,etBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        etTo=(EditText)findViewById(R.id.etTo);
        etSubject=(EditText)findViewById(R.id.etSubject);
        etBody=(EditText)findViewById(R.id.etBody);

        Toast obj=Toast.makeText(this,"Hello from Clarke Kent",Toast.LENGTH_SHORT);
        obj.setGravity(Gravity.TOP,100,100);
        obj.show();
        /*obj.setGravity(Gravity.BOTTOM,100,100);              obj.show();
        obj.setGravity(Gravity.LEFT,100,100);                  obj.show();
        obj.setGravity(Gravity.RIGHT,100,100);                 obj.show();
        obj.setGravity(Gravity.CENTER,100,100);                obj.show();
        obj.setGravity(Gravity.TOP | Gravity.RIGHT,100,100);   obj.show();
        obj.setGravity(Gravity.TOP | Gravity.LEFT,100,100);    obj.show();
        obj.setGravity(Gravity.BOTTOM | Gravity.RIGHT,100,100);obj.show();
        obj.setGravity(Gravity.LEFT | Gravity.BOTTOM,0,0);     obj.show();*/

    }

    public void SendEmail(View v){
        Intent obj=new Intent(Intent.ACTION_SEND);
        obj.setData(Uri.parse("mailto:"));
        String[] to={etTo.getText().toString()};
        obj.putExtra(Intent.EXTRA_EMAIL,to);
        obj.putExtra(Intent.EXTRA_SUBJECT,etSubject.getText().toString());
        obj.putExtra(Intent.EXTRA_TEXT,etBody.getText().toString());
        obj.setType("message/rfc822");
        startActivity(Intent.createChooser(obj,"Select an app"));
    }

}
