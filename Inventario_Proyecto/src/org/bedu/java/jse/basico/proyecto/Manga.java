package org.bedu.java.jse.basico.proyecto;

public class Manga extends Articulo {
    private String mangaka;

    public Manga(String titulo, int anio, String mangaka) {
        super(titulo, anio);
        this.mangaka = mangaka;
    }

    public Manga(String titulo, String mangaka) {
        this(titulo, 0, mangaka);
    }

    public String getMangaka() { return mangaka; }

    @Override
    public void mostrarDetalles() {
        System.out.println(getTitulo() + " - " + mangaka + " (" + getAnio() + ")");
    }
}