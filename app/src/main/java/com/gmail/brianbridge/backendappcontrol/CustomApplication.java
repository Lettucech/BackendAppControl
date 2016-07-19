package com.gmail.brianbridge.backendappcontrol;

import android.app.Application;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.brianbridge.backendappcontrol.model.AppSectionData;
import com.gmail.brianbridge.backendappcontrol.model.event.AppInitialCompletedEvent;
import com.gmail.brianbridge.backendappcontrol.service.LocalService;
import com.gmail.brianbridge.backendappcontrol.util.PreferencesUtil;
import com.gmail.brianbridge.backendappcontrol.util.PreferencesUtil_;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.androidannotations.annotations.sharedpreferences.SharedPref;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import retrofit2.Response;

@EApplication
public class CustomApplication extends Application {
	public static final String TAG = CustomApplication.class.getSimpleName();

	@Pref
	PreferencesUtil_ preferencesUtil;

	private AppSectionData appSectionData;
	private boolean initCompleted = false;

	@Override
	public void onCreate() {
		super.onCreate();
		EventBus.builder().sendNoSubscriberEvent(false).installDefaultEventBus();
		getSections();
	}

	@Background
	void getSections() {
		try {
			Response<AppSectionData> response = new LocalService().getSections();

			// TODO use your better solution to store the preferences
			if (response.isSuccessful() && response.body() != null) {
				preferencesUtil.appSectionDataJson().put(new ObjectMapper().writeValueAsString(response.body()));
			} else {
				loadDefaultAppSectionData();
			}
		} catch (IOException e) {
			Log.e(TAG, e.toString());
			loadDefaultAppSectionData();
		}

		initCompleted = true;
		EventBus.getDefault().post(new AppInitialCompletedEvent());
	}

	public AppSectionData getAppSectionData() {
		return appSectionData;
	}

	public boolean isInitCompleted() {
		return initCompleted;
	}

	private void loadDefaultAppSectionData(){
		if (preferencesUtil.appSectionDataJson().get().isEmpty()) {
			InputStream in = getResources().openRawResource(R.raw.default_app_section_map);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			StringBuilder sb = new StringBuilder();
			String line;
			try {
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
			} catch (IOException e) {
				Log.e(TAG, e.toString());
			}
			preferencesUtil.appSectionDataJson().put(sb.toString());
		}

		try {
			Log.d(TAG, preferencesUtil.appSectionDataJson().get());
			appSectionData = new ObjectMapper().readValue(preferencesUtil.appSectionDataJson().get(), AppSectionData.class);
		} catch (IOException e) {
			Log.e(TAG, e.toString());
		}
	}

}
