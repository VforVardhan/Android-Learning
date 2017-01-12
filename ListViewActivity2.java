package shreevardhan.slidenerd;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity2 extends AppCompatActivity implements OnItemClickListener{
    ListView lv;
    Button btn;
    String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Ravivar","Somvar","Mangalvar","Buddhvar","Brihaspativar","Shukravar","Shanivar","Jan","Feb","Mar","Apr","May","Jun","Jul", "Aug","Sep","Oct","Nov","Dec"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        lv=(ListView)findViewById(R.id.listView2);

        ArrayAdapter<String> obj =new ArrayAdapter<String>(this,R.layout.sample_row_for_list_view2,R.id.textView1,days);
        lv.setAdapter(obj);

        lv.setOnItemClickListener(this);

        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent();
                obj.setClassName("shreevardhan.slidenerd","shreevardhan.slidenerd.ListViewActivity3");
                startActivity(obj);
            }
        });
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView tv=(TextView)view.findViewById(R.id.textView1);
        Toast.makeText(this,tv.getText()+" "+position,Toast.LENGTH_SHORT).show();
        }
    }

