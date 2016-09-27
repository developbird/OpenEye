package Hodler;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import yin.openeye.R;

/**
 * Created by Yin on 2016/9/12.
 */
public class Discover_Holder3 extends RecyclerView.ViewHolder{

    public ViewPager mViewPager;

    public Discover_Holder3(View itemView) {
        super(itemView);
        mViewPager = (ViewPager) itemView.findViewById(R.id.viewPager);
    }
}
