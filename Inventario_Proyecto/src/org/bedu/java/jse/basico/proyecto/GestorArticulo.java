package org.bedu.java.jse.basico.proyecto;

import java.io.*;
import java.util.*;

public class GestorArticulo {
    private List<Articulo> elementos;

    public GestorArticulo() {
        elementos = new ArrayList<>();
    }

    public void agregarElemento(Articulo m) {
        elementos.add(m);
    }

    public void mostrarTodos() {
        int comics = 0;
        int mangas = 0;

        System.out.println("\n### Comics ###\n");

        for (Articulo m : elementos) {
            if (m instanceof Comic) {
                m.mostrarDetalles();
                System.out.println(); // Espacio entre elementos
                comics++;
            }
        }

        System.out.println("Comics registrados: " + comics);

        System.out.println("\n### Mangas ###\n");

        for (Articulo m : elementos) {
            if (m instanceof Manga) {
                m.mostrarDetalles();
                System.out.println(); // Espacio entre elementos
                mangas++;
            }
        }

        System.out.println("Mangas registrados: " + mangas);
    }


    public static int contarComics(List<Articulo> lista) {
        int contador = 0;
        for (Articulo m : lista) {
            if (m instanceof Comic) contador++;
        }
        return contador;
    }

    public void cargarDesdeArchivo(String nombreArchivo) {
        try (Scanner lector = new Scanner(new File(nombreArchivo))) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");
                if (partes.length >= 3) {
                    String tipo = partes[0].trim();
                    String titulo = partes[1].trim();
                    String autorOdirector = partes[2].trim();
                    int anio = (partes.length == 4) ? Integer.parseInt(partes[3].trim()) : 0;

                    if (tipo.equalsIgnoreCase("comic")) {
                        agregarElemento(new Comic(titulo, anio, autorOdirector));
                    } else if (tipo.equalsIgnoreCase("manga")) {
                        agregarElemento(new Manga(titulo, anio, autorOdirector));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir año a número: " + e.getMessage());
        }
    }

    public void guardarEnArchivo(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Articulo m : elementos) {
                if (m instanceof Comic) {
                    Comic l = (Comic) m;
                    bw.write("comic," + l.getTitulo() + "," + l.getEscritor() + "," + l.getAnio());
                } else if (m instanceof Manga) {
                    Manga p = (Manga) m;
                    bw.write("manga," + p.getTitulo() + "," + p.getMangaka() + "," + p.getAnio());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    public void eliminarMultiplesElementos(List<Integer> indices) {
        // Ordenar en reversa para no romper los índices al eliminar
        Collections.sort(indices, Collections.reverseOrder());

        for (int index : indices) {
            if (index >= 0 && index < elementos.size()) {
                Articulo eliminado = elementos.remove(index);
            } else {
                System.out.println("Índice inválido: " + index);
            }
        }
        System.out.println("\nLos elementos han sido eliminados correctamente");
    }


    public void mostrarConIndices() {
        System.out.println("\n### Catálogo con índices ###\n");

        for (int i = 0; i < elementos.size(); i++) {
            Articulo m = elementos.get(i);
            System.out.print("[" + i + "] ");
            m.mostrarDetalles();
        }
    }


    public List<Articulo> getElementos() {
        return elementos;
    }
}