package com.example.megawe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistrasiActivity extends AppCompatActivity {

    //Declaration EditTexts
    EditText editTextUserName;
    EditText editTextPassword1;
    EditText editTextPassword;

    //Declaration TextInputLayout
    TextInputLayout textInputLayoutUserName;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //Declaration Button
    Button buttonRegister;
    Button buttonCancel;

    //    Declaration spinner
    Spinner spinner;

    //Declaration SqliteHelper
    SqliteHelper sqliteHelper;

    //    deklarasi progress dialog dan volley
    ProgressDialog progressDialog;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        sqliteHelper = new SqliteHelper(this);
        initTextViewLogin();
        initViews();

        //        adaoter untuk pemilihan spinner jenis registrasi
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.level_user, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    processRegister();

//                    String UserName = editTextUserName.getText().toString();
//                    String Email = editTextPassword1.getText().toString();
//                    String Password = editTextPassword.getText().toString();
//
//                    //Check in the database is there any user associated with  this email
//                    if (!sqliteHelper.isEmailExists(Email)) {
//
//                        //Email does not exist now add new user to database
//                        sqliteHelper.addUser(new User(null, UserName, Email, Password));
//                        Snackbar.make(buttonRegister, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                finish();
//                            }
//                        }, Snackbar.LENGTH_LONG);
//                    } else {
//
//                        //Email exists with email input provided so show error user already exist
//                        Snackbar.make(buttonRegister, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
//                    }
                }
            }
        });

//        menangani klik tombol cancel
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                kembali ke halaman login
                Intent login = new Intent(RegistrasiActivity.this, AddActivity.class);
                startActivity(login);
                finish();
            }
        });
    }

    //    fungsi untuk mengirim data registrasi ke API
    private void processRegister() {
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest registerRequest = new StringRequest(Request.Method.POST, konfigurasi.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {
                    JSONObject objectResponse = new JSONObject(response);
                    String status = objectResponse.getString("status");
                    String message = objectResponse.getString("message");

                    if (status.equals("true")){
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

                        Intent login = new Intent(RegistrasiActivity.this, AddActivity.class);
                        startActivity(login);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", editTextUserName.getText().toString().trim());
                params.put("password", editTextPassword.getText().toString().trim());
                params.put("level", spinner.getSelectedItem().toString().trim());
                return params;
            }
        };

        requestQueue.add(registerRequest);
    }

    //this method used to set Login TextView click event
    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextPassword1 = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName);
        buttonRegister = (Button) findViewById(R.id.daftar_button);
        buttonCancel = findViewById(R.id.cancel_button);
        spinner = findViewById(R.id.levelSpinner);

        requestQueue = Volley.newRequestQueue(this);
        progressDialog = new ProgressDialog(this);
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String UserName = editTextUserName.getText().toString();
        String Password1 = editTextPassword1.getText().toString();
        String Password = editTextPassword.getText().toString();
        String spinnerText = spinner.getSelectedItem().toString().trim();

        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            valid = false;
            textInputLayoutUserName.setError("Please enter valid username!");
        } else {
            if (UserName.length() > 5) {
                valid = true;
                textInputLayoutUserName.setError(null);
            } else {
                valid = false;
                textInputLayoutUserName.setError("Username is to short!");
            }
        }

        //Handling validation for Email field
        if (Password1.isEmpty()) {
            valid = false;
            textInputLayoutEmail.setError("Please enter valid password!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.equals(Password1)) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Konfirmasi password tidak sesuai");
            }
        }

//        cek apakah sudah memilih jenis registrasi
        if (spinnerText.equals("Pilih disini")) {
            Snackbar.make(buttonRegister, "Harap pilih 'ingin mendaftar sebagai apa?'", Snackbar.LENGTH_LONG).show();
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_button:
                Intent cancel = new Intent(RegistrasiActivity.this, AddActivity.class);
                startActivity(cancel);
                break;
        }
    }
}