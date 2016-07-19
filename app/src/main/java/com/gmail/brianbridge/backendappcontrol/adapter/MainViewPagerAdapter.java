package com.gmail.brianbridge.backendappcontrol.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> fragments = new ArrayList<>();
	private String[] title;

	public MainViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] title) {
		super(fm);
		this.fragments = fragments;
		this.title = title;
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return title[position];
	}
}
