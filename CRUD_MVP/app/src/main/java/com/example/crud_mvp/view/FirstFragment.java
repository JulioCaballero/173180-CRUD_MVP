package com.example.crud_mvp.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.crud_mvp.R;
import com.example.crud_mvp.models.User;
import com.example.crud_mvp.presents.MainActivityPresent;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements MainActivityPresent.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TableLayout tlTabla;
    private TableRow fila;
    private TextView tvNombres;
    private TextView tvApellidos;
    private TextView tvEdad;
    private TextView tvSexo;
    private TextView tvCarrera;
    private TextView tvOpciones;
    private Button btnEditar;
    private Button add;
    private Button salir;
    private Button btnEliminar;
    private Button btnDetalles;
    private Button btnCrear;
    private Button btnLogout;
    private int id;
    private View root;
    private MainActivityPresent present;
    private Intent intent;
    private OnFragmentInteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root =  inflater.inflate(R.layout.fragment_first, container,false);
        tlTabla =  root.findViewById(R.id.tlTablafragment);
        present = new MainActivityPresent(this);
        present.llenarLista();
        add = root.findViewById(R.id.add);
        salir = root.findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), FormFirst.class);
                intent.putExtra("editar", false);
                startActivityForResult(intent, 0);
            }
        });

        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void crearTabla(ArrayList<User> obj){
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(tlTabla.getLayoutParams().width, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutNombre = new TableRow.LayoutParams(tlTabla.getLayoutParams().width, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutApellidos = new TableRow.LayoutParams(tlTabla.getLayoutParams().width, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutEdad = new TableRow.LayoutParams(tlTabla.getLayoutParams().width, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutSexo = new TableRow.LayoutParams(tlTabla.getLayoutParams().width, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutCarrera = new TableRow.LayoutParams(tlTabla.getLayoutParams().width, TableRow.LayoutParams.WRAP_CONTENT);

        for(int i = -1 ; i < obj.size(); i++) {
            fila = new TableRow(getContext());
            fila.setLayoutParams(layoutFila);

            if(i == -1) {
                tvNombres = new TextView(getContext());
                tvNombres.setText("Nombres");
                tvNombres.setGravity(Gravity.CENTER);
                tvNombres.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tvNombres.setTextColor(Color.WHITE);
                tvNombres.setPadding(30, 30, 30, 30);
                tvNombres.setLayoutParams(layoutNombre);
                fila.addView(tvNombres);

                tvApellidos = new TextView(getContext());
                tvApellidos.setText("Apellidos");
                tvApellidos.setGravity(Gravity.CENTER);
                tvApellidos.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tvApellidos.setTextColor(Color.WHITE);
                tvApellidos.setPadding(30, 30, 30, 30);
                tvApellidos.setLayoutParams(layoutNombre);
                fila.addView(tvApellidos);

                tvOpciones = new TextView(getContext());
                tvOpciones.setText("");
                tvOpciones.setGravity(Gravity.CENTER);
                tvOpciones.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tvOpciones.setTextColor(Color.WHITE);
                tvOpciones.setPadding(30, 30, 30, 30);
                tvOpciones.setLayoutParams(layoutNombre);
                fila.addView(tvOpciones);

                tvOpciones = new TextView(getContext());
                tvOpciones.setText("");
                tvOpciones.setGravity(Gravity.CENTER);
                tvOpciones.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tvOpciones.setTextColor(Color.WHITE);
                tvOpciones.setPadding(30, 30, 30, 30);
                tvOpciones.setLayoutParams(layoutNombre);
                fila.addView(tvOpciones);


                tlTabla.addView(fila);
            } else {
                try {
                    tvNombres = new TextView(getContext());
                    tvNombres.setGravity(Gravity.CENTER);
                    tvNombres.setText(obj.get(i).getNombre());
                    tvNombres.setPadding(30, 30, 30, 30);
                    tvNombres.setLayoutParams (new TableRow.LayoutParams(50, 50));
                    tvNombres.setLayoutParams(layoutNombre);
                    fila.addView(tvNombres);

                    tvApellidos = new TextView(getContext());
                    tvApellidos.setGravity(Gravity.CENTER);
                    tvApellidos.setText(obj.get(i).getApellidos());
                    tvApellidos.setPadding(30, 30, 30, 30);
                    tvApellidos.setLayoutParams(layoutApellidos);
                    fila.addView(tvApellidos);

                    btnDetalles = new Button(getContext());
                    btnDetalles.setGravity(Gravity.CENTER);
                    //btnDetalles.setText("Detalles");
                    btnDetalles.setLayoutParams (new TableRow.LayoutParams(70, 70));
                    btnDetalles.setBackgroundResource(R.mipmap.elipsis2);
                    btnDetalles.setTextColor(Color.WHITE);
                    btnDetalles.setTag(obj.get(i).getId());
                    btnDetalles.setPadding(30, 30, 30, 30);
                    fila.addView(btnDetalles);

                    btnDetalles.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v){
                            int id2 = Integer.parseInt(v.getTag().toString());
                            System.out.println("La id de detalles es :"+id2);
                            id = id2;
                            present.detallesUser(id);
                        }
                    });

                    tlTabla.addView(fila);
                }catch (Exception e){
                }
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void llenarTabla(ArrayList<User> lista) {
        crearTabla(lista);
    }

    @Override
    public void dialogDetalles(final User user) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
        alerta.setMessage("Nombre: "+user.getNombre()+"\nApellido: "+
                user.getApellidos() + "\nEdad: " + user.getEdad() +
                "\nSexo: " +user.getSexo());
        alerta.setCancelable(false);
        AlertDialog dialog = alerta.create();


        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancelar", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {

               dialog.cancel();


            }});

        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Eliminar", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {

                present.eliminarUsuario(user);

            }});

        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Editar", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                intent = new Intent(getActivity(), FormFirst.class);
                intent.putExtra("editar", true);
                intent.putExtra("idEditar", user.getId());
                startActivityForResult(intent, 0);

            } });
        dialog.show();
    }

    @Override
    public void notificacionEliminar(String mensaje, boolean aceptado) {
        Toast.makeText(getContext(), mensaje, Toast.LENGTH_LONG).show();
        if(aceptado){
            goFirstFragment();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void goFirstFragment(){
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }

    public void goLogin(){
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }
}
