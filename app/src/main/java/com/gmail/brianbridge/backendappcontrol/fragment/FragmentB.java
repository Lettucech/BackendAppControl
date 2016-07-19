package com.gmail.brianbridge.backendappcontrol.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TextView;

import com.gmail.brianbridge.backendappcontrol.CustomApplication;
import com.gmail.brianbridge.backendappcontrol.R;
import com.gmail.brianbridge.backendappcontrol.util.PreferencesUtil;
import com.gmail.brianbridge.backendappcontrol.util.PreferencesUtil_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

@EFragment(R.layout.fragment_b)
public class FragmentB extends Fragment {
	public static final String TAG = FragmentB.class.getSimpleName();

	@ViewById(R.id.textView)
	TextView textView;

	@Pref
	PreferencesUtil_ preferencesUtil;

	private Activity activity;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		activity = getActivity();
	}

	@AfterViews
	void afterViews() {
		textView.setText(preferencesUtil.appSectionDataJson().get());
	}
}
