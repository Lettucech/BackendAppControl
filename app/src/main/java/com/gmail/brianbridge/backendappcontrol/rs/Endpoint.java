package com.gmail.brianbridge.backendappcontrol.rs;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoint {
	@GET("sections")
	Call<ResponseBody> getSections();
}
