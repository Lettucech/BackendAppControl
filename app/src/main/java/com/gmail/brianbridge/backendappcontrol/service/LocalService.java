package com.gmail.brianbridge.backendappcontrol.service;

import android.util.Log;

import com.gmail.brianbridge.backendappcontrol.model.AppSectionData;
import com.gmail.brianbridge.backendappcontrol.rs.Endpoint;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class LocalService {
	public static final String TAG = LocalService.class.getSimpleName();
	public static final String BASE_URL = "http://192.168.0.110/";

	private Retrofit retrofit;
	private Endpoint endpoint;

	public LocalService() {
		OkHttpClient client = new OkHttpClient.Builder()
				.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
				.build();

		retrofit = new Retrofit.Builder()
				.client(client)
				.addConverterFactory(JacksonConverterFactory.create())
				.baseUrl(BASE_URL)
				.build();
		endpoint = retrofit.create(Endpoint.class);
	}

	public Response<AppSectionData> getSections() throws IOException {
		Call<AppSectionData> call = endpoint.getSections();
		return call.execute();
	}
}
