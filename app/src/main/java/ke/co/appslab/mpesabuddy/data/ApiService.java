package ke.co.appslab.mpesabuddy.data;

import ke.co.appslab.mpesabuddy.models.MpesaResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("stk")
    @FormUrlEncoded
    Call<MpesaResponse> initiatePayment(
            @Field("amount") String amount,
            @Field("phone_no") String mobileNumber
    );


    @GET("payment_status")
    Call<ResponseBody> checkPaymentStatus();
}
