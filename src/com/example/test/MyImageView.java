package com.example.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Scroller;

public class MyImageView extends ImageView {

	Scroller mScroller;

	public MyImageView(Context context) {
		super(context);
		mScroller = new Scroller(context);
	}

	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mScroller = new Scroller(context);
	}

	public void scrollUp() {
		// ���½�����ʹ�ö�������ƫ�ƹ���, 3s�ڵ�λ
		mScroller.startScroll(mScroller.getCurrX(), mScroller.getCurrY(),
				mScroller.getCurrX(), mScroller.getCurrY() + 300, 1000);
		// �ػ�ؼ�
		invalidate();
	}

	@Override
	public void computeScroll() {
		if (mScroller.computeScrollOffset()) { // �������true����ʾ������û�н���
			// ����ƽ���Ķ���Ч�������ݵ�ǰƫ������ÿ�ι���һ��
			scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			// ��ʱͬ��Ҳ��Ҫˢ��View ������Ч�����������
			postInvalidate();
		} else { // �������false����ʾstartScroll���
			Log.i("TEST", " scoller has finished -----");
		}
	}

}
