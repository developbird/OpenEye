package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Discover_Item_Bean;
import yin.openeye.R;

/**
 * Created by Yin on 2016/9/14.
 */
public class Discover_List1Adapter extends BaseAdapter{

    private static final String TAG = "Discover_List1Adapter";
    private List<Discover_Item_Bean.ItemListBean.DataBean> mList = new ArrayList<>();

    public Discover_List1Adapter(List<Discover_Item_Bean.ItemListBean.DataBean> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if (view == null){
            holder = new Holder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discover_list_item,viewGroup,false);
            holder.textView1 = (TextView) view.findViewById(R.id.sili_title);
            holder.textView2 = (TextView) view.findViewById(R.id.sili_type);
            holder.textView3 = (TextView) view.findViewById(R.id.sili_time);
            holder.imageView = (ImageView) view.findViewById(R.id.sili_background);

            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        Discover_Item_Bean.ItemListBean.DataBean dataBean = mList.get(i);

        holder.textView1.setText(dataBean.getTitle());
        holder.textView2.setText(dataBean.getCategory());

        long releaseTime = dataBean.getReleaseTime();
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        String time = sdf.format(new Date(releaseTime));

        holder.textView3.setText(time);

        String feed = dataBean.getCover().getFeed();
        Picasso.with(viewGroup.getContext())
                .load(feed)
                .into(holder.imageView);


        return view;
    }

    class Holder{
        TextView textView1, textView2, textView3;
        ImageView imageView;
    }

}
