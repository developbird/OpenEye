package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import Hodler.Author_Hodle1;
import bean.Author_Item_Bean;
import yin.openeye.R;

/**
 * Created by Administrator on 2016/9/12.
 */
public class Author_RecylerAdapter extends RecyclerView.Adapter<Author_Hodle1>{
    private static final int ITEM_1 = 1 , ITEM_2 = 2 , ITEM_3 = 3;
    private List<Author_Item_Bean.ItemListBean> data;
    private Context context;
    private String TAG=" Author_RecylerAdapter";

    public Author_RecylerAdapter(List<Author_Item_Bean.ItemListBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public Author_Hodle1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case ITEM_1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.authoritme1,parent,false);
                return new Author_Hodle1(view,context);
            case ITEM_2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.authoritme2,parent,false);
                return new Author_Hodle1(view,context);

            case ITEM_3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.authoritme3,parent,false);
                return new Author_Hodle1(view,context);
        }
        view=LayoutInflater.from(parent.getContext()).inflate(R.layout.authoritmr4,parent,false);
        return new Author_Hodle1(view,context);
    }

    @Override
    public void onBindViewHolder(Author_Hodle1 holder, int position) {
        int flag=1;
        Author_Item_Bean.ItemListBean.DataBean data = this.data.get(position).getData();
        if (this.data.get(position).getData().getText()!=null){
        holder.getTitle().setText(this.data.get(position).getData().getText());}

        if (data.getIcon()!=null){
            Picasso.with(context).load(data.getIcon())
                    .into(holder.getIcon());
        }
        if (data.getTitle()!=null){
            holder.getTitle().setText(data.getTitle());
        }

        if (data.getSubTitle()!=null){
            holder.getSubTitle().setText(data.getSubTitle());
        }
        if (data.getDescription()!=null){
            holder.getDescription().setText(data.getDescription());
        }
       if (data.getHeader()!=null){
           Picasso.with(context).load(data.getHeader().getIcon())
                   .into(holder.getIcon());
           holder.getTitle().setText(data.getHeader().getTitle());
           holder.getSubTitle().setText(data.getHeader().getSubTitle());
           holder.getDescription().setText(data.getHeader().getDescription());
           List<Author_Item_Bean.ItemListBean.DataBean.ItemItemListBean> itemList = data.getItemList();

           if (itemList!=null) {
               if (flag==1){
                   holder.setItemRecyclerView(itemList);
                   flag++;
               }

           }

       }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {



        switch (data.get(position).getData().getDataType()){
            case  "LeftAlignTextHeader":
                    return ITEM_1;
            case "BriefCard":
                return ITEM_2;
            case "VideoCollection":
                return ITEM_3;

        }
        return 4;
    }

    public interface GetRecyclerViewAdapterData{
       void getData(List<Author_Item_Bean.ItemListBean.DataBean.ItemItemListBean> itemList);

    }



}
