package com.gmail.brianbridge.backendappcontrol;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.gmail.brianbridge.backendappcontrol.activity.InnerActivity;
import com.gmail.brianbridge.backendappcontrol.activity.MainActivity;
import com.gmail.brianbridge.backendappcontrol.fragment.FragmentA;
import com.gmail.brianbridge.backendappcontrol.fragment.FragmentB;
import com.gmail.brianbridge.backendappcontrol.fragment.FragmentC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionClassMap {
	public static final Map<Integer, SectionClassSet> sectionClassMap = new HashMap<>();

	static {
		bind(0, MainActivity.class, MainActivity.FLAG_FRAGMENT_A);
		bind(1, MainActivity.class, MainActivity.FLAG_FRAGMENT_B);
		bind(2, MainActivity.class, MainActivity.FLAG_FRAGMENT_C);
		bind(3, InnerActivity.class);
	}

	private static void bind(int id, Class<? extends Activity> activityClass) {
		sectionClassMap.put(id, new SectionClassSet(activityClass));
	}

	private static void bind(int id, Class<? extends Activity> activityClass, int... flags) {
		sectionClassMap.put(id, new SectionClassSet(activityClass, flags));
	}

	public static Map<Integer, SectionClassSet> getSectionClassMap() {
		return sectionClassMap;
	}

	public static class SectionClassSet {
		private Class<? extends Activity> activityClass;
		private int[] flags;

		public SectionClassSet(Class<? extends Activity> activityClass) {
			this.activityClass = activityClass;
		}

		public SectionClassSet(Class<? extends Activity> activityClass, int... flags) {
			this.activityClass = activityClass;
			this.flags = flags;
		}

		public Class<? extends Activity> getActivityClass() {
			return activityClass;
		}

		public int[] getFlags() {
			return flags;
		}
	}
}
