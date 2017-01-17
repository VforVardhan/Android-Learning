package shreevardhan.slidenerd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BaseAdapterForListView1 extends AppCompatActivity implements OnItemClickListener{
    ListView lv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_for_list_view1);
        lv=(ListView)findViewById(R.id.listView);
        lv.setAdapter(new AdapterOne(this));
        lv.setOnItemClickListener(this);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent();
                obj.setClassName("shreevardhan.slidenerd","shreevardhan.slidenerd.BaseAdapterForListView2");
                startActivity(obj);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        TextView tv=(TextView)view;
        Toast.makeText(this,tv.getText()+" "+position,Toast.LENGTH_SHORT).show();
    }
}

class AdapterOne extends BaseAdapter
{
    Context context_variable;

    ArrayList<String> arlist=new ArrayList<String>();
    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Ravivar", "Somvar",
            "Mangalvar", "Buddhvar", "Brihaspativar", "Shukravar", "Shanivar", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
            "Aug", "Sep", "Oct", "Nov", "Dec"};

    AdapterOne(Context c)
    {
        this.context_variable=c;
        for (int i = 0; i < days.length; ++i)
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
        LayoutInflater lay = (LayoutInflater)context_variable.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root=lay.inflate(R.layout.sample_row_for_list_view,parent,false);

        TextView tv=(TextView)root;
        tv.setText(arlist.get(position));

        return root;
    }
}
