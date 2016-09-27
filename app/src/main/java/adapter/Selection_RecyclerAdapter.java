package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import bean.SelectionBean;
import util.StringToTime;
import yin.openeye.DiscoverItem1Activity;
import yin.openeye.R;
import yin.openeye.Selection_WebView_Activity;
import yin.openeye.VideoActivity;

/**
 * Created by Administrator on 2016/9/12.
 */
public class Selection_RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_01=1,TYPE_02=2,TYPE_03=3,TYPE_04=4;
    private static final String TAG ="Sel_Rec" ;
    private Context context;
    private List<SelectionBean.SectionListBean.ItemListBean.DataBean> data;
    private int flag=1;


    public Selection_RecyclerAdapter(Context context,List<SelectionBean.SectionListBean.ItemListBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case TYPE_01:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selection_item_01,parent,false);
                ImageView imageView = (ImageView) view.findViewById(R.id.webImg);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        parent.getContext().startActivity(new Intent(parent.getContext(), Selection_WebView_Activity.class));
                    }
                });
                return new holder1(view);
            case TYPE_02:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selection_item_02,parent,false);
                ImageView image = (ImageView) view.findViewById(R.id.sili_background);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        parent.getContext().startActivity(new Intent(parent.getContext(), VideoActivity.class));
                    }
                });
                return new holder2(view);
            case TYPE_03:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selection_item_03_textheader,parent,false);
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.selection_item03_lin);
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        parent.getContext().startActivity(new Intent(parent.getContext(), DiscoverItem1Activity.class));
                    }
                });
                return new holder3(view);
            case TYPE_04:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selection_item_04,parent,false);
                return new holder4(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String imagePath = "http://img.kaiyanapp.com/b55762cce4247512c8719a65738ec679.jpeg?imageMogr2/quality/60";
            if (holder instanceof holder1){
                holder1 holderWebView = (holder1) holder;
                    Picasso.with(context)
                            .load(imagePath)
                            .fit()
                            .centerCrop()
                            .into(holderWebView.imageView);
            }

        if (holder instanceof holder2){
            holder2 holder02 = (holder2) holder;
            if (data.get(position-1)!=null&&holder02.imageView!=null){
                Picasso.with(context).load(data.get(position-1).getCover().getFeed()).fit().into(holder02.imageView);
                holder02.type.setText("#"+data.get(position-1).getCategory()+"   /   ");
                holder02.title.setText(data.get(position-1).getTitle());
                String time = StringToTime.secToTime((int) data.get(position-1).getDuration());
                holder02.time.setText(time+"");
            }

        }

        if (holder instanceof holder3){
            holder3 holder03 = (holder3) holder;
            holder03.textView.setText("查看往期编辑精选");
        }
        if (holder instanceof holder4){
            holder4 holder04 = (holder4) holder;
        }
    }


    @Override
    public int getItemCount() {
        return data.size()+1+1+1;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0){
            return TYPE_01;
        }
        if (position>0&&position<=data.size()){
            return TYPE_02;
        }if (position>data.size()&&position<=data.size()+1){
            return TYPE_03;
        }
        return TYPE_04;
    }

    class holder1 extends RecyclerView.ViewHolder{
        ImageView imageView;
        public holder1(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.webImg);
        }
    }
    class holder2 extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title,type,time;
        public holder2(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.sili_background);
            title = (TextView) itemView.findViewById(R.id.sili_title);
            type = (TextView) itemView.findViewById(R.id.sili_type);
            time = (TextView) itemView.findViewById(R.id.sili_time);
        }
    }
    class holder3 extends RecyclerView.ViewHolder{
        RelativeLayout relativeLayout;
        TextView textView;
        public holder3(View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.selection_item03_lin);
            textView = (TextView) itemView.findViewById(R.id.textFont);
        }
    }
    class holder4 extends RecyclerView.ViewHolder{

        ImageView imageView;
        HorizontalScrollView scrollView;
        public holder4(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item04_background);
            scrollView = (HorizontalScrollView) itemView.findViewById(R.id.item04_scroll);
        }
    }
}
