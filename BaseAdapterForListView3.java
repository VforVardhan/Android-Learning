package shreevardhan.slidenerd;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BaseAdapterForListView3 extends AppCompatActivity implements OnItemClickListener {
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_for_list_view3);
        lv= (ListView) findViewById(R.id.listView);
        lv.setAdapter(new AdapterThree(this));
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent obj=new Intent(android.content.Intent.ACTION_VIEW);

            switch(position) {
                case 0:
                    obj.setData(Uri.parse("https://en.m.wikipedia.org/wiki/Spider-Man"));
                    break;
                case 1:
                    obj.setData(Uri.parse("https://en.m.wikipedia.org/wiki/Hulk_(comics)"));
                case 2:
                    obj.setData(Uri.parse("https://en.m.wikipedia.org/wiki/Iron_Man"));
                    break;
                case 3:
                    obj.setData(Uri.parse("https://en.m.wikipedia.org/wiki/Wolverine_(character)"));
                    break;
                case 4:
                    obj.setData(Uri.parse("https://en.wikipedia.org/wiki/Captain_America"));
                    break;
                case 5:
                    obj.setData(Uri.parse("https://en.wikipedia.org/wiki/Thor_(Marvel_Comics)"));
                    break;
                case 6:
                    obj.setData(Uri.parse("https://en.wikipedia.org/wiki/Black_Widow_(Natasha_Romanova)"));
                    break;
                case 7:
                    obj.setData(Uri.parse("https://en.wikipedia.org/wiki/Green_Lantern"));
                    break;
                case 8:
                    obj.setData(Uri.parse("https://en.wikipedia.org/wiki/Superman"));
                    break;
                case 9:
                    obj.setData(Uri.parse("https://en.wikipedia.org/wiki/Flash_(comics)"));
                    break;
                case 10:
                    obj.setData(Uri.parse("https://en.wikipedia.org/wiki/Batman"));
                    break;
                case 11:
                    obj.setData(Uri.parse("https://en.wikipedia.org/wiki/Wonder_Woman"));
                    break;
                case 12:
                    obj.setData(Uri.parse("https://en.wikipedia.org/wiki/Cyborg_(comics)"));
                    break;
                case 13:
                    obj.setData(Uri.parse("https://en.wikipedia.org/wiki/Cyborg_(comics)"));
                    break;
            }
            startActivity(Intent.createChooser(obj,"Chaar options hain !"));

        }
}

class Data
{
    int image;
    String name,description;
    Data(int image,String name,String description)
    {
        this.image=image;
        this.name=name;
        this.description=description;
    }
}
class AdapterThree extends BaseAdapter
{
    Context context_variable;

    ListViewActivity3 obj=new ListViewActivity3();
    int[] image=obj.image;                          //I'm using the object of ListViewActivity3 whose instance variables are three arrays image,name and description and a listview lv
                                                    //This object obj is being used to create our desired image array here by referencing the image array once created in ListViewActivity3
                                                   //This was better than writing int[] images={R.drawable.spiderman,...,...,....,...,...}
                                                   //int[] image={R.drawable.spiderman2,R.drawable.hulk2,R.drawable.ironman2,R.drawable.wolverine2,R.drawable.captainamerica2, R.drawabl1e.thor,R.drawable.blackwidow,R.drawable.greenlantern2,R.drawable.superman2,R.drawable.flash2,R.drawable.batman2,R.drawable.wonderwoman2,R.drawable.cyborg,R.drawable.aquaman};*/
    String[] name,description;

    ArrayList<Data> arlist=new ArrayList<Data>();

    AdapterThree(Context c)
    {
        this.context_variable=c;
        Resources res=context_variable.getResources();
        name=res.getStringArray(R.array.superhero_name);
        description= res.getStringArray(R.array.superhero_description);
        Data obj;
        for(int i=0;i<image.length;++i)
        {
            obj=new Data(image[i],name[i],description[i]);
            arlist.add(obj);
        }
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
        View root=convertView;
        ViewHolderBA holder;
        if(root==null)
        {
            LayoutInflater lay = (LayoutInflater) context_variable.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            root = lay.inflate(R.layout.sample_row_for_list_view3, parent, false);
            holder=new ViewHolderBA(root);
            root.setTag(holder);
        }
        else
        {
            holder= (ViewHolderBA) root.getTag();
        }

        holder.iv.setImageResource(arlist.get(position).image);
        holder.tv1.setText(arlist.get(position).name);holder.tv1.setTextColor(Color.BLACK);
        holder.tv2.setText(arlist.get(position).description);

        return root;
    }
}
class ViewHolderBA
{
    ImageView iv;
    TextView tv1,tv2;

    ViewHolderBA(View v)
    {
        iv=(ImageView)v.findViewById(R.id.imageView);
        tv1=(TextView)v.findViewById(R.id.textView1);
        tv2=(TextView)v.findViewById(R.id.textView2);

    }
}
