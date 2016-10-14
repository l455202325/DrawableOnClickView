package com.zixing.drawableonclickview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zixing.drawableoncliickview.DrawableClickTextView;
import com.zixing.drawableoncliickview.OnDrawableClickListener;
import com.zixing.drawableoncliickview.OnDrawableItemClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawableClickTextView tv = (DrawableClickTextView) findViewById(R.id.drawableTextView);

        tv.setOnDrawableClickListener(new OnDrawableClickListener() {
            @Override
            public void onLeftDrawableClick(DrawableClickTextView view) {
                toastShow("我是全部设置的Left");
            }

            @Override
            public void onTopDrawableClick(DrawableClickTextView view) {
                toastShow("我是全部设置的Top");
            }

            @Override
            public void onRightDrawableClick(DrawableClickTextView view) {
                toastShow("我是全部设置的Right");
            }

            @Override
            public void onBottomDrawableClick(DrawableClickTextView view) {
                toastShow("我是全部设置的Bottom");
            }
        });

        tv.setLeftDrawableClickListener(new OnDrawableItemClickListener() {
            @Override
            public void onDrawableClick(DrawableClickTextView view) {
                toastShow("我是分开设置的Left");
            }
        });
        tv.setTopDrawableClickListener(new OnDrawableItemClickListener() {
            @Override
            public void onDrawableClick(DrawableClickTextView view) {
                toastShow("我是分开设置的Top");
            }
        });
        tv.setRightDrawableClickListener(new OnDrawableItemClickListener() {
            @Override
            public void onDrawableClick(DrawableClickTextView view) {
                toastShow("我是分开设置的Right");
            }
        });
        tv.setButtomDrawableClickListener(new OnDrawableItemClickListener() {
            @Override
            public void onDrawableClick(DrawableClickTextView view) {
                toastShow("我是分开设置的Buttom");
            }
        });
    }

    private void toastShow(String msg) {

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
