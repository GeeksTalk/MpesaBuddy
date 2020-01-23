package ke.co.appslab.mpesabuddy.ui;

import androidx.appcompat.app.AppCompatActivity;
import ke.co.appslab.mpesabuddy.R;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button initiatePaymentBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initiatePaymentBtn = findViewById(R.id.initiatePaymentButton);

    initiatePaymentBtn.setOnClickListener(view ->{
        Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();

            }
            );
  }
}
