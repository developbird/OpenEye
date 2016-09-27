package yin.openeye;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity {


    private static final String TAG = "VideoActivity";
    private JCVideoPlayerStandard mVideoView;
    private JCVideoPlayer.JCAutoFullscreenListener sensorEventListener;
    private SensorManager sensorManager;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();

//        ArrayList<Discover_Item_Bean.ItemListBean.DataBean> list1 = (ArrayList) getIntent().getSerializableExtra("list");

//        for (Discover_Item_Bean.ItemListBean.DataBean bean: list1) {
//            Log.e(TAG,bean.toString());
//        }
        String videoViewURL="http://baobab.wandoujia.com/api/v1/playUrl?vid=8900&editionType=default";
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            videoViewURL= bundle.getString("videoViewURL");
        }


        String path = videoViewURL;
        mVideoView.setUp(path, JCVideoPlayer.SCREEN_LAYOUT_LIST,"");

        Picasso.with(this)
                .load("http://img.kaiyanapp.com/d20c6f727a009c2b1ad7ccb724d1f09c.jpeg?imageMogr2/quality/60")
                .into(mImageView);
    }

    private void initView() {
        mVideoView = (JCVideoPlayerStandard) findViewById(R.id.videoView);
        mImageView = (ImageView) findViewById(R.id.img);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(sensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

}
