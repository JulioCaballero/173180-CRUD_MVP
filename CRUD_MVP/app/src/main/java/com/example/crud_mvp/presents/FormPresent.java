package com.example.crud_mvp.presents;

import com.example.crud_mvp.models.User;

public class FormPresent {
    private View view;

    public FormPresent(View view){
        this.view = view;
    }

    /*Aplica para los dos formularios, ya que los usuarios vienen con los datos completos, es decir,
     *en el metodo crear, editar solo utiliza los atributos que se requiere mostrar
     * el delete es el mismo para ambos formularios
     */

    public void detallesAlumno(int id){
        User.getAlumnoByIDForm(id,this);
    }

    public void guardarAlumno(User user){
        User.postAlumnos(user,this);
    }

    public void actualizarAlumno(User user){
        User.updateAlumnos(user,this);
    }

    public void llenarCampos(User user){
        view.llenarCampos(user);
    }

    public void notificacionGuardado(String mensaje,boolean aceptado){
        view.notificacionGuardado(mensaje,aceptado);
    }

    public void notificacionActualizacion(String mensaje,boolean aceptado){
        view.notificacionActualizacion(mensaje,aceptado);
    }

    public interface View{
        void llenarCampos(User user);
        void notificacionGuardado(String mensaje, boolean aceptado);
        void notificacionActualizacion(String mensaje,boolean aceptado);
    }
}
