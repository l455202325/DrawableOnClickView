package com.zixing.drawableoncliickview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by zixing on 2016-10-13.
 */

public class DrawableClickView extends TextView {

    private OnDrawableClickListener onDrawableClickListener;
    private OnDrawableItemClickListener leftDrawableClickListener;
    private OnDrawableItemClickListener rightDrawableClickListener;
    private OnDrawableItemClickListener topDrawableClickListener;
    private OnDrawableItemClickListener bottomDrawableClickListener;

    private Drawable lfetDrawable;
    private Drawable rightDrawable;
    private Drawable topDrawable;
    private Drawable bottonDrawable;

    private int down_x;
    private int down_y;

    public void setOnDrawableClickListener(OnDrawableClickListener onDrawableClickListener) {
        this.onDrawableClickListener = onDrawableClickListener;
    }

    public void setLeftDrawableClickListener(OnDrawableItemClickListener leftDrawableClickListener) {
        this.leftDrawableClickListener = leftDrawableClickListener;
    }

    public void setRightDrawableClickListener(OnDrawableItemClickListener rightDrawableClickListener) {
        this.rightDrawableClickListener = rightDrawableClickListener;
    }

    public void setTopDrawableClickListener(OnDrawableItemClickListener topDrawableClickListener) {
        this.topDrawableClickListener = topDrawableClickListener;
    }

    public void setButtomDrawableClickListener(OnDrawableItemClickListener bottomDrawableClickListener) {
        this.bottomDrawableClickListener = bottomDrawableClickListener;
    }

    public DrawableClickView(Context context) {
        super(context);

    }

    public DrawableClickView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public DrawableClickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        lfetDrawable = getCompoundDrawables()[0];
        topDrawable = getCompoundDrawables()[1];
        rightDrawable = getCompoundDrawables()[2];
        bottonDrawable = getCompoundDrawables()[3];
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                down_x = (int)event.getRawX();
                down_y = (int)event.getRawY();

                break;
            case MotionEvent.ACTION_UP:
                int up_x = (int) event.getRawX();
                int up_y = (int) event.getRawY();

                if (handerDrawable(up_x, up_y,lfetDrawable,DrawableEnum.LEFT)) return true;
                if (handerDrawable(up_x, up_y,topDrawable,DrawableEnum.TOP)) return true;
                if (handerDrawable(up_x, up_y,rightDrawable,DrawableEnum.RIGHT)) return true;
                if (handerDrawable(up_x, up_y, bottonDrawable,DrawableEnum.BOTTOM)) return true;

                break;
        }
        return super.onTouchEvent(event);
    }

    private boolean handerDrawable(int up_x, int up_y,Drawable drawable,DrawableEnum drawableEnum) {
        if (null != drawable){
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);

            Rect lfetRect = drawable.getBounds();
            if (drawableEnum ==  DrawableEnum.LEFT){
                rect.right = rect.left + getCompoundDrawablePadding() + lfetRect.right + getPaddingLeft();
            }else if (drawableEnum ==  DrawableEnum.TOP){
                rect.bottom = rect.top + getCompoundDrawablePadding() + lfetRect.bottom + getPaddingTop();
            }else if (drawableEnum ==  DrawableEnum.RIGHT){
                rect.left = rect.right - getCompoundDrawablePadding() - lfetRect.right - getPaddingRight();
            }else if (drawableEnum ==  DrawableEnum.BOTTOM){
                rect.top = rect.bottom - getCompoundDrawablePadding() - lfetRect.bottom - getPaddingBottom();
            }


            if (rect.contains(down_x,down_y) && rect.contains(up_x,up_y)){
                if (null  != onDrawableClickListener){
                    if (drawableEnum == DrawableEnum.LEFT){
                        onDrawableClickListener.onLeftDrawableClick(this);
                    }else if (drawableEnum ==  DrawableEnum.TOP){
                        onDrawableClickListener.onTopDrawableClick(this);
                    }else if (drawableEnum ==  DrawableEnum.RIGHT){
                        onDrawableClickListener.onRightDrawableClick(this);
                    }else if (drawableEnum ==  DrawableEnum.BOTTOM){
                        onDrawableClickListener.onBottomDrawableClick(this);
                    }

                }
                if (null  != leftDrawableClickListener && drawableEnum == DrawableEnum.LEFT){
                    leftDrawableClickListener.onDrawableClick(this);
                }
                if (null  != topDrawableClickListener && drawableEnum == DrawableEnum.TOP){
                    topDrawableClickListener.onDrawableClick(this);
                }
                if (null  != rightDrawableClickListener && drawableEnum == DrawableEnum.RIGHT){
                    rightDrawableClickListener.onDrawableClick(this);
                }
                if (null  != bottomDrawableClickListener && drawableEnum == DrawableEnum.BOTTOM){
                    bottomDrawableClickListener.onDrawableClick(this);
                }
                return true;
            }
        }
        return false;
    }

    enum DrawableEnum{
        LEFT, TOP, RIGHT, BOTTOM
    }
}
