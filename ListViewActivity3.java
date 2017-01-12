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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity3 extends AppCompatActivity implements OnItemClickListener
{

    int[] image={R.drawable.spiderman2,R.drawable.hulk2,R.drawable.ironman2,R.drawable.wolverine2,R.drawable.captainamerica2,
                 R.drawable.thor,R.drawable.blackwidow,
                 R.drawable.greenlantern2,R.drawable.superman2,R.drawable.flash2,R.drawable.batman2,R.drawable.wonderwoman2,
                 R.drawable.cyborg,R.drawable.aquaman};
    String[] name,description;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);

        Resources reso=getResources();
        name=reso.getStringArray(R.array.superhero_name);
        description=reso.getStringArray(R.array.superhero_description);

        lv=(ListView)findViewById(R.id.listView);

        HeroAdapter obj=new HeroAdapter(this,image,name,description);
        lv.setAdapter(obj);

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

 class HeroAdapter extends ArrayAdapter<String>
 {
     Context context_variable;
     int[] image_variable;
     String[] name_variable;
     String[] description_variable;

    HeroAdapter(Context c,int[] images,String[] names,String[] descriptions)
      {
        super(c,R.layout.sample_row_for_list_view3,R.id.textView1,names);
        this.context_variable=c;
        this.image_variable=images;
        this.name_variable=names;
        this.description_variable=descriptions;
      }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
      {
        View root=convertView;
        ViewHolder holder = null;
        if(root==null)
          {
            LayoutInflater lay = (LayoutInflater) context_variable.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            root = lay.inflate(R.layout.sample_row_for_list_view3, parent, false);
            holder = new ViewHolder(root);
            root.setTag(holder);
          }
        else
          {
            holder=(ViewHolder)root.getTag();
          }

          holder.iv.setImageResource(image_variable[position]);
          holder.tv1.setText(name_variable[position]);holder.tv1.setTextColor(Color.BLACK);
          holder.tv2.setText(description_variable[position]);

          return root;
      }
 }

class ViewHolder
    {
    ImageView iv;
    TextView tv1;
    TextView tv2;
    ViewHolder(View v)
       {
        iv=(ImageView)v.findViewById(R.id.imageView);
        tv1=(TextView)v.findViewById(R.id.textView1);
        tv2=(TextView)v.findViewById(R.id.textView2);
       }
    }

