package Hodler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import yin.openeye.R;

/**
 * Created by Yin on 2016/9/13.
 */
public class Discover_Holder4 extends RecyclerView.ViewHolder{

    public ImageView mImageView;

    public Discover_Holder4(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.img);
    }
}
