package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView registerImage;
	private ImageView loginImage;
	private ImageView bannerImage;

	private TranslateAnimation scrollUp;
	private TranslateAnimation scrollDown;
	private Animation scrollUp2;
	private TranslateAnimation showtime;
	private int width;
	private int height;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// main.xml中的ImageView
		registerImage = (ImageView) findViewById(R.id.register);
		loginImage = (ImageView) findViewById(R.id.login);
		bannerImage = (ImageView) findViewById(R.id.big_c);

		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

		width = wm.getDefaultDisplay().getWidth();
		height = wm.getDefaultDisplay().getHeight();

		// 加载动画

		// scrollUp = AnimationUtils.loadAnimation(this,
		// R.anim.slide_out_to_top);
		// scrollDown = AnimationUtils.loadAnimation(this,
		// R.anim.slide_out_to_bottom);
		scrollUp2 = new TranslateAnimation(0,0,0,-300);
		scrollUp2.setDuration(1000);
		scrollUp2.setFillAfter(true);
		
		scrollUp = new TranslateAnimation(0,0,0,-300);
		scrollUp.setDuration(1000);
		scrollDown = new TranslateAnimation(0,0,0,400);
		scrollDown.setDuration(1000);
		scrollUp.setFillAfter(true);
		scrollDown.setFillAfter(true);

		scrollUp.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			public void onAnimationEnd(Animation animation) {
			    int left = loginImage.getLeft();
			    int top = loginImage.getTop()-300;
			    int width = loginImage.getWidth();
			    int height = loginImage.getHeight();
			    loginImage.clearAnimation(); //清除动画
			    loginImage.layout(left, top, left + width, top + height);//重新设置view的大小
			    loginImage.setClickable(false);
			}
		});
		
		loginImage.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				int[] location = new int[2];
				loginImage.getLocationOnScreen(location);// 获取在整个屏幕内的绝对坐标
				loginImage.startAnimation(scrollUp);
				
				registerImage.startAnimation(scrollDown);
				bannerImage.startAnimation(scrollUp2);
			}
		});

	}
}
