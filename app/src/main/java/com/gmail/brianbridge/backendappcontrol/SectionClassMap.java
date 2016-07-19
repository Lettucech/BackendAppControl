package com.gmail.brianbridge.backendappcontrol;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.gmail.brianbridge.backendappcontrol.activity.InnerActivity;
import com.gmail.brianbridge.backendappcontrol.activity.MainActivity;
import com.gmail.brianbridge.backendappcontrol.fragment.FragmentA;
import com.gmail.brianbridge.backendappcontrol.fragment.FragmentB;
import com.gmail.brianbridge.backendappcontrol.fragment.FragmentC;

import java.util.HashMap;
import java.util.Map;

public class SectionClassMap {
	public static final Map<Integer, SectionClassSet> sectionClassMap = new HashMap<>();

	static {
		bind(0, MainActivity.class, FragmentA.class);
		bind(1, MainActivity.class, FragmentB.class);
		bind(2, MainActivity.class, FragmentC.class);
		bind(3, InnerActivity.class, null);
	}

	private static void bind(int id, Class<? extends Activity> activityClass, Class<? extends Fragment> fragmentClass) {
		sectionClassMap.put(0, new SectionClassSet(MainActivity.class, FragmentA.class));
	}

	public static class SectionClassSet {
		private Class<? extends Activity> activityClass;
		private Class<? extends Fragment> fragmentClass;

		public SectionClassSet(Class<? extends Activity> activityClass, Class<? extends Fragment> fragmentClass) {
			this.activityClass = activityClass;
			this.fragmentClass = fragmentClass;
		}

		public Class<? extends Activity> getActivityClass() {
			return activityClass;
		}

		public Class<? extends Fragment> getFragmentClass() {
			return fragmentClass;
		}
	}
}
