package com.gmail.brianbridge.backendappcontrol.activity;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gmail.brianbridge.backendappcontrol.R;
import com.gmail.brianbridge.backendappcontrol.adapter.MainViewPagerAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
	public static final String TAG = MainActivity.class.getSimpleName();

	@ViewById(R.id.tabLayout)
	TabLayout tabLayout;

	@ViewById(R.id.viewPager)
	ViewPager viewPager;

	private MainViewPagerAdapter viewPagerAdapter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}
