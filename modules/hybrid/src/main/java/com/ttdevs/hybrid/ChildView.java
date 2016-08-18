/*
 * Created by ttdevs at 16-8-12 下午6:26.
 * E-mail:ttdevs@gmail.com
 * https://github.com/ttdevs
 * Copyright (c) 2016 ttdevs
 */

package com.ttdevs.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class ChildView extends ScrollView implements IScrollStatus {
    public ChildView(Context context) {
        this(context, null);
    }

    public ChildView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChildView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isScrollTop() {
        return getScrollY() == 0;
    }

    @Override
    public boolean isScrollBottom() {
        View childView = getChildAt(0);
        if (null == childView) {
            return false;
        }
        int currentScroll = getHeight() + getScrollY();
        int distance = childView.getMeasuredHeight() - currentScroll;
        return distance < DISTANCE;
    }
}
