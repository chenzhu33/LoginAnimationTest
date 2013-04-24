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
		// 更新结束后，使用动画控制偏移过程, 3s内到位
		mScroller.startScroll(mScroller.getCurrX(), mScroller.getCurrY(),
				mScroller.getCurrX(), mScroller.getCurrY() + 300, 1000);
		// 重绘控件
		invalidate();
	}

	@Override
	public void computeScroll() {
		if (mScroller.computeScrollOffset()) { // 如果返回true，表示动画还没有结束
			// 产生平滑的动画效果，根据当前偏移量，每次滚动一点
			scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			// 此时同样也需要刷新View ，否则效果可能有误差
			postInvalidate();
		} else { // 如果返回false，表示startScroll完成
			Log.i("TEST", " scoller has finished -----");
		}
	}

}
