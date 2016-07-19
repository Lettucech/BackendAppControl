package com.gmail.brianbridge.backendappcontrol.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gmail.brianbridge.backendappcontrol.CustomApplication;
import com.gmail.brianbridge.backendappcontrol.R;
import com.gmail.brianbridge.backendappcontrol.model.event.AppInitialCompletedEvent;

import org.androidannotations.annotations.EActivity;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@EActivity(R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (((CustomApplication)getApplication()).isInitCompleted()) {
			startActivity(new Intent(this, MainActivity_.class));
		} else {
			EventBus.getDefault().register(this);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

	@Subscribe
	public void onAppInitCompleted(AppInitialCompletedEvent e) {
		startActivity(new Intent(this, MainActivity_.class));
	}
}
