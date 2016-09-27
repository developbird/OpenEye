package yin.openeye;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.Discover_List1Adapter;
import adapter.Discover_List2Adapter;
import adapter.Discover_ViewPager_ItemAdapter;
import bean.Discover_Item_Bean;

public class Author_Item_Activity extends AppCompatActivity {

    private List<Discover_Item_Bean.ItemListBean.DataBean> mList = new ArrayList<>();
    private Discover_List1Adapter mAdapter1;
    private Discover_List2Adapter mAdapter2;
    private Discover_Item_Bean.ItemListBean.DataBean mData;
    private Discover_Item_Bean.ItemListBean.DataBean.CoverBean mCover;
    private ViewPager mViewPager;
    private Discover_ViewPager_ItemAdapter mItemAdapter;
    private List<View> mViewList = new ArrayList<>();
    private View mView1;
    private View mView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.author_itme_activity);
       // mViewPager= (ViewPager) findViewById(R.id.viewPager);
       // mViewPager.setAdapter(new ViewPagerAdapter(mViewList,this));


    }

    class ViewPagerAdapter extends PagerAdapter {
        private List<View> list;
        private Context context;

        public ViewPagerAdapter(List<View> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            List<String> list1=new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                list1.add("itrm"+i);
            }
            View view = LayoutInflater.from(context).inflate(R.layout.author_itme_activity, null);
            ListView listView = (ListView) view.findViewById(R.id.listView);
            listView.setAdapter(new ArrayAdapter<String>(
                    context,android.R.layout.simple_expandable_list_item_1,list1));
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return  view== object;
        }
    }




}
