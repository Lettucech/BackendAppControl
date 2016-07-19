package com.gmail.brianbridge.backendappcontrol.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gmail.brianbridge.backendappcontrol.R;
import com.gmail.brianbridge.backendappcontrol.adapter.MainViewPagerAdapter;
import com.gmail.brianbridge.backendappcontrol.fragment.FragmentA_;
import com.gmail.brianbridge.backendappcontrol.fragment.FragmentB_;
import com.gmail.brianbridge.backendappcontrol.fragment.FragmentC_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Arrays;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
	public static final String TAG = MainActivity.class.getSimpleName();
	public static final int FLAG_FRAGMENT_A = 1000;
	public static final int FLAG_FRAGMENT_B = 1001;
	public static final int FLAG_FRAGMENT_C = 1002;

	@ViewById(R.id.tabLayout)
	TabLayout tabLayout;

	@ViewById(R.id.viewPager)
	ViewPager viewPager;

	private MainViewPagerAdapter viewPagerAdapter;

	@AfterViews
	void afterViews() {
		viewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),
				Arrays.asList(
						FragmentA_.builder().build(),
						FragmentB_.builder().build(),
						FragmentC_.builder().build()
				),
				new String[] {
						"Setting",
						"Mapping",
						"Next Page"
				});
		viewPager.setAdapter(viewPagerAdapter);
		tabLayout.setupWithViewPager(viewPager);
	}
}
