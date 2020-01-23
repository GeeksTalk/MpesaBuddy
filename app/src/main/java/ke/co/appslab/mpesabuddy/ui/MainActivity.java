package ke.co.appslab.mpesabuddy.ui;

import androidx.appcompat.app.AppCompatActivity;
import ke.co.appslab.mpesabuddy.R;
import ke.co.appslab.mpesabuddy.data.ApiClient;
import ke.co.appslab.mpesabuddy.data.ApiService;
import ke.co.appslab.mpesabuddy.models.MpesaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button initiatePaymentBtn;
    TextInputEditText amountEdit,phoneNumberEdit;
    ApiService apiService;
    ProgressBar progressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initiatePaymentBtn = findViewById(R.id.initiatePaymentButton);
    amountEdit = findViewById(R.id.amountEdit);
    phoneNumberEdit = findViewById(R.id.phoneEdit);
      progressBar = findViewById(R.id.progressBar);
     apiService = ApiClient.getClient().create(ApiService.class);;

    initiatePaymentBtn.setOnClickListener(view ->{
         String amount = amountEdit.getText().toString();
         String phoneNumber = phoneNumberEdit.getText().toString();

        initializePayment(amount, phoneNumber);
        showProgressDialog();

            }
            );
  }

    private void initializePayment(String amount, String phoneNumber) {
        Call<MpesaResponse> call = apiService.initiatePayment(amount, phoneNumber);
        call.enqueue(new Callback<MpesaResponse>() {
            @Override
            public void onResponse(Call<MpesaResponse> call, Response<MpesaResponse> response) {
                hideProgressDialog();
                if (response.isSuccessful()){
                    MpesaResponse mpesaResponse = response.body();
                    Toast.makeText(getApplicationContext(),mpesaResponse.getMessage(),Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MpesaResponse> call, Throwable t) {
                hideProgressDialog();
                Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void showProgressDialog(){
      progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressDialog(){
        progressBar.setVisibility(View.GONE);
    }
}
