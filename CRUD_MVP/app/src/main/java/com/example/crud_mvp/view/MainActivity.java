package com.example.crud_mvp.view;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.crud_mvp.Login.Login;
import com.example.crud_mvp.R;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener, SecondFragment.OnFragmentInteractionListener {

    private Fragment first;
    private Fragment second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = new FirstFragment();
        second = new SecondFragment();
        if(Login.getUsername().equals("admin"))
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,first).commit();
        else
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,second).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
