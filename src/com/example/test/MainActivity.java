package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private ImageView registerImage;
	private ImageView loginImage;
	private TranslateAnimation scrollUp;
	private TranslateAnimation scrollDown;
	private LinearLayout loginInfo;
	private LinearLayout lbanner;
	private LinearLayout lbottom;
	private LinearLayout lbottom2;
	
	private AlphaAnimation fadeOut;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registerImage = (ImageView) findViewById(R.id.register);
		loginImage = (ImageView) findViewById(R.id.login);
		loginInfo = (LinearLayout)findViewById(R.id.login_info);
		lbanner = (LinearLayout)findViewById(R.id.banner);
		lbottom = (LinearLayout)findViewById(R.id.bottom);
		lbottom2 = (LinearLayout)findViewById(R.id.bottom2);
		fadeOut = new AlphaAnimation(0.0f, 1.0f);
		fadeOut.setStartOffset(400);
		fadeOut.setDuration(600);
		
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
				scrollDown.setFillAfter(true);
			    
				lbanner.startAnimation(scrollUp);
				lbottom.startAnimation(scrollDown);
				lbottom2.startAnimation(scrollDown);
				
				loginImage.setClickable(false);
				registerImage.setClickable(false);
			}
		});
		
		registerImage.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
			    int infoTop = loginInfo.getTop();
			    int lbottomBottom = lbottom.getBottom();			    
			    int distance = lbottomBottom - infoTop;
			    
			    int infoBottom = loginInfo.getBottom();
			    int lbottom2Top = lbottom2.getTop();			    
			    int distance2 = infoBottom - lbottom2Top;
			    if(distance2<0)
			    	distance2=0;
			    
				scrollUp = new TranslateAnimation(0,0,0,-distance);
				scrollUp.setDuration(600);
				scrollUp.setFillAfter(true);
				
				scrollDown = new TranslateAnimation(0,0,0,distance2);
				scrollDown.setDuration(600);
				scrollDown.setFillAfter(true);
			    
				lbanner.startAnimation(scrollUp);
				lbottom.startAnimation(scrollUp);
				lbottom2.startAnimation(scrollDown);
				
				loginImage.setClickable(false);
				registerImage.setClickable(false);
			}
		});

	}

}
