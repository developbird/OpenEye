package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapter.Discover_RecylerAdapter;
import bean.DiscoverBean;
import okhttp3.Call;
import yin.openeye.R;

public class DiscoverFragment extends Fragment {

    private static final String TAG = "DiscoverFragment";
    private RecyclerView mRecylerView;
    private Discover_RecylerAdapter mAdapter;
    private List<DiscoverBean.ItemListBean.DataBean> mDataBeanList = new ArrayList<>();
    private List<DiscoverBean.ItemListBean.DataBean.ItemList.Data> mDatas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        mRecylerView = (RecyclerView) view.findViewById(R.id.recycleView);
        mAdapter = new Discover_RecylerAdapter(mDataBeanList, mDatas, getActivity());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);

        OkHttpUtils.get()
                .url("http://baobab.wandoujia.com/api/v3/discovery?udid=34b31ff09dc24386b0e2a17cc3733d7f46cb4271&vc=126&vn=2.4.1&deviceModel=MI%203W&first_channel=eyepetizer_web&last_channel=eyepetizer_web&system_version_code=23")
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

                                DiscoverBean.ItemListBean.DataBean mDataBean = new DiscoverBean.ItemListBean.DataBean();
                                DiscoverBean.ItemListBean.DataBean.ItemList.Data mData = new DiscoverBean.ItemListBean.DataBean.ItemList.Data();

                                JSONObject object = jsonArray.optJSONObject(i);
                                JSONObject data = object.optJSONObject("data");
                                JSONArray itemList = data.optJSONArray("itemList");

                                if (itemList != null){
                                    for (int j = 0; j < itemList.length(); j++) {
                                        JSONObject object1 = itemList.optJSONObject(j);
                                        JSONObject data1 = object1.optJSONObject("data");
                                        String string = data1.optString("image");

                                        mData.setImage(string);

                                        mDatas.add(mData);
                                    }
                                }

                                String image = data.optString("image");
                                String title =  data.optString("title");

                                mDataBean.setTitle(title);
                                mDataBean.setImage(image);

                                mDataBeanList.add(mDataBean);

                            }
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0){
                    return 2;
                }
                if (position == 3){
                    return 2;
                }
                return 1;
            }
        });

        mRecylerView.setLayoutManager(gridLayoutManager);
        mRecylerView.setAdapter(mAdapter);

        return view;
    }

}
