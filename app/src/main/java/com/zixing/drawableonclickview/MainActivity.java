package com.zixing.drawableonclickview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zixing.drawableoncliickview.DrawableClickView;
import com.zixing.drawableoncliickview.OnDrawableClickListener;
import com.zixing.drawableoncliickview.OnDrawableItemClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawableClickView tv = (DrawableClickView) findViewById(R.id.drawableTextView);

        tv.setOnDrawableClickListener(new OnDrawableClickListener() {
            @Override
            public void onLeftDrawableClick(DrawableClickView view) {
                toastShow("我是全部设置的Left");
            }

            @Override
            public void onTopDrawableClick(DrawableClickView view) {
                toastShow("我是全部设置的Top");
            }

            @Override
            public void onRightDrawableClick(DrawableClickView view) {
                toastShow("我是全部设置的Right");
            }

            @Override
            public void onBottomDrawableClick(DrawableClickView view) {
                toastShow("我是全部设置的Bottom");
            }
        });

        tv.setLeftDrawableClickListener(new OnDrawableItemClickListener() {
            @Override
            public void onDrawableClick(DrawableClickView view) {
                toastShow("我是分开设置的Left");
            }
        });
        tv.setTopDrawableClickListener(new OnDrawableItemClickListener() {
            @Override
            public void onDrawableClick(DrawableClickView view) {
                toastShow("我是分开设置的Top");
            }
        });
        tv.setRightDrawableClickListener(new OnDrawableItemClickListener() {
            @Override
            public void onDrawableClick(DrawableClickView view) {
                toastShow("我是分开设置的Right");
            }
        });
        tv.setButtomDrawableClickListener(new OnDrawableItemClickListener() {
            @Override
            public void onDrawableClick(DrawableClickView view) {
                toastShow("我是分开设置的Buttom");
            }
        });
    }

    private void toastShow(String msg) {

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
