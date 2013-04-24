package com.example.test;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class MyAnimation extends Animation {
	int mCenterX, mCenterY;

	public MyAnimation() {
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		// 通过Matrix.setScale函数来缩放，该函数的两个参数代表X、Y轴缩放因子，由于interpolatedTime是从0到1变化所在这里实现的效果就是控件从最小逐渐变化到最大。
		Matrix matrix = t.getMatrix();
		matrix.setScale(interpolatedTime, interpolatedTime);
		// Matrix 可以实现各种复杂的变换

		// preTranslate函数是在缩放前移动而postTranslate是在缩放完成后移动。
		matrix.preTranslate(-mCenterX, -mCenterY);
		matrix.postTranslate(mCenterX, mCenterY);
	}

	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		super.initialize(width, height, parentWidth, parentHeight);
		// 初始化中间坐标
		mCenterX = width / 2;
		mCenterY = height / 2;

		// 设置变换持续的时间2500毫秒，然后设置Interpolator为LinearInterpolator并设置FillAfter为true这样可以在动画结束的时候保持动画的完整性。
		setDuration(2000);
		setFillAfter(true);
		setInterpolator(new LinearInterpolator());
	}
}