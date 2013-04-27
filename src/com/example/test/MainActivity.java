package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
	private LinearLayout loginInfo;
	private LinearLayout lbanner;
	private LinearLayout lbottom;
	private AlphaAnimation fadeOut;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// main.xml中的ImageView
		registerImage = (ImageView) findViewById(R.id.register);
		loginImage = (ImageView) findViewById(R.id.login);
		bannerImage = (ImageView) findViewById(R.id.big_c);
		loginInfo = (LinearLayout)findViewById(R.id.login_info);
		lbanner = (LinearLayout)findViewById(R.id.banner);
		lbottom = (LinearLayout)findViewById(R.id.bottom);

		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

		width = wm.getDefaultDisplay().getWidth();
		height = wm.getDefaultDisplay().getHeight();

		// 加载动画		


		fadeOut = new AlphaAnimation(0.0f, 1.0f);
		fadeOut.setStartOffset(400);
		fadeOut.setDuration(600);
//		scrollUp.setAnimationListener(new AnimationListener() {
//			
//			public void onAnimationStart(Animation animation) {
//				
//			}
//			
//			public void onAnimationRepeat(Animation animation) {
//				
//			}
//			
//			public void onAnimationEnd(Animation animation) {
////			    int left = loginImage.getLeft();
////			    int top = loginImage.getTop()-300;
////			    int width = loginImage.getWidth();
////			    int height = loginImage.getHeight();
////			    loginImage.clearAnimation(); //清除动画
////			    
////			    loginImage.layout(left, top, left + width, top + height);//重新设置view的大小
//			    //loginImage.setClickable(false);
//			}
//		});
		
		loginImage.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
			    int infoTop = loginInfo.getTop();
			    int bannerBottom = lbanner.getBottom();			    
			    int distance = bannerBottom - infoTop;
			    
			    int infoBottom = loginInfo.getBottom();
			    int lbottomTop = lbottom.getTop();			    
			    int distance2 = infoBottom - lbottomTop;
			    
			    
				scrollUp = new TranslateAnimation(0,0,0,-distance);
				scrollUp.setDuration(600);
				scrollUp.setFillAfter(true);
				
				scrollDown = new TranslateAnimation(0,0,0,distance2);
				scrollDown.setDuration(600);
				//scrollUp.setFillAfter(true);
				scrollDown.setFillAfter(true);
			    
				lbanner.startAnimation(scrollUp);
				lbottom.startAnimation(scrollDown);
			}
		});

	}

}
