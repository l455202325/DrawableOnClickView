# DrawableOnClickView
DrawableOnClickView为了Textview设置了Drawable而没有办法设置Drawable的点击事件而生，使用方法灵活方便

在xml文件中直接使用即可
<br>
![](https://github.com/l455202325/DrawableOnClickView/blob/master/imgs/xml.png)
        
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

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.l455202325:DrawableOnClickView:v1.0.2'
	}

