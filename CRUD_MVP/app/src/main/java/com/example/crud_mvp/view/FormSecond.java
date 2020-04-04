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

public class FormSecond extends AppCompatActivity implements FormPresent.View , AdapterView.OnItemSelectedListener{

    private EditText nombres;
    private EditText apellidos;
    private EditText edad;
    private int idEditar;
    private Spinner sexos;
    private ArrayAdapter<CharSequence> adapter;
    private  Spinner carreras;
    private  ArrayAdapter<CharSequence> adapter2;
    private String sexo;
    private String carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_second);
        Button guardar = findViewById(R.id.guardar2);
        nombres = findViewById(R.id.nombres2);
        apellidos = findViewById(R.id.apellidos2);
        edad = findViewById(R.id.edad2);

        sexos = findViewById(R.id.sexos2);
        carreras = findViewById(R.id.carreras2);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.sexos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2 = ArrayAdapter.createFromResource(this,
                R.array.carreras, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexos.setAdapter(adapter);
        sexos.setOnItemSelectedListener(this);
        carreras.setAdapter(adapter2);
        carreras.setOnItemSelectedListener(this);

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
                            Integer.parseInt(edad.getText().toString()),sexo,carrera);
                    present.actualizarAlumno(user);
                }
                else{
                    //Sin id
                    User user = new User(nombres.getText().toString(),apellidos.getText().toString(),
                            Integer.parseInt(edad.getText().toString()),sexo,carrera);
                    present.guardarAlumno(user);
                }
            }
        });
    }

    public void goFirstFragment(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void goLogin(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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
        carreras.setSelection(adapter2.getPosition(user.getCarrera()));
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
        if(parent.getId() == R.id.sexos2)
        {
            sexo = parent.getItemAtPosition(position).toString();
        }
        else if(parent.getId() == R.id.carreras2)
        {
            carrera = parent.getItemAtPosition(position).toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
