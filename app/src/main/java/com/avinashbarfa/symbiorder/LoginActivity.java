package com.avinashbarfa.symbiorder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText mobileNo;
    Button btnMobile;
    String contactNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobileNo = findViewById(R.id.edt_mobile);
        btnMobile = findViewById(R.id.btnMobile);
        Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();

//        btnMobile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                contactNumber = Integer.valueOf(mobileNo.getText().toString());
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                intent.putExtra("contactNumber" , contactNumber);
//                startActivity(intent);
//            }
//        });

    }

    public void fill(View view)
    {
                contactNumber = mobileNo.getText().toString();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
               intent.putExtra("contactNumber" , contactNumber);
               startActivity(intent);
    }

}
