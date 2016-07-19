package com.gmail.brianbridge.backendappcontrol.util;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface PreferencesUtil {
	@DefaultString("")
	String appSectionDataJson();
}
