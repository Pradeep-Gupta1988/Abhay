package com.sample.jackdaniels.authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sample.jackdaniels.R;

/**
 * A login screen that offers login via Mobile Number.
 */
public class LoginActivity extends AppCompatActivity  {

    private EditText editTextMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextMobile = findViewById(R.id.edit_mobile_no);

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = editTextMobile.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    editTextMobile.setError("Enter a valid mobile");
                    editTextMobile.requestFocus();
                    return;
                }
                editTextMobile.setText("");
                Intent intent = new Intent(LoginActivity.this, VerifyLoginActivity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        });  }
}

