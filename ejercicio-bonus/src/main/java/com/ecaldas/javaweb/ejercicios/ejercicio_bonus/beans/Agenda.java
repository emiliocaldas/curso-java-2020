package com.ecaldas.javaweb.ejercicios.ejercicio_bonus.beans;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private List<Contacto> contactos;
	private int tamanio;
	static final int TAMANIO_POR_DEFECTO = 5;

	public Agenda() {
		tamanio = TAMANIO_POR_DEFECTO;
		contactos = new ArrayList<Contacto>(tamanio);
	}

	public int aniadirContacto(Contacto contacto) {
		int resultado = 1;

		if (contacto.getNombre().trim().isEmpty() || contacto.getTelefono().trim().isEmpty()) {
			resultado = 2;
		} else if (contactos.size() == tamanio) {
			resultado = 3;
		} else if (existeContacto(contacto)) {
			resultado = 4;
		} else {
			contactos.add(contacto);
		}

		return resultado;
	}

	public String listarContactos() {
		String cadenaContactos = "";

		for (Contacto contacto : contactos) {
			cadenaContactos += contacto.toString() + "\n";
		}

		return cadenaContactos;
	}

	public String buscaContacto(String nombre) {
		int indice = contactos.indexOf(new Contacto(nombre, null));

		if (indice > -1) {
			return contactos.get(indice).getTelefono();
		} else {
			return "";
		}
	}

	public boolean existeContacto(String nombre) {
		return existeContacto(new Contacto(nombre, null));
	}

	public boolean eliminarContacto(String nombre) {
		return contactos.remove(new Contacto(nombre, null));
	}

	public int validarAgendaDisponible() {
		return tamanio - contactos.size();
	}

	public boolean validarAgendaLlena() {
		return contactos.size() == tamanio;
	}

	public void ampliarAgenda(int cantidad) {
		tamanio += cantidad;
	}

	private boolean existeContacto(Contacto contacto) {
		return contactos.contains(contacto);
	}

	public int getTamanio() {
		return tamanio;
	}

	@Override
	public String toString() {
		return "Agenda [contactos=" + contactos.size() + ", tamaño=" + tamanio + "]";
	}

}
