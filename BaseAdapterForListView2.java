package shreevardhan.slidenerd;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BaseAdapterForListView2 extends AppCompatActivity implements OnItemClickListener {
    ListView lv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_for_list_view2);
        lv=(ListView)findViewById(R.id.listView);
        lv.setAdapter(new AdapterTwo(this));
        lv.setOnItemClickListener(this);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent();
                obj.setClassName("shreevardhan.slidenerd","shreevardhan.slidenerd.BaseAdapterForListView3");
                startActivity(obj);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv=(TextView)view.findViewById(R.id.textView1);
        Toast.makeText(this,tv.getText()+" "+position,Toast.LENGTH_SHORT).show();

       /*--------PROJECT FLAG BLUEPRINT--------
        Toast obj=new Toast(this);
        LayoutInflater lay=getLayoutInflater();
        View root=lay.inflate(R.layout.flags,(ViewGroup)findViewById(R.id.root));

        ImageView iv= (ImageView) root.findViewById(R.id.imageView);
        int[] image={R.drawable.spiderman2,R.drawable.hulk2,R.drawable.ironman2,R.drawable.wolverine2,R.drawable.captainamerica2,
                R.drawable.thor,R.drawable.blackwidow,
                R.drawable.greenlantern2,R.drawable.superman2,R.drawable.flash2,R.drawable.batman2,R.drawable.wonderwoman2,
                R.drawable.cyborg,R.drawable.aquaman};
        iv.setImageResource(image[position]);

        obj.setView(root);
        obj.setDuration(Toast.LENGTH_SHORT);
        obj.show();*/

    }
}

class AdapterTwo extends BaseAdapter
{
    Context context_variable;
    ListViewActivity2 obj=new ListViewActivity2();
    String[] days=obj.days;       //I'm using the object of ListViewActivity2 whose instance variables are days and a listview lv
    //This object obj is being used to create our desired days array here by referencing the days array once created in ListViewActivity2

    //This was better than writing int[] images={R.drawable.spiderman,...,...,....,...
    /*String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Ravivar", "Somvar",
            "Mangalvar", "Buddhvar", "Brihaspativar", "Shukravar", "Shanivar", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
            "Aug", "Sep", "Oct", "Nov", "Dec"};*/
    ArrayList<String> arlist=new ArrayList<String>();

    AdapterTwo(Context c)
    {
        this.context_variable=c;
        for(int i=0;i<days.length;++i)
            arlist.add(days[i]);
    }
    @Override
    public int getCount() {
        return arlist.size();
    }

    @Override
    public Object getItem(int position) {
        return arlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater lay=(LayoutInflater)context_variable.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root=lay.inflate(R.layout.sample_row_for_list_view2,parent,false);

        TextView tv=(TextView)root.findViewById(R.id.textView1);
        tv.setText(arlist.get(position));

        return root;
    }
}
