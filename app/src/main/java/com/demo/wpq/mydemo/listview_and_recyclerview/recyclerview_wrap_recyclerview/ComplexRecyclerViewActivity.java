package com.demo.wpq.mydemo.listview_and_recyclerview.recyclerview_wrap_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.demo.wpq.mydemo.R;
import com.demo.wpq.mydemo.base.BaseAppCompatActivity;
import com.demo.wpq.mydemo.constant.Constants;
import com.demo.wpq.mydemo.widget.TabLayoutFragmentPageAdapter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author wpq
 * @version 1.0
 */
public class ComplexRecyclerViewActivity extends BaseAppCompatActivity {

    @BindView(R.id.tabLayout)
    SlidingTabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    // intent data
    private String title;

    private String[] mTitles = {"Fragment0", "Fragment1", "Fragment2"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    public static Intent newIntent(Context context, String title) {
        Intent intent = new Intent(context, ComplexRecyclerViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TITLE, title);
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    public void getIntentExtras(Bundle bundle) {
        title = bundle.getString(Constants.TITLE);
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.activity_complex_recyclerview;
    }

    @Override
    public String getToolBarTitle() {
        return title;
    }

    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        for (int i = 0; i < 3; i++) {
            mFragments.add(new ComplexRecyclerViewFragment());
        }
        mViewPager.setAdapter(new TabLayoutFragmentPageAdapter(getSupportFragmentManager(), mTitles, mFragments));
        mTabLayout.setViewPager(mViewPager, mTitles, this, mFragments);
        mViewPager.setCurrentItem(0);
    }

}
