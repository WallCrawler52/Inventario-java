package org.bedu.java.jse.basico.proyecto;
import java.util.Scanner;

import java.util.*;

public class Inventario {
    public static void main(String[] args) {
        GestorArticulo gestor = new GestorArticulo();
        gestor.cargarDesdeArchivo("catalogo.txt");

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Artículos ===");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Agregar comic");
            System.out.println("3. Agregar manga");
            System.out.println("4. Eliminar elemento");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Contenido del catálogo ---");
                    gestor.mostrarTodos();
                    break;

                case 2:
                    System.out.print("Título: ");
                    String tituloComic = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Año (opcional, 0 si no quieres ponerlo): ");
                    int anioComic = sc.nextInt(); sc.nextLine();

                    if (anioComic == 0)
                        gestor.agregarElemento(new Comic(tituloComic, autor));
                    else
                        gestor.agregarElemento(new Comic(tituloComic, anioComic, autor));

                    gestor.guardarEnArchivo("catalogo.txt");
                    System.out.println("Comic agregado con éxito.");
                    break;

                case 3:
                    System.out.print("Título: ");
                    String tituloPeli = sc.nextLine();
                    System.out.print("Escritor: ");
                    String director = sc.nextLine();
                    System.out.print("Año (opcional, 0 si no quieres ponerlo): ");
                    int anioPeli = sc.nextInt(); sc.nextLine();

                    if (anioPeli == 0)
                        gestor.agregarElemento(new Manga(tituloPeli, director));
                    else
                        gestor.agregarElemento(new Manga(tituloPeli, anioPeli, director));

                    gestor.guardarEnArchivo("catalogo.txt");
                    System.out.println("Comic agregado con éxito.");
                    break;

                case 4:
                    gestor.mostrarConIndices();
                    System.out.print("Ingresa los índices a eliminar separados por coma (ej: 0,2,5): ");
                    String entrada = sc.nextLine();

                    String[] partes = entrada.split(",");
                    List<Integer> indices = new ArrayList<>();

                    for (String parte : partes) {
                        try {
                            indices.add(Integer.parseInt(parte.trim()));
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida: " + parte);
                        }
                    }

                    if (indices.isEmpty()) {
                        System.out.println("No se ingresaron índices válidos.");
                        break;
                    }

                    // Mostrar los elementos que se eliminarán
                    System.out.println("\nLos siguientes elementos serán eliminados:");
                    for (int i : indices) {
                        if (i >= 0 && i < gestor.getElementos().size()) {
                            Articulo m = gestor.getElementos().get(i);
                            System.out.println("[" + i + "] " + m.getTitulo());
                        } else {
                            System.out.println("[" + i + "] <índice inválido>");
                        }
                    }

                    System.out.print("\nEsta acción es irreversible. ¿Realmente deseas continuar? (s/n): ");
                    String confirmacion = sc.nextLine().trim().toLowerCase();
                    if (!confirmacion.equals("s")) {
                        System.out.println("Operación cancelada.");
                        break;
                    }

                    gestor.eliminarMultiplesElementos(indices);
                    gestor.guardarEnArchivo("catalogo.txt");
                    break;


                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }
}