# DrawableOnClickView
DrawableOnClickView为了Textview设置了Drawable而没有办法设置Drawable的点击事件而生，使用方法灵活方便

在xml文件中直接使用即可
`
<com.zixing.drawableoncliickview.DrawableClickView
        android:id="@+id/drawableTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="我是中间的文本"
        android:clickable="true"
        android:layout_centerInParent="true"
        android:drawableBottom="@mipmap/ic_launcher"
        android:drawableTop="@mipmap/ic_launcher"
        android:drawableLeft="@mipmap/ic_launcher"
        android:drawableRight="@mipmap/ic_launcher"
        android:gravity="center"
        android:textSize="20sp"/>
        `
        
###这块记得设置  android:clickable="true"

再看看Activity中如何使用

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
