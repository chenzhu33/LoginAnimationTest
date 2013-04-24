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
		// ͨ��Matrix.setScale���������ţ��ú�����������������X��Y���������ӣ�����interpolatedTime�Ǵ�0��1�仯��������ʵ�ֵ�Ч�����ǿؼ�����С�𽥱仯�����
		Matrix matrix = t.getMatrix();
		matrix.setScale(interpolatedTime, interpolatedTime);
		// Matrix ����ʵ�ָ��ָ��ӵı任

		// preTranslate������������ǰ�ƶ���postTranslate����������ɺ��ƶ���
		matrix.preTranslate(-mCenterX, -mCenterY);
		matrix.postTranslate(mCenterX, mCenterY);
	}

	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		super.initialize(width, height, parentWidth, parentHeight);
		// ��ʼ���м�����
		mCenterX = width / 2;
		mCenterY = height / 2;

		// ���ñ任������ʱ��2500���룬Ȼ������InterpolatorΪLinearInterpolator������FillAfterΪtrue���������ڶ���������ʱ�򱣳ֶ����������ԡ�
		setDuration(2000);
		setFillAfter(true);
		setInterpolator(new LinearInterpolator());
	}
}