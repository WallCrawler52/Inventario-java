# Inventario-java
Descripción
Este proyecto es un programa de consola en Java que permite gestionar una colección de artículos multimedia, específicamente cómics y mangas. Con este sistema puedes ver el catálogo, agregar nuevos ítems, eliminar existentes y guardar todos los cambios para consultarlos después.

Funcionalidades
Visualizar el catálogo completo, separado en cómics y mangas.

Agregar nuevos cómics o mangas, con título, autor/mangaka y año (opcional).

Eliminar uno o varios artículos a la vez mediante índices.

Persistencia de datos en un archivo de texto (catalogo.txt) para mantener el catálogo entre sesiones.

Estructura del proyecto
Articulo.java: Clase abstracta que define los atributos y comportamiento básico de un artículo.

Comic.java: Clase que extiende Articulo para representar cómics.

Manga.java: Clase que extiende Articulo para representar mangas.

GestorArticulo.java: Clase que maneja la colección, incluyendo carga, guardado, visualización y eliminación de artículos.

Main.java: Programa principal con la interfaz de usuario por consola.

Requisitos
Java JDK 8 o superior.

Archivo catalogo.txt en la carpeta del proyecto (puede estar vacío al inicio).
