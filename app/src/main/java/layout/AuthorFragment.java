package layout;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import adapter.Author_RecylerAdapter;
import bean.Author_Item_Bean;
import okhttp3.Call;
import yin.openeye.R;

/**
 * Created by Administrator on 2016/9/12.
 */
public class AuthorFragment extends Fragment {
    private int flag=1;
    private String url="http://baobab.wandoujia.com/api/v3/tabs/pgcs?udid=161c77300fa34" +
            "445a5b59cd5ae2f4af879a4a342&vc=134&vn=2.6.1&deviceModel=m1%20note&first_channel=eyepet" +
            "izer_meizu_market&last_channel=eyepetizer_meizu_market&system_version_code=22";

    private RecyclerView mRecyclerView;
    private Author_RecylerAdapter mAdapter;
    private Author_Item_Bean itemList=new Author_Item_Bean();
    private List<Author_Item_Bean.ItemListBean> data=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=null;
        if (isNetworkConnected()){
            view=inflater.inflate(R.layout.author_fragment,container,false);
            mRecyclerView = (RecyclerView)view.findViewById(R.id.recycleView);
            mAdapter=new Author_RecylerAdapter(data,getContext());
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
            if (flag==1){
                getData();
                flag++;
            }
        }else {
            view=inflater.inflate(R.layout.nowifi,container,false);
        }





        return view;
    }

    public Object getData() {
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson=new Gson();
                        itemList=gson.fromJson(response, Author_Item_Bean.class);
                        data.addAll(itemList.getItemList());
                        mAdapter.notifyDataSetChanged();
                    }
                });

        return null;
    }
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }

}
