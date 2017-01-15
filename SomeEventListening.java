package shreevardhan.slidenerd;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SomeEventListening extends AppCompatActivity implements OnClickListener,OnCheckedChangeListener{
    CheckBox sugar,milk;
    RelativeLayout root;
    ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some_event_listening);

        sugar=(CheckBox)findViewById(R.id.checkBox1);
        sugar.setOnClickListener(this);
        milk=(CheckBox)findViewById(R.id.checkBox2);
        milk.setOnClickListener(this);

        tb=(ToggleButton)findViewById(R.id.toggleButton);
        tb.setOnCheckedChangeListener(this);

        root=(RelativeLayout)findViewById(R.id.root);

    }
    @Override
    public void onClick(View v){
        if(v.getId()==R.id.checkBox1)
        {
            if(sugar.isChecked()==true)
                Toast.makeText(this,"Sweet Fella ;)",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"Diet Conscious ;)",Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.checkBox2)
        {
           if(milk.isChecked()==true)
               Toast.makeText(this,"Kid huh ;)",Toast.LENGTH_SHORT).show();
           else
               Toast.makeText(this,"Bade log ;)",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean b) {
        if(b==true){
            root.setBackgroundResource(R.drawable.gokussj3);
        }
        else{
            root.setBackgroundColor(0);   //unsetting the background
        }
    }


    }

