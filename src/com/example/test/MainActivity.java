package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ImageView registerImage;
	private ImageView loginImage;
	private TranslateAnimation scrollUp;
	private TranslateAnimation scrollDown;
	private LinearLayout loginWhole;
	private LinearLayout registerWhole;
	private LinearLayout loginInfo;
	private LinearLayout registerInfo;
	private LinearLayout lbanner;
	private LinearLayout lbottom;
	private LinearLayout lbottom2;

	private TextView space1Login;
	private TextView space2Login;

	protected int distanceRegister;
	protected int distance2Register;
	protected int distanceLogin;
	protected int distance2Login;
	private TextView space1Register;
	private TextView space2Register;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);

		registerImage = (ImageView) findViewById(R.id.register);
		loginImage = (ImageView) findViewById(R.id.login);

		loginInfo = (LinearLayout) findViewById(R.id.login_info);
		registerInfo = (LinearLayout) findViewById(R.id.register_info);
		loginWhole = (LinearLayout) findViewById(R.id.login_whole);
		registerWhole = (LinearLayout) findViewById(R.id.register_whole);

		lbanner = (LinearLayout) findViewById(R.id.banner);
		lbottom = (LinearLayout) findViewById(R.id.bottom);
		lbottom2 = (LinearLayout) findViewById(R.id.bottom2);

		space1Login = (TextView) findViewById(R.id.space1_l);
		space2Login = (TextView) findViewById(R.id.space2_l);
		space1Register = (TextView) findViewById(R.id.space1_r);
		space2Register = (TextView) findViewById(R.id.space2_r);

		loginImage.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				registerWhole.setVisibility(View.INVISIBLE);
				loginWhole.setVisibility(View.VISIBLE);

				int infoTop = loginInfo.getTop();
				int bannerBottom = lbanner.getBottom();
				distanceLogin = bannerBottom - infoTop;

				int infoBottom = loginInfo.getBottom();
				int lbottomTop = lbottom.getTop();
				distance2Login = infoBottom - lbottomTop;

				scrollUp = new TranslateAnimation(0, 0, 0, -distanceLogin);
				scrollUp.setDuration(600);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, 0, distance2Login);
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
				registerWhole.setVisibility(View.VISIBLE);
				loginWhole.setVisibility(View.INVISIBLE);

				int infoTop = registerInfo.getTop();
				int lbottomBottom = lbottom.getBottom();
				distanceRegister = lbottomBottom - infoTop;

				int infoBottom = registerInfo.getBottom();
				int lbottom2Top = lbottom2.getTop();
				distance2Register = infoBottom - lbottom2Top;
				if (distance2Register < 0)
					distance2Register = 0;

				scrollUp = new TranslateAnimation(0, 0, 0, -distanceRegister);
				scrollUp.setDuration(600);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, 0, distance2Register);
				scrollDown.setDuration(600);
				scrollDown.setFillAfter(true);

				lbanner.startAnimation(scrollUp);
				lbottom.startAnimation(scrollUp);
				lbottom2.startAnimation(scrollDown);

				loginImage.setClickable(false);
				registerImage.setClickable(false);
			}
		});

		space1Login.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				scrollUp = new TranslateAnimation(0, 0, -distanceLogin, 0);
				scrollUp.setDuration(600);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, distance2Login, 0);
				scrollDown.setDuration(600);
				scrollDown.setFillAfter(true);

				lbanner.startAnimation(scrollUp);
				lbottom.startAnimation(scrollDown);
				lbottom2.startAnimation(scrollDown);

				scrollDown.setAnimationListener(new AnimationListener() {

					public void onAnimationStart(Animation animation) {

					}

					public void onAnimationRepeat(Animation animation) {

					}

					public void onAnimationEnd(Animation animation) {
						loginWhole.setVisibility(View.INVISIBLE);
						loginImage.setClickable(true);
						registerImage.setClickable(true);
					}
				});
			}
		});

		space2Login.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				scrollUp = new TranslateAnimation(0, 0, -distanceLogin, 0);
				scrollUp.setDuration(600);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, distance2Login, 0);
				scrollDown.setDuration(600);
				scrollDown.setFillAfter(true);

				lbanner.startAnimation(scrollUp);
				lbottom.startAnimation(scrollDown);
				lbottom2.startAnimation(scrollDown);

				scrollDown.setAnimationListener(new AnimationListener() {

					public void onAnimationStart(Animation animation) {

					}

					public void onAnimationRepeat(Animation animation) {

					}

					public void onAnimationEnd(Animation animation) {
						loginWhole.setVisibility(View.INVISIBLE);
						loginImage.setClickable(true);
						registerImage.setClickable(true);
					}
				});
			}
		});

		space2Register.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				scrollUp = new TranslateAnimation(0, 0, -distanceRegister, 0);
				scrollUp.setDuration(600);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, distance2Register, 0);
				scrollDown.setDuration(600);
				scrollDown.setFillAfter(true);

				lbanner.startAnimation(scrollUp);
				lbottom.startAnimation(scrollUp);
				lbottom2.startAnimation(scrollDown);

				scrollDown.setAnimationListener(new AnimationListener() {

					public void onAnimationStart(Animation animation) {

					}

					public void onAnimationRepeat(Animation animation) {

					}

					public void onAnimationEnd(Animation animation) {
						registerWhole.setVisibility(View.INVISIBLE);
						loginImage.setClickable(true);
						registerImage.setClickable(true);
					}
				});
			}
		});

		space1Register.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				scrollUp = new TranslateAnimation(0, 0, -distanceRegister, 0);
				scrollUp.setDuration(600);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, distance2Register, 0);
				scrollDown.setDuration(600);
				scrollDown.setFillAfter(true);

				lbanner.startAnimation(scrollUp);
				lbottom.startAnimation(scrollUp);
				lbottom2.startAnimation(scrollDown);

				scrollDown.setAnimationListener(new AnimationListener() {

					public void onAnimationStart(Animation animation) {

					}

					public void onAnimationRepeat(Animation animation) {

					}

					public void onAnimationEnd(Animation animation) {
						registerWhole.setVisibility(View.INVISIBLE);
						loginImage.setClickable(true);
						registerImage.setClickable(true);
					}
				});
			}
		});
	}

}
