package com.example.workspace.iwish.model;

import java.util.ArrayList;

/**
 * Created by WorkSpace on 05/08/2016.
 */
public class Meta {
    private String titulo;
    private String descupcion;
    private String fecha;
    private String categoria;
    private String prioridad;

    public Meta(String titulo, String descupcion, String fecha, String categoria, String prioridad) {
        this.titulo = titulo;
        this.descupcion = descupcion;
        this.fecha = fecha;
        this.categoria = categoria;
        this.prioridad = prioridad;
    }

    public static final ArrayList<Meta> metas = new ArrayList<>();

    static {
        metas.add(new Meta("Pasar Sistema de informacion", "Pasar la materia Sistema de informacion en el el ultimo semestre", "01/07/16", "Universidad", "Baja"));
        metas.add(new Meta("Pasar No numerica", "Pasar Optimizacion en el el ultimo semestre", "11/06/16", "Universidad", "Alta"));
        metas.add(new Meta("Pasar Investigacion", "Pasar no numerica materias en el el ultimo semestre", "10/07/16", "Vida", "Baja"));
        metas.add(new Meta("Aprender a nadar", "Aprender a nadar en el ultimo semestre de la carrera", "30/08/16", "Universidad", "Baja"));
        metas.add(new Meta("Pasar Optimizacion", "Pasar Optimizacion en el el ultimo semestre", "31/08/16", "Universidad", "Alta"));
        metas.add(new Meta("Pasar Sistema de informacion", "Pasar la materia Sistema de informacion en el el ultimo semestre", "01/09/16", "Vida", "Media"));
        metas.add(new Meta("Aprender a nadar", "Aprender a nadar en el ultimo semestre de la carrera", "10/09/16", "Universidad", "Baja"));
        metas.add(new Meta("Entrenar Correr", "Correr mucho mas en las tarde noche en el gimnasio", "12/09/16", "Fisica", "Media"));
        metas.add(new Meta("Entrenar Caminata", "Caminar mucho mas en las tarde noche en el gimnasio", "16/10/16", "Fisica", "Alta"));
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescupcion() {
        return descupcion;
    }

    public void setDescupcion(String descupcion) {
        this.descupcion = descupcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
