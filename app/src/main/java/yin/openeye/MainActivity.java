package yin.openeye;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.Main_ViewPagerAdapter;
import layout.AuthorFragment;
import layout.DiscoverFragment;
import layout.MineFragment;
import layout.SelectionFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ViewPager viewPager;
    List<Fragment> listFragment ;
    private ImageView sImage,dImage,aImage,mImage;
    private LinearLayout selection,discover,author,mine;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
         handler=new Handler(){
            @Override
            public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
                switch (msg.what){
                    case 0:
                        sImage.setImageResource(R.drawable.ic_tab_strip_icon_feed_selected);
                        dImage.setImageResource(R.drawable.ic_tab_strip_icon_category);
                        aImage.setImageResource(R.drawable.ic_tab_strip_icon_pgc);
                        mImage.setImageResource(R.drawable.ic_tab_strip_icon_profile);
                        break;
                    case 1:
                        sImage.setImageResource(R.drawable.ic_tab_strip_icon_feed);
                        dImage.setImageResource(R.drawable.ic_tab_strip_icon_category_selected);
                        aImage.setImageResource(R.drawable.ic_tab_strip_icon_pgc);
                        mImage.setImageResource(R.drawable.ic_tab_strip_icon_profile);
                        break;
                    case 2:
                        sImage.setImageResource(R.drawable.ic_tab_strip_icon_feed);
                        dImage.setImageResource(R.drawable.ic_tab_strip_icon_category);
                        aImage.setImageResource(R.drawable.ic_tab_strip_icon_pgc_selected);
                        mImage.setImageResource(R.drawable.ic_tab_strip_icon_profile);
                        break;
                    case 3:
                        sImage.setImageResource(R.drawable.ic_tab_strip_icon_feed);
                        dImage.setImageResource(R.drawable.ic_tab_strip_icon_category);
                        aImage.setImageResource(R.drawable.ic_tab_strip_icon_pgc);
                        mImage.setImageResource(R.drawable.ic_tab_strip_icon_profile_selected);
                        break;
                }
                return super.sendMessageAtTime(msg, uptimeMillis);

            }
        };
        initListener();
        initFragment();

    }

    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                handler.sendEmptyMessage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        selection.setOnClickListener(this);
        discover.setOnClickListener(this);
        author.setOnClickListener(this);
        mine.setOnClickListener(this);

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        selection = (LinearLayout) findViewById(R.id.selectionLayout);
        discover = (LinearLayout) findViewById(R.id.discoverLayout);
        author = (LinearLayout) findViewById(R.id.authorLayout);
        mine = (LinearLayout) findViewById(R.id.mineLayout);

        sImage = (ImageView) findViewById(R.id.sImage);
        dImage = (ImageView) findViewById(R.id.dImage);
        aImage = (ImageView) findViewById(R.id.aImage);
        mImage = (ImageView) findViewById(R.id.mImage);
    }

    //添加碎片，初始化ViewPager
    private void initFragment() {
        //寻找碎片数据
        listFragment = new ArrayList<>();
        listFragment.add(new SelectionFragment());
        listFragment.add(new DiscoverFragment());
        listFragment.add(new AuthorFragment());
        listFragment.add(new MineFragment());

        //获取适配器
        Main_ViewPagerAdapter adapter = new Main_ViewPagerAdapter(getSupportFragmentManager(),listFragment);
        viewPager.setAdapter(adapter);
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.selectionLayout:
                viewPager.setCurrentItem(0);
                break;
            case R.id.discoverLayout:
                viewPager.setCurrentItem(1);
                break;
            case R.id.authorLayout:
                viewPager.setCurrentItem(2);
                break;
            case R.id.mineLayout:
                viewPager.setCurrentItem(3);
                break;
        }
    }
}
