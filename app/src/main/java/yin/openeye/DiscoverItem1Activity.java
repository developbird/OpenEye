package yin.openeye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapter.Discover_List1Adapter;
import adapter.Discover_List2Adapter;
import adapter.Discover_ViewPager_ItemAdapter;
import bean.Discover_Item_Bean;
import okhttp3.Call;

public class DiscoverItem1Activity extends AppCompatActivity {

    private static final String TAG = "DiscoverItem1Activity";
    private View mView1;
    private View mView2;
    private ListView mListView1;
    private ListView mListView2;
    private ArrayList<Discover_Item_Bean.ItemListBean.DataBean> mList1 = new ArrayList<>();
    private ArrayList<Discover_Item_Bean.ItemListBean.DataBean> mList2 = new ArrayList<>();
    private Discover_List1Adapter mAdapter1;
    private Discover_List2Adapter mAdapter2;
    private Discover_Item_Bean.ItemListBean.DataBean mData1;
    private Discover_Item_Bean.ItemListBean.DataBean mData2;
    private Discover_Item_Bean.ItemListBean.DataBean.CoverBean mCover1;
    private Discover_Item_Bean.ItemListBean.DataBean.CoverBean mCover2;
    private ViewPager mViewPager;
    private Discover_ViewPager_ItemAdapter mItemAdapter;
    private List<View> mViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_item1);
        initView();
        initData();
        onClick();

        OkHttpUtils.get()
                    .url("http://baobab.wandoujia.com/api/v3/videos?categoryId=28&strategy=date&udid=34b31ff09dc24386b0e2a17cc3733d7f46cb4271&vc=134&vn=2.6.1&deviceModel=MI%203W&first_channel=eyepetizer_meizu_market&last_channel=eyepetizer_meizu_market&system_version_code=23")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray jsonArray = jsonObject.optJSONArray("itemList");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    mData1 = new Discover_Item_Bean.ItemListBean.DataBean();
                                    mCover1 = new Discover_Item_Bean.ItemListBean.DataBean.CoverBean();
                                    JSONObject object = jsonArray.optJSONObject(i);
                                    JSONObject data = object.optJSONObject("data");

                                    String title = data.optString("title");
                                    String category = data.optString("category");
                                    int releaseTime = data.optInt("releaseTime");
                                    String playUrl = data.optString("playUrl");

                                    mData1.setTitle(title);
                                    mData1.setCategory("#"+category+"   /   ");
                                    mData1.setReleaseTime(releaseTime);
                                    mData1.setPlayUrl(playUrl);

                                    JSONObject cover = data.optJSONObject("cover");
                                    String feed = cover.optString("feed");
                                    String blurred = cover.optString("blurred");

                                    mCover1.setFeed(feed);
                                    mCover1.setBlurred(blurred);
                                    mData1.setCover(mCover1);

                                    mList1.add(mData1);
                                }
                                mAdapter1.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

        OkHttpUtils.get()
                    .url("http://baobab.wandoujia.com/api/v3/videos?categoryId=28&strategy=shareCount&udid=34b31ff09dc24386b0e2a17cc3733d7f46cb4271&vc=134&vn=2.6.1&deviceModel=MI%203W&first_channel=eyepetizer_meizu_market&last_channel=eyepetizer_meizu_market&system_version_code=23")
                    .build()
                    .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.optJSONArray("itemList");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                mData2 = new Discover_Item_Bean.ItemListBean.DataBean();
                                mCover2 = new Discover_Item_Bean.ItemListBean.DataBean.CoverBean();
                                JSONObject object = jsonArray.optJSONObject(i);
                                JSONObject data = object.optJSONObject("data");

                                String title = data.optString("title");
                                String category = data.optString("category");
                                int releaseTime = data.optInt("releaseTime");
                                String playUrl = data.optString("playUrl");

                                mData2.setTitle(title);
                                mData2.setCategory("#"+category+"   /   ");
                                mData2.setReleaseTime(releaseTime);
                                mData2.setPlayUrl(playUrl);

                                JSONObject cover = data.optJSONObject("cover");
                                String feed = cover.optString("feed");
                                String blurred = cover.optString("blurred");

                                mCover2.setFeed(feed);
                                mCover2.setBlurred(blurred);
                                mData2.setCover(mCover2);

                                mList2.add(mData2);
                            }
                            mAdapter2.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


        mItemAdapter = new Discover_ViewPager_ItemAdapter(mViewList);
        mAdapter1 = new Discover_List1Adapter(mList1);
        mAdapter2 = new Discover_List2Adapter(mList2);

        mViewPager.setAdapter(mItemAdapter);
        mListView1.setAdapter(mAdapter1);
        mListView2.setAdapter(mAdapter2);

    }

    private void initView(){
        mView1 = LayoutInflater.from(this).inflate(R.layout.fragment_discover_item1,null);
        mView2 = LayoutInflater.from(this).inflate(R.layout.fragment_discover_item2,null);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mListView1 = (ListView) mView1.findViewById(R.id.listView);
        mListView2 = (ListView) mView2.findViewById(R.id.listView);
    }

    private void initData(){
        mViewList.add(mView1);
        mViewList.add(mView2);
    }

    private void onClick(){
        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DiscoverItem1Activity.this,VideoActivity.class);
//                intent.putExtra("list", mList1);
                startActivity(intent);
            }
        });

        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(DiscoverItem1Activity.this,VideoActivity.class));
            }
        });
    }

    public void clickTo(View view) {
        switch (view.getId()){
            case R.id.textView1:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.textView2:
                mViewPager.setCurrentItem(1);
                break;
        }
    }

}
