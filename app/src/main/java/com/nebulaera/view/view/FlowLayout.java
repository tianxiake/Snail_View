package com.nebulaera.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import static android.R.attr.width;

/**
 * @author Barry 2017/11/1
 */

public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //当前控件测量的宽度
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);

        //当前控件测量的高度
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        int lineWidth = 0;
        int lineHeight = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            //测量子view
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            int childMeasureWidth = childAt.getMeasuredWidth();
            int childMeasureHeight = childAt.getMeasuredHeight();
            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            int leftMargin = layoutParams.leftMargin;
            int rightMargin = layoutParams.rightMargin;
            int topMargin = layoutParams.topMargin;
            int bottomMargin = layoutParams.bottomMargin;
            lineWidth = childMeasureWidth + leftMargin + rightMargin;
            if (lineWidth > measureWidth) {

            }else{

            }


        }

        setMeasuredDimension(measureWidth, measureHeightMode == MeasureSpec.EXACTLY ? measureHeight : 0);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int maxWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            int leftMargin = layoutParams.leftMargin;
            int rightMargin = layoutParams.rightMargin;
            int left = leftMargin + measuredWidth * i
            maxWidth += leftMargin + rightMargin + measuredWidth;
            if (maxWidth <= width) {
//                childAt.layout();
            } else {
            }
        }


    }

    //以下三组方法是为了获取XML中配置的layout_marginXXX属性
    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }
}
