package Hodler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import yin.openeye.R;

/**
 * Created by Yin on 2016/9/12.
 */
public class Discover_Holder1 extends RecyclerView.ViewHolder{

    public TextView mTextView;
    public ImageView mImageView;

    public Discover_Holder1(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.text);
        mImageView = (ImageView) itemView.findViewById(R.id.img);

    }

}
