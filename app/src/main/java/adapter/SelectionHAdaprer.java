package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import Hodler.Selection_Hodle;
import bean.SelectionBean;
import util.StringToTime;
import yin.openeye.R;

/**
 * Created by Administrator on 2016/9/18.
 */
public class SelectionHAdaprer extends RecyclerView.Adapter<Selection_Hodle> {
    private static final String TAG ="SelectionHAdaprer" ;
    private List<SelectionBean.SectionListBean.ItemListBean.DataBean> data;
    private Context context;

    public SelectionHAdaprer( List<SelectionBean.SectionListBean.ItemListBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public Selection_Hodle onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.selection_item_02, parent, false);
        return new Selection_Hodle(view);
    }

    @Override
    public void onBindViewHolder(Selection_Hodle holder, int position) {

        Log.e(TAG, "onBindViewHolder: " +position+"===="+data.size());

        if (data.get(position)!=null&&holder.getImageView()!=null){

            Picasso.with(context).load(data.get(position).getCover().getFeed()).fit().into(holder.getImageView());
            holder.getType().setText("#"+data.get(position).getCategory()+"   /   ");
            holder.getTitle().setText(data.get(position).getTitle());
            String time = StringToTime.secToTime((int) data.get(position).getDuration());
            holder.getTime().setText(time+"");
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }
}
