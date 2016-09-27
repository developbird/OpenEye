package adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yin on 2016/9/14.
 */
public class Discover_ViewPager_ItemAdapter extends PagerAdapter{

    private List<View> mList = new ArrayList<>();

    public Discover_ViewPager_ItemAdapter(List<View> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mList.get(position));
        return mList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
