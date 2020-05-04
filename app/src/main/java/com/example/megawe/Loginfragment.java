package com.example.megawe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Loginfragment extends Fragment {
    Button buttonLogin;
    
    public Loginfragment(){
        
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loginfragment, container, false);
        
        buttonLogin=(Button) view.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Sukses Login!", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    public void goLogin(View view){
        Intent intent = new Intent(getActivity().getApplication(), AfterLogin.class);
        startActivity(intent);

    }
}