package ke.co.appslab.mpesabuddy.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ke.co.appslab.mpesabuddy.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static ke.co.appslab.mpesabuddy.data.ApiEndpoints.BASE_URL;

public class ApiClient {
  public static Retrofit retrofit = null;

  private static OkHttpClient.Builder okHttpClient() {
    OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
    okHttpClient.connectTimeout(3, TimeUnit.MINUTES);
    okHttpClient.readTimeout(3,TimeUnit.MINUTES);
    okHttpClient.writeTimeout(3, TimeUnit.MINUTES);


    if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
      logging.setLevel(HttpLoggingInterceptor.Level.BODY);
      okHttpClient.addInterceptor(logging);
    }

    return okHttpClient;
  }



  public static Retrofit getClient() {
    Gson gson = new GsonBuilder()
        .setLenient()
        .create();
    Retrofit.Builder builder = new Retrofit.Builder();
    builder.baseUrl(BASE_URL);
    builder.addConverterFactory(GsonConverterFactory.create(gson));
    OkHttpClient.Builder okhttpBuilder = okHttpClient();
    builder.client(okhttpBuilder.build());
    retrofit = builder.build();

    return retrofit;
  }

}
