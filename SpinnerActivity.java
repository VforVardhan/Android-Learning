package shreevardhan.slidenerd;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity implements OnItemSelectedListener{

    Spinner sp;
    String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        sp=(Spinner)findViewById(R.id.spinner);
        /*ArrayAdapter<String> obj= new ArrayAdapter<String>(this,R.layout.sample_row_for_list_view,days);  //The is one way of creating spinner
        obj.setDropDownViewResource(R.layout.dropdownspinner);
        sp.setAdapter(obj);*/

        ArrayAdapter<CharSequence> obj2 = ArrayAdapter.createFromResource(this,R.array.superhero_name,R.layout.sample_row_for_list_view);  //This is the xml way of creating spinner
        obj2.setDropDownViewResource(R.layout.dropdownspinner);
        sp.setAdapter(obj2);
        sp.setOnItemSelectedListener(this);


        //sp.setAdapter(new AdapterFour(this));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ListViewActivity3 obj=new ListViewActivity3();
        int[] images=obj.image;                        //I'm using the object of ListViewActivity3 whose instance variables are three arrays image,name and description
                                                       //This object obj is being used to create our desired images array here by referencing the image array once created in ListViewActivity3
                                                       //This was better than writing int[] images={R.drawable.spiderman,...,...,....,....};
        Toast toast=new Toast(this);
        LayoutInflater lay=getLayoutInflater();
        View root=lay.inflate(R.layout.superhero_toast,(ViewGroup)findViewById(R.id.root));
        ImageView iv=(ImageView)root.findViewById(R.id.imageView);
        iv.setImageResource(images[position]);
        toast.setView(root);
        toast.setGravity(Gravity.BOTTOM,0,150);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

}
//Just use sp.setAdapter(new AdapterFour(this); in the onCreate() method ----> This is the BaseAdapter approach of creating spinner

//---------------------------------BUT HOW WILL YOU setDropDownViewResource here ?????-------------------------
/*class AdapterFour extends BaseAdapter
{
    Context context_variable;
    String[] superheroNames;
    AdapterFour(Context c)
    {
        this.context_variable=c;
        Resources res=context_variable.getResources();
        superheroNames=res.getStringArray(R.array.superhero_name);
    }

    @Override
    public int getCount() {
        return superheroNames.length;
    }

    @Override
    public Object getItem(int position) {
        return superheroNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater lay= (LayoutInflater) context_variable.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root=lay.inflate(R.layout.sample_row_for_list_view,parent,false);
        TextView tv= (TextView) root;
        tv.setText(superheroNames[position]);
        return root;
    }
}*/
