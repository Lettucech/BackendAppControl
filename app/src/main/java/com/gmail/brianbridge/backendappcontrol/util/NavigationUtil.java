package com.gmail.brianbridge.backendappcontrol.util;

import com.gmail.brianbridge.backendappcontrol.activity.InnerActivity;
import com.gmail.brianbridge.backendappcontrol.activity.MainActivity;

import java.util.HashMap;
import java.util.Map;

public class NavigationUtil {
	public static final Map<Integer, Class> sectionClassMap = new HashMap<>();

	static {
		sectionClassMap.put(0, MainActivity.class);
		sectionClassMap.put(1, MainActivity.class);
		sectionClassMap.put(2, MainActivity.class);
		sectionClassMap.put(1, InnerActivity.class);
	}
}
