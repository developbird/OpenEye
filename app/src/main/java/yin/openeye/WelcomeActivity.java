package yin.openeye;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        img = (ImageView) findViewById(R.id.comebackground);

        init();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(2000);
                    startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void init() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(img,"scaleX",1,1.25f);
        animator.setDuration(3500);
        animator.setRepeatCount(Animation.INFINITE);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(img,"scaleY",1,1.25f);
        animator2.setDuration(3500);
        animator2.setRepeatCount(Animation.INFINITE);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator,animator2);
        set.start();
    }


}
