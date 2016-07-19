package com.gmail.brianbridge.backendappcontrol.rs;

import com.gmail.brianbridge.backendappcontrol.model.AppSectionData;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoint {
	@GET("sections")
	Call<AppSectionData> getSections();
}
