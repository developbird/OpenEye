package layout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import adapter.SelectionHAdaprer;
import adapter.Selection_RecyclerAdapter;
import bean.SelectionBean;
import bean.SlectionFooterBean;
import okhttp3.Call;
import util.Constant;
import yin.openeye.R;
import yin.openeye.Selection_WebView_Activity;

/**
 * Created by Administrator on 2016/9/12.
 */
public class SelectionFragment extends Fragment {
    private static final String TAG ="SelctionFragment" ;
    private RecyclerView recyclerView;
    private Selection_RecyclerAdapter adapter;
    private SelectionBean selectionBean = new SelectionBean();
    private List<SelectionBean.SectionListBean.FooterBean> footerBeanList = new ArrayList<>();
    private List<SelectionBean.SectionListBean.ItemListBean.DataBean> data = new ArrayList<>();
    private List<SelectionBean.SectionListBean.ItemListBean.DataBean> dataId2 = new ArrayList<>();

    private int flag = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selection,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        linearManager();
        if (flag==1){
            flag++;
            getData();
        }
        return view;
    }


    private void linearManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        //设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Selection_RecyclerAdapter(getContext(),data);
       // newAdapter = new SelectionHAdaprer(data,getContext());
        recyclerView.setAdapter(adapter);
    }

    public void getData() {

        OkHttpUtils
                .get()
                .url(Constant.SELECTIONPATH)
                .build()
                .execute(new StringCallback() {

                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {

                        //这是下载下来的字符串
                       // Log.e(TAG,"======================response========================"+response);
                        Gson gson = new Gson();
                        selectionBean = gson.fromJson(response, SelectionBean.class);
                        List<SelectionBean.SectionListBean> sectionList = selectionBean.getSectionList();




                        for (SelectionBean.SectionListBean s:sectionList) {
                            //这是id为2解析的数据
                            if (s.getId()==2&&s.getType().equals("tagSection")){
                                List<SelectionBean.SectionListBean.ItemListBean> itemList2 = s.getItemList();
                                for (SelectionBean.SectionListBean.ItemListBean itemListBean:itemList2){
                                    if (itemListBean.getType().equals("videoCollectionWithCover"))
                                        if (itemListBean.getData().getDataType().equals("VideoCollection")) {
                                            String cover = itemListBean.getData().getHeaderBean().getCover();
                                            String actionUrl = itemListBean.getData().getActionUrl();

                                            SelectionBean.SectionListBean.ItemListBean.DataBean dataBean = new SelectionBean.SectionListBean.ItemListBean.DataBean();
                                            SelectionBean.SectionListBean.ItemListBean.DataBean.HeaderBean header = new SelectionBean.SectionListBean.ItemListBean.DataBean.HeaderBean();
                                            header.setCover(cover);
                                            dataBean.setHeaderBean(header);
                                           // Log.e(TAG, "header=" + dataBean.getHeaderBean().getCover());
                                           // data.add(dataBean);

                                        }
                                }

                            }
                            //这是id为1解析的数据
                            if (s.getId()==1){
                                List<SelectionBean.SectionListBean.ItemListBean> itemList = s.getItemList();
                                for (SelectionBean.SectionListBean.ItemListBean itemListBean:itemList) {
                                    if (itemListBean.getType()!=null) {
                                        String type = itemListBean.getType();
                                        if ("video".equals(type)){
                                            String title = itemListBean.getData().getTitle(); //标题
                                            String category = itemListBean.getData().getCategory();//种类
                                            int duration = itemListBean.getData().getDuration();//时间
                                            String feed = itemListBean.getData().getCover().getFeed(); //视频图片
                                            String dataType = itemListBean.getData().getDataType();//数据类型

                                            SelectionBean.SectionListBean.ItemListBean.DataBean dataBean = new SelectionBean.SectionListBean.ItemListBean.DataBean();
                                            SelectionBean.SectionListBean.ItemListBean.DataBean.CoverBean1 coverBean = new SelectionBean.SectionListBean.ItemListBean.DataBean.CoverBean1();

                                            dataBean.setTitle(title);
                                            dataBean.setCategory(category);
                                            dataBean.setDuration(duration);
                                            coverBean.setFeed(feed);
                                           // Log.e(TAG,"========coverBean.getFeed()============"+coverBean.getFeed());
                                            dataBean.setCover(coverBean);
                                            dataBean.setDataType(dataType);

                                            data.add(dataBean);
                                        }
                                    }
                                }
                            }
                        }
                           // Log.e(TAG, "onResponse: "+feedList.size() );
                            adapter.notifyDataSetChanged();
                    }
                });
    }

}
