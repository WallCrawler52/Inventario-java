package org.bedu.java.jse.basico.proyecto;

public abstract class Articulo {
    private String titulo;
    private int anio;

    public Articulo(String titulo, int anio) {
        this.titulo = titulo;
        this.anio = anio;
    }

    public String getTitulo() { return titulo; }
    public int getAnio() { return anio; }

    public abstract void mostrarDetalles();
}