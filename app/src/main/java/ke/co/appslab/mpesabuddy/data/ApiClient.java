package ke.co.appslab.mpesabuddy.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
  private Retrofit retrofit = null;


  public Retrofit getClient() {
    Gson gson = new GsonBuilder()
        .setLenient()
        .create();
    Retrofit.Builder builder = new Retrofit.Builder();
    //builder.baseUrl(BASE_URL);
    builder.addConverterFactory(GsonConverterFactory.create(gson));
    retrofit = builder.build();

    return retrofit;
  }

}
