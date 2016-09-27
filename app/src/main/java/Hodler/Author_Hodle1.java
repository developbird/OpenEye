package Hodler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import bean.Author_Item_Bean;
import de.hdodenhof.circleimageview.CircleImageView;
import yin.openeye.Author_Item_Activity;
import yin.openeye.Author_Item_Item_Activity;
import yin.openeye.R;

/**
 * Created by hd on 2016/9/12 0012.
 */
public class Author_Hodle1 extends RecyclerView.ViewHolder implements View.OnClickListener {
    private String TAG = "Author_Hodle1";
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private List<Author_Item_Bean.ItemListBean.DataBean.ItemItemListBean> itemList = new ArrayList<>();
    private static final int ITEM_1 = 1, ITEM_2 = 2, ITEM_3 = 3;
    private final RecyclerView recyclerView;
    private Context context;
    private ImageView icon;


    private TextView title;
    private TextView description;
    private TextView subTitle;
    private int flag = 1;


    public void setIcon(ImageView icon) {
        this.icon = icon;
    }

    public void setSubTitle(TextView subTitle) {
        this.subTitle = subTitle;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }


    public ImageView getIcon() {
        return icon;
    }

    public TextView getSubTitle() {
        return subTitle;
    }

    public TextView getDescription() {
        return description;
    }

    public TextView getTitle() {
        return title;
    }

    public void setItemRecyclerView(List<Author_Item_Bean.ItemListBean.DataBean.ItemItemListBean> itemListpath) {
        if (flag == 1) {
            itemList.addAll(itemListpath);
            mRecyclerViewAdapter.notifyDataSetChanged();
            flag++;
        }
    }

    public Author_Hodle1(View itemView, Context context) {
        super(itemView);
        this.context = context;
        TextView textView = (TextView) itemView.findViewById(R.id.t11);
        icon = (CircleImageView) itemView.findViewById(R.id.img);
        title = (TextView) itemView.findViewById(R.id.t1);
        description = (TextView) itemView.findViewById(R.id.t2);
        subTitle = (TextView) itemView.findViewById(R.id.t3);
        //嵌套recycleView
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerViewAdapter = new RecyclerViewAdapter(itemList, context);
            recyclerView.setAdapter(new RecyclerViewAdapter(itemList, context));
        }
        itemView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context, Author_Item_Activity.class);
        context.startActivity(intent);
    }


    private class RecyclerViewHodle extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView itemTitle;
        private final TextView category;
        private final ImageView feed;
        private final TextView duration;

        public RecyclerViewHodle(View itemView) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.t4);
            category = (TextView) itemView.findViewById(R.id.t5);
            feed = (ImageView) itemView.findViewById(R.id.img11);
            duration = (TextView) itemView.findViewById(R.id.t7);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, Author_Item_Item_Activity.class);
            // intent.putExtra("wedView",)
            context.startActivity(intent);
        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHodle> {
        private List<Author_Item_Bean.ItemListBean.DataBean.ItemItemListBean> itemList;
        private Context context;

        public RecyclerViewAdapter(List<Author_Item_Bean.ItemListBean.DataBean.ItemItemListBean> itemList, Context context) {
            this.itemList = itemList;
            this.context = context;
        }

        @Override
        public RecyclerViewHodle onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.author_recycler_view_hodle, parent, false);
            return new RecyclerViewHodle(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHodle holder, int position) {
            Author_Item_Bean.ItemListBean.DataBean data = itemList.get(position).getData();
            holder.itemTitle.setText(itemList.get(position).getData().getTitle());
            holder.category.setText("#" + itemList.get(position).getData().getCategory());
            if (data.getCover().getFeed() != null) {
                Picasso.with(context).load(data.getCover().getFeed())
                        .into(holder.feed);
            }

            int duration = data.getDuration();
            String s = secToTime(duration);
            holder.duration.setText(s);
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }

    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }


}
