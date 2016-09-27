package Hodler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import yin.openeye.R;

/**
 * Created by Yin on 2016/9/12.
 */
public class Discover_Holder2 extends RecyclerView.ViewHolder{

    public ImageView mImageView;

    public Discover_Holder2(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.img);
    }
}
