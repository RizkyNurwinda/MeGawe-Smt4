package com.example.megawe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    //Declaration EditTexts
    EditText editTextEmail;
    EditText editTextPassword;

    //Declaration TextInputLayout
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //Declaration Button
    Button buttonLogin;

    //Declaration SqliteHelper
    SqliteHelper sqliteHelper;

    //    progressdialog dan request queue volley
    ProgressDialog progressDialog;
    RequestQueue requestQueue;

    //    session manager untuk menyimpan sesi login
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        sqliteHelper = new SqliteHelper(this);
        initCreateAccountTextView();
        initViews();

//        instance dari session manager, requestQueue volley dan progressdialog
        sessionManager = new SessionManager(this);
        requestQueue = Volley.newRequestQueue(this);
        progressDialog = new ProgressDialog(this);


//  cek apakah user sudah login
        if (sessionManager.isLogin()) {
            Intent afterLogin = new Intent(AddActivity.this, AfterLoginActivity.class);
            startActivity(afterLogin);
            finish();
        }

        //set click event of login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Check user input is correct or not
                if (validate()) {
                    loginProcess();
                }
            }
        });


    }

    //this method used to set Create account TextView text and click event( maltipal colors
    // for TextView yet not supported in Xml so i have done it programmatically)
    private void initCreateAccountTextView() {
        TextView textViewCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);
        textViewCreateAccount.setText(fromHtml("<font color='#ffffff'>I don't have account yet. </font><font color='#0c0099'>Belum Punya Akun?</font>"));
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddActivity.this, RegistrasiActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

    }

    //This method is for handling fromHtml method deprecation
    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for Email field
        if (Email.isEmpty()) {
            valid = false;
            textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 0) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Password is to short!");
            }
        }

        return valid;
    }

    //    fungsi untuk volley request login
    private void loginProcess() {
        progressDialog.show();

//        string request untuk request ke api login
        StringRequest loginRequest = new StringRequest(Request.Method.POST, konfigurasi.URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {
//                    mengambil array dan objek dari resoinse api login
                    JSONArray arrayHasil = new JSONArray(response);
                    JSONObject objekHasil = arrayHasil.getJSONObject(0);

//                    menyimpan response data ke variabel string
                    String id_user = objekHasil.getString("idUser");
                    String username = objekHasil.getString("username");
                    String level = objekHasil.getString("level");

//                    menyimpan session login
                    sessionManager.createSession(id_user, username, level);

//                    intent ke afterloginactivity
                    Intent afterLogin = new Intent(AddActivity.this, MainActivity.class);
                    startActivity(afterLogin);
                    finish();
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
//                parameter yang dikirim ke api dengan method post
                Map<String, String> params = new HashMap<>();
                params.put("username", editTextEmail.getText().toString().trim());
                params.put("password", editTextPassword.getText().toString().trim());
                return params;
            }
        };

        requestQueue.add(loginRequest);
    }
}
