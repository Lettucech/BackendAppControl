package com.gmail.brianbridge.backendappcontrol;

import android.app.Application;
import android.support.annotation.WorkerThread;
import android.util.Log;

import com.gmail.brianbridge.backendappcontrol.service.LocalService;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EApplication;

import java.io.IOException;

import retrofit2.Retrofit;

@EApplication
public class CustomApplication extends Application {
	public static final String TAG = CustomApplication.class.getSimpleName();

	private LocalService localService;

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(TAG, "onCreate()");
		localService = new LocalService();
		doBackground();
	}

	@Background
	void doBackground() {
		try {
			localService.getSections();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
