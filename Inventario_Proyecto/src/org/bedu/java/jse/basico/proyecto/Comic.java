package org.bedu.java.jse.basico.proyecto;

public class Comic extends Articulo {
    private String escritor;

    public Comic(String titulo, int anio, String escritor) {
        super(titulo, anio);
        this.escritor = escritor;
    }

    public Comic(String titulo, String escritor) {
        this(titulo, 0, escritor);
    }

    public String getEscritor() { return escritor; }

    @Override
    public void mostrarDetalles() {
        System.out.println(getTitulo() + " - " + escritor + " (" + getAnio() + ")");
    }
}
