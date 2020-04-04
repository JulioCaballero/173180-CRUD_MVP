package com.example.crud_mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.crud_mvp.R;
import com.example.crud_mvp.models.User;
import com.example.crud_mvp.presents.FormPresent;


public class FormFirst extends AppCompatActivity implements FormPresent.View , AdapterView.OnItemSelectedListener{
    private EditText nombres;
    private EditText apellidos;
    private EditText edad;
    private int idEditar;
    private  Spinner sexos;
    private  ArrayAdapter<CharSequence> adapter;
    private String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_first);
        Button guardar = findViewById(R.id.guardar);
        nombres = findViewById(R.id.nombres);
        apellidos = findViewById(R.id.apellidos);
        edad = findViewById(R.id.edad);

        sexos = findViewById(R.id.sexos);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.sexos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexos.setAdapter(adapter);
        sexos.setOnItemSelectedListener(this);


        final FormPresent present = new FormPresent(this);

        final boolean editar = (boolean)getIntent().getSerializableExtra("editar");
        System.out.println("Editar es :" +editar);
        if(editar){
            idEditar = (int)getIntent().getSerializableExtra("idEditar");
            present.detallesAlumno(idEditar);
        }

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(editar){
                    //Con id
                    User user = new User(idEditar,nombres.getText().toString(),apellidos.getText().toString(),
                            Integer.parseInt(edad.getText().toString()),sexo,null);
                    present.actualizarAlumno(user);
                }
                else{
                    //Sin id
                    User user = new User(nombres.getText().toString(),apellidos.getText().toString(),
                            Integer.parseInt(edad.getText().toString()),sexo,null);
                    present.guardarAlumno(user);
                }
            }
        });
    }

    public void goFirstFragment(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void llenarCampos(User user) {
        nombres.setText(user.getNombre());
        apellidos.setText(user.getApellidos());
        edad.setText(user.getEdad()+"");
        sexos.setSelection(adapter.getPosition(user.getSexo()));
    }

    @Override
    public void notificacionGuardado(String mensaje, boolean aceptado) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
        if(aceptado){
            goFirstFragment();
        }
    }

    @Override
    public void notificacionActualizacion(String mensaje, boolean aceptado) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
        if(aceptado){
            goFirstFragment();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        sexo = parent.getItemAtPosition(position).toString();




     //   Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
