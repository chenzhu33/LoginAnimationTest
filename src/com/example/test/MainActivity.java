package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	private final static int ANIMATION_DURATION = 500;
	
	private ImageView registerButton;
	private ImageView loginButton;
	private LinearLayout loginLayoutWhole;
	private LinearLayout registerLayoutWhole;
	private LinearLayout loginLayoutInputBox;
	private LinearLayout registerLayoutInputBox;
	private LinearLayout layoutLogin;
	private LinearLayout layoutRegister;
	private LinearLayout layoutFoot;
	private TextView spaceBannerLogin;
	private TextView spaceFootLogin;
	private TextView spaceBannerRegister;
	private TextView spaceFootRegister;

	private int distanceLogin;
	private int distance2Login;
	private int distanceRegister;
	private int distance2Register;

	private TranslateAnimation scrollUp;
	private TranslateAnimation scrollDown;
	
	private LinearLayout mainBackground;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);

		registerButton = (ImageView) findViewById(R.id.register);
		loginButton = (ImageView) findViewById(R.id.login);

		loginLayoutInputBox = (LinearLayout) findViewById(R.id.login_info);
		registerLayoutInputBox = (LinearLayout) findViewById(R.id.register_info);
		loginLayoutWhole = (LinearLayout) findViewById(R.id.login_whole);
		registerLayoutWhole = (LinearLayout) findViewById(R.id.register_whole);

		layoutLogin = (LinearLayout) findViewById(R.id.banner);
		layoutRegister = (LinearLayout) findViewById(R.id.bottom);
		layoutFoot = (LinearLayout) findViewById(R.id.bottom2);

		spaceBannerLogin = (TextView) findViewById(R.id.space1_l);
		spaceFootLogin = (TextView) findViewById(R.id.space2_l);
		spaceBannerRegister = (TextView) findViewById(R.id.space1_r);
		spaceFootRegister = (TextView) findViewById(R.id.space2_r);

		mainBackground = (LinearLayout)findViewById(R.id.main_bg);
		
		loginButton.setOnLongClickListener(new OnLongClickListener() {
			
			public boolean onLongClick(View v) {
				registerLayoutWhole.setVisibility(View.GONE);
				loginLayoutWhole.setVisibility(View.GONE);
				loginLayoutInputBox.setVisibility(View.GONE);
				registerLayoutInputBox.setVisibility(View.GONE);
				mainBackground.setVisibility(View.VISIBLE);
				
				scrollUp = new TranslateAnimation(0, 0, 0, -800);
				scrollUp.setDuration(ANIMATION_DURATION);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, 0, 800);
				scrollDown.setDuration(ANIMATION_DURATION);
				scrollDown.setFillAfter(true);

				layoutLogin.startAnimation(scrollUp);
				layoutRegister.startAnimation(scrollDown);
				layoutFoot.startAnimation(scrollDown);

				loginButton.setClickable(false);
				registerButton.setClickable(false);
						
				return true;
			}
		});
		
		loginButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				registerLayoutWhole.setVisibility(View.INVISIBLE);
				loginLayoutWhole.setVisibility(View.VISIBLE);

				int infoTop = loginLayoutInputBox.getTop();
				int bannerBottom = layoutLogin.getBottom();
				distanceLogin = bannerBottom - infoTop;

				int infoBottom = loginLayoutInputBox.getBottom();
				int lbottomTop = layoutRegister.getTop();
				distance2Login = infoBottom - lbottomTop;

				scrollUp = new TranslateAnimation(0, 0, 0, -distanceLogin);
				scrollUp.setDuration(ANIMATION_DURATION);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, 0, distance2Login);
				scrollDown.setDuration(ANIMATION_DURATION);
				scrollDown.setFillAfter(true);

				layoutLogin.startAnimation(scrollUp);
				layoutRegister.startAnimation(scrollDown);
				layoutFoot.startAnimation(scrollDown);

				loginButton.setClickable(false);
				registerButton.setClickable(false);
			}
		});

		registerButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				registerLayoutWhole.setVisibility(View.VISIBLE);
				loginLayoutWhole.setVisibility(View.INVISIBLE);

				int infoTop = registerLayoutInputBox.getTop();
				int lbottomBottom = layoutRegister.getBottom();
				distanceRegister = lbottomBottom - infoTop;

				int infoBottom = registerLayoutInputBox.getBottom();
				int lbottom2Top = layoutFoot.getTop();
				distance2Register = infoBottom - lbottom2Top;
				if (distance2Register < 0)
					distance2Register = 0;

				scrollUp = new TranslateAnimation(0, 0, 0, -distanceRegister);
				scrollUp.setDuration(ANIMATION_DURATION);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, 0, distance2Register);
				scrollDown.setDuration(ANIMATION_DURATION);
				scrollDown.setFillAfter(true);

				layoutLogin.startAnimation(scrollUp);
				layoutRegister.startAnimation(scrollUp);
				layoutFoot.startAnimation(scrollDown);

				loginButton.setClickable(false);
				registerButton.setClickable(false);
			}
		});

		spaceBannerLogin.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				scrollUp = new TranslateAnimation(0, 0, -distanceLogin, 0);
				scrollUp.setDuration(ANIMATION_DURATION);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, distance2Login, 0);
				scrollDown.setDuration(ANIMATION_DURATION);
				scrollDown.setFillAfter(true);

				layoutLogin.startAnimation(scrollUp);
				layoutRegister.startAnimation(scrollDown);
				layoutFoot.startAnimation(scrollDown);

				scrollDown.setAnimationListener(new AnimationListener() {

					public void onAnimationStart(Animation animation) {

					}

					public void onAnimationRepeat(Animation animation) {

					}

					public void onAnimationEnd(Animation animation) {
						loginLayoutWhole.setVisibility(View.INVISIBLE);
						loginButton.setClickable(true);
						registerButton.setClickable(true);
					}
				});
			}
		});

		spaceFootLogin.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				scrollUp = new TranslateAnimation(0, 0, -distanceLogin, 0);
				scrollUp.setDuration(ANIMATION_DURATION);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, distance2Login, 0);
				scrollDown.setDuration(ANIMATION_DURATION);
				scrollDown.setFillAfter(true);

				layoutLogin.startAnimation(scrollUp);
				layoutRegister.startAnimation(scrollDown);
				layoutFoot.startAnimation(scrollDown);

				scrollDown.setAnimationListener(new AnimationListener() {

					public void onAnimationStart(Animation animation) {

					}

					public void onAnimationRepeat(Animation animation) {

					}

					public void onAnimationEnd(Animation animation) {
						loginLayoutWhole.setVisibility(View.INVISIBLE);
						loginButton.setClickable(true);
						registerButton.setClickable(true);
					}
				});
			}
		});

		spaceFootRegister.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				scrollUp = new TranslateAnimation(0, 0, -distanceRegister, 0);
				scrollUp.setDuration(ANIMATION_DURATION);
				scrollUp.setFillAfter(true);
				scrollDown = new TranslateAnimation(0, 0, distance2Register, 0);
				scrollDown.setDuration(ANIMATION_DURATION);
				scrollDown.setFillAfter(true);
				layoutLogin.startAnimation(scrollUp);
				layoutRegister.startAnimation(scrollUp);
				layoutFoot.startAnimation(scrollDown);

				scrollDown.setAnimationListener(new AnimationListener() {

					public void onAnimationStart(Animation animation) {

					}

					public void onAnimationRepeat(Animation animation) {

					}

					public void onAnimationEnd(Animation animation) {
						registerLayoutWhole.setVisibility(View.INVISIBLE);
						loginButton.setClickable(true);
						registerButton.setClickable(true);
					}
				});
			}
		});

		spaceBannerRegister.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				scrollUp = new TranslateAnimation(0, 0, -distanceRegister, 0);
				scrollUp.setDuration(ANIMATION_DURATION);
				scrollUp.setFillAfter(true);

				scrollDown = new TranslateAnimation(0, 0, distance2Register, 0);
				scrollDown.setDuration(ANIMATION_DURATION);
				scrollDown.setFillAfter(true);

				layoutLogin.startAnimation(scrollUp);
				layoutRegister.startAnimation(scrollUp);
				layoutFoot.startAnimation(scrollDown);

				scrollDown.setAnimationListener(new AnimationListener() {

					public void onAnimationStart(Animation animation) {

					}

					public void onAnimationRepeat(Animation animation) {

					}

					public void onAnimationEnd(Animation animation) {
						registerLayoutWhole.setVisibility(View.INVISIBLE);
						loginButton.setClickable(true);
						registerButton.setClickable(true);
					}
				});
			}
		});
	}

}
