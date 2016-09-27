package Hodler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import yin.openeye.R;

/**
 * Created by Administrator on 2016/9/18.
 */
public class Selection_Hodle extends RecyclerView.ViewHolder {

    private final ImageView imageView;
    private TextView title,type,time;

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTime() {
        return time;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getType() {
        return type;
    }

    public Selection_Hodle(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.sili_background);
        title = (TextView) itemView.findViewById(R.id.sili_title);
        type = (TextView) itemView.findViewById(R.id.sili_type);
        time = (TextView) itemView.findViewById(R.id.sili_time);

    }
}
