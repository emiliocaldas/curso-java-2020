package com.ecaldas.javaweb.ejercicios.ejercicio_bonus;

import java.util.Scanner;
import com.ecaldas.javaweb.ejercicios.ejercicio_bonus.beans.Agenda;
import com.ecaldas.javaweb.ejercicios.ejercicio_bonus.beans.Contacto;

public class ProgramaPrincipal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;
		Agenda agenda = new Agenda();
		String nombre = "";
		String telefono = "";
		int resultadoOpcion = -1;
		int opcion = -1;

		do {
			imprimirMenu();
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				// Añadir contacto
				System.out.println("Ingresa el nombre del contacto:");
				nombre = scanner.next();
				
				System.out.println("Ingresa el teléfono del contacto:");
				telefono = scanner.next();

				resultadoOpcion = agenda.aniadirContacto(new Contacto(nombre, telefono));
				switch (resultadoOpcion) {
				case 2:
					System.out.println("Datos de contacto incompletos.");
					break;
				case 3:
					System.out.println("Agenda llena. No se pueden agregar mas contactos.");
					break;
				case 4:
					System.out.println("Contacto ya existe en la agenda. No se agrega el contacto.");
					break;
				default:
					System.out.println("Contacto agregado a la agenda.");
				}

				break;
			case 2:
				// Listar contactos
				System.out.println(agenda.listarContactos());
				break;
			case 3:
				// Buscar contacto
				System.out.println("Ingresa el nombre del contacto:");
				nombre = scanner.next();

				telefono = agenda.buscaContacto(nombre);
				if (!telefono.isEmpty()) {
					System.out.println("Contacto encontrado. Telefono: " + telefono);
				} else {
					System.out.println("Contacto no existe en la agenda.");
				}

				break;
			case 4:
				// Existe contacto
				System.out.println("Ingresa el nombre del contacto:");
				nombre = scanner.next();

				if (agenda.existeContacto(nombre)) {
					System.out.println("Contacto existe en la agenda.");
				} else {
					System.out.println("Contacto no existe en la agenda.");
				}

				break;
			case 5:
				// Eliminar contacto
				System.out.println("Ingresa el nombre del contacto que desea eliminar:");
				nombre = scanner.next();

				if (agenda.eliminarContacto(nombre)) {
					System.out.println("Contacto eliminado de la agenda.");
				} else {
					System.out.println("Contacto no existe en la agenda. No se elimino el contacto.");
				}

				break;
			case 6:
				// Validar agenda disponible
				resultadoOpcion = agenda.validarAgendaDisponible();
				System.out.println("Espacion disponibles en la agenda: " + resultadoOpcion);

				break;
			case 7:
				// Validar agenda llena
				if (agenda.validarAgendaLlena()) {
					System.out.println("La agenda esta llena. No se pueden agregar mas contactos.");
				} else {
					System.out.println("La agenda tiene espacios disponibles.");
				}

				break;
			case 8:
				// Ampliar agenda
				System.out.println("Ingresa la cantidad de espacios a ampliar:");
				int cantidadAmpliar = scanner.nextInt();
				agenda.ampliarAgenda(cantidadAmpliar);
				System.out.println("Agenda ampliada a " + agenda.getTamanio() + " espacios.");

				break;
			default:
				salir = true;
				System.out.println("Gracias por su visita!");
			}

			System.out.println("\nDatos de la agenda: " + agenda.toString() + "\n");

		} while (!salir);

		System.out.println("Fin del programa");
		scanner.close();
	}

	private static void imprimirMenu() {
		System.out.println("#############################");
		System.out.println("AGENDA TELEFONICA");
		System.out.println("-----------------\n");
		System.out.println("Elige una opción del menú:");
		System.out.println("1. Añadir contacto");
		System.out.println("2. Listar contactos");
		System.out.println("3. Buscar contacto");
		System.out.println("4. Existe contacto?");
		System.out.println("5. Eliminar contacto");
		System.out.println("6. Validar agenda disponible");
		System.out.println("7. Validar agenda llena");
		System.out.println("8. Ampliar agenda");
		System.out.println("9. Salir");
	}
}
