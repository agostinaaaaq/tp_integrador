package tp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class libro {
	
	static String opcion, buscar_libro;
	static String[] titulo = new String [10];
	static String[] autor = new String [10];
	static int[] paginas = new int [10];
	static int cant_libros, i = 0;
	
	public static void menu() {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("\n\tMenu principal");
		System.out.println("\na. Agregar un libro");
		System.out.println("b. Mostrar lista de libros");
		System.out.println("c. Buscar un libro por título");
		System.out.println("d. Salir");
		
		System.out.println("\nOpcion: ");
		opcion = entrada.next();
	}
	
	public static void opc1() {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("\nTitulo del libro: ");
		titulo[cant_libros] = entrada.nextLine();
		
		System.out.println("Autor del libro: ");
		autor[cant_libros] = entrada.nextLine();
		
		System.out.println("Paginas del libro: ");
		paginas[cant_libros] = entrada.nextInt();
		
		if (paginas[cant_libros] < 0) {
            throw new ArithmeticException();
        }
		
		cant_libros++;
	}
	
	public static void opc2() {
		
		System.out.println("\nLista de libros:");
		
		for (int i = 0 ; i < cant_libros ; i++) {
			System.out.println("\nTitulo: " + titulo[i]);
			System.out.println("Autor: " + autor[i]);
			System.out.println("Paginas: " + paginas[i]);
		}
	}
	
	public static void opc3() {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("\nIngrese el titulo del libro: ");
		buscar_libro = entrada.nextLine();
		
		boolean libro_encontrado = false;
		
		for (int i = 0 ; i < cant_libros ; i++) {
			
			if (titulo[i].equalsIgnoreCase(buscar_libro)) {
				
				libro_encontrado = true;
				
				System.out.println("\nTitulo: " + titulo[i]);
				System.out.println("Autor: " + autor[i]);
				System.out.println("Paginas: " + paginas[i]);
			}
			
			else if (!titulo[i].equalsIgnoreCase(buscar_libro)) {
				
				System.out.println("\nLibro no encontrado");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		do {
			try {
				menu();
				
				switch (opcion) {
			
					case "a":
						opc1();
						break;
				
					case "b":
						opc2();
						break;
				
					case "c": 
						opc3();
						break;
					}
					
			} catch (ArithmeticException e) { 
	            System.out.println("\nError: Cero o numero negativo.");
			} catch (InputMismatchException e) {
	            System.out.println("\nError: Debes ingresar un dato valido.");
	            entrada.next();
			};
		
		} while (!opcion.equals("d"));
	}	
}
