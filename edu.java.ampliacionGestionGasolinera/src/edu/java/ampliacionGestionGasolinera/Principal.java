package edu.java.ampliacionGestionGasolinera;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// Clase Principal, aquí haremos las llamadas a las clases y métodos
		
		// Creamos un objeto de tipo Repostaje
		Repostaje repos  = new Repostaje();
		// Creamos una lista que contendrá objetos de tipo Repostaje (Nuestra base de datos)
		List<Repostaje> listaBD = new ArrayList<>();
		
		// Imprimir el menú por consola
		// Scanner con la opción del usuario
		Scanner entradaOpcion = new Scanner(System.in);
		int opcion;
		do {
			// Mostramos el menu
			mostrarMenu();
			
			// Pedimos la opción y la guardamos
			System.out.println("Introduzca la opción deseada:");
			opcion = entradaOpcion.nextInt();
			System.out.println("[INFO] - Has seleccionado la opcion " + opcion); // Para mostrar al usuario la opción seleccionada
			
			// Ahora controlamos la opción
			switch (opcion) {
			case 1:
				// REPOSTAJE NORMAL
				listaBD.add(repos.repostajeNormal(listaBD));
				break;

			case 2:
				// REPOSTAJE FACTURA
				listaBD = repos.repostajeFactura(listaBD);
				break;
			
			case 3:
				// VER TODOS LOS REPOSTAJES
				repos.todosRepostajes(listaBD);
				break;
			}
		} while (opcion != 4);
		
		// Cerramos la variable Scanner
		entradaOpcion.close();
	}
	
	private static void mostrarMenu() {
		System.out.println("1. Repostaje Normal");
		System.out.println("2. Repostaje Factura");
		System.out.println("3. Ver todos los repostajes");
		System.out.println("4. Salir");
	}

}

