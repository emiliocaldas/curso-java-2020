package com.ecaldas.javaweb.ejercicios.ejercicio_bonus.beans;

public class Contacto {
	private String nombre;
	private String telefono;

	public Contacto(String nombre, String telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public boolean equals(Object obj) {
		return nombre.trim().equalsIgnoreCase(((Contacto) obj).nombre.trim());
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + "]";
	}

}
