package com.example.crud_mvp.presents;
import com.example.crud_mvp.models.User;

import java.util.ArrayList;

public class MainActivityPresent {
    private View view;

    public MainActivityPresent(View view){
        this.view = view;
    }

    /*Aplica para los dos fragments, ya que los usuarios vienen con los datos completos, es decir,
    *en el metodo crear tabla se utilizan los atributos que se quiere mostrar
    * y el dialog es lo mismo para ambos, a una se le autoriza mas atributos en el Override dentro
    * del propio fragmento
    */

    public void llenarLista(){
        User.getAlumnos(this);
    }

    public void crearTabla(ArrayList<User> lista){
        view.llenarTabla(lista);

    }

    public void detallesUser(int id){
        User.getAlumnoByID(id,this);
    }

    public void dialog(User user){
        view.dialogDetalles(user);
    }

    public void eliminarUsuario(User user){
        User.deleteAlumnos(user,this);
    }

    public void notificacionEliminar(String mensaje, boolean aceptado){
        view.notificacionEliminar(mensaje,aceptado);
    }

    public interface View{
        void llenarTabla(ArrayList<User> lista);
        void dialogDetalles(User user);
        void notificacionEliminar(String mensaje, boolean aceptado);
    }
}
