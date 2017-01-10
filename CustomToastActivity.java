package shreevardhan.slidenerd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class CustomToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);
    }

    public void showIronMan(View v)
    {
        Toast obj= new Toast(this);
        obj.setDuration(Toast.LENGTH_SHORT);
        obj.setGravity(Gravity.TOP,0,0);

        LayoutInflater lay=getLayoutInflater();
        View appear=lay.inflate(R.layout.ironman_layout,(ViewGroup)findViewById(R.id.ironmanLayoutRoot));
        obj.setView(appear);
        obj.show();
    }
    public void showSuperMan(View v)
    {
     Toast obj=new Toast(this);
        obj.setDuration(Toast.LENGTH_SHORT);
        obj.setGravity(Gravity.BOTTOM,0,0);

        LayoutInflater lay=getLayoutInflater();
        View appear= lay.inflate(R.layout.superman_layout,(ViewGroup)findViewById(R.id.supermanLayoutRoot));
        obj.setView(appear);
        obj.show();
    }
}

