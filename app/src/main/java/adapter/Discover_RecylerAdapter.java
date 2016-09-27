package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Hodler.Discover_Holder1;
import Hodler.Discover_Holder2;
import Hodler.Discover_Holder3;
import Hodler.Discover_Holder4;
import bean.DiscoverBean;
import yin.openeye.DiscoverItem1Activity;
import yin.openeye.DiscoverItem2Activity;
import yin.openeye.R;

/**
 * Created by Yin on 2016/9/12.
 */
public class Discover_RecylerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = "Discover_RecylerAdapter";
    private static final int ITEM_1 = 1 , ITEM_2 = 2 , ITEM_3 = 3 , ITEM_4 = 4;
    private ViewPager mViewPager;
    private ImageView mImageView1;
    private ImageView mImageView2;
    private Context mContext;
    private List<View> mList = new ArrayList<>();
    private List<DiscoverBean.ItemListBean.DataBean> mDataBeanList = new ArrayList<>();
    private List<DiscoverBean.ItemListBean.DataBean.ItemList.Data> mDatas = new ArrayList<>();
    private ImageView mImageView4;

    public Discover_RecylerAdapter(List<DiscoverBean.ItemListBean.DataBean> dataBeanList, List<DiscoverBean.ItemListBean.DataBean.ItemList.Data> datas, Context context) {
        mDataBeanList = dataBeanList;
        mDatas = datas;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case ITEM_1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_item1,parent,false);

                mImageView1 = (ImageView) view.findViewById(R.id.img);

                mImageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        parent.getContext().startActivity(new Intent(parent.getContext(), DiscoverItem1Activity.class));
                    }
                });

                return new Discover_Holder1(view);
            case ITEM_2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_item2,parent,false);

                mImageView2 = (ImageView) view.findViewById(R.id.img);

                mImageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        parent.getContext().startActivity(new Intent(parent.getContext(), DiscoverItem1Activity.class));
                    }
                });

                return new Discover_Holder2(view);
            case ITEM_3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_item3,parent,false);

                mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_pager1,parent,false);
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_pager2,parent,false);

                mList.add(view1);
                mList.add(view2);

                Discover_ViewPagerAdapter viewPagerAdapter = new Discover_ViewPagerAdapter(mList);
                mViewPager.setAdapter(viewPagerAdapter);
                return new Discover_Holder3(view);
            case ITEM_4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_item4,parent,false);

                mImageView4 = (ImageView) view.findViewById(R.id.img);

                mImageView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        parent.getContext().startActivity(new Intent(parent.getContext(), DiscoverItem2Activity.class));
                    }
                });

                return new Discover_Holder4(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       if (holder instanceof Discover_Holder1){
           Discover_Holder1 holder1 = (Discover_Holder1) holder;
           if (mDataBeanList.size() != 0){
               DiscoverBean.ItemListBean.DataBean dataBean = mDataBeanList.get(position);
               holder1.mTextView.setText(dataBean.getTitle());

               String image = dataBean.getImage();

               Picasso.with(mContext)
                       .load(image)
                       .into(holder1.mImageView);
           }

       }
       if (holder instanceof Discover_Holder2){
           Discover_Holder2 holder2 = (Discover_Holder2) holder;
           if (mDataBeanList.size() != 0){
               DiscoverBean.ItemListBean.DataBean dataBean = mDataBeanList.get(position);

               String image = dataBean.getImage();

               Picasso.with(mContext)
                       .load(image)
                       .into(holder2.mImageView);
           }
       }
       if (holder instanceof Discover_Holder3){
            Discover_Holder3 holder3 = (Discover_Holder3) holder;
            if (mDataBeanList.size() != 0){
                DiscoverBean.ItemListBean.DataBean.ItemList.Data data = mDatas.get(position);
                ImageView view1 = (ImageView) holder3.mViewPager.findViewById(R.id.img_1);
                ImageView view2 = (ImageView) holder3.mViewPager.findViewById(R.id.img_2);

                String image = data.getImage();
                if (view1!=null){
                    Picasso.with(mContext)
                            .load("http://img.kaiyanapp.com/a19c5789c937c2a2aa6c7f6249b0efb0.jpeg")
                            .into(view1);
                }

                if (view2!=null) {
                    Picasso.with(mContext)
                            .load(image)
                            .into(view2);
                }
            }

       }
       if (holder instanceof Discover_Holder4){
           Discover_Holder4 holder4 = (Discover_Holder4) holder;
           if (mDataBeanList.size() != 0){
               DiscoverBean.ItemListBean.DataBean dataBean = mDataBeanList.get(position);

               String image = dataBean.getImage();

               Picasso.with(mContext)
                       .load(image)
                       .into(holder4.mImageView);
           }
       }
    }

    @Override
    public int getItemCount() {
        return 22;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return ITEM_3;
        }
        if (position == 1){
            return ITEM_4;
        }
        if (position == 2){
            return ITEM_4;
        }
        if (position == 3){
            return ITEM_2;
        }
        return ITEM_1;
    }
}
