package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilidades.Entrada;

public class Cliente {

	private String nombre;
	private String dni;
	private String direccion;
	private String localidad;
	private String codigoPostal;
	private int identificador;
	private int numClientes;
	// Objeto de la clase Cliente
	Cliente cliente = new Cliente(nombre, dni, direccion, localidad, codigoPostal);

	// Constructor con los 5 parámetros
	public Cliente(String nombre, String dni, String direccion, String localidad, String codigoPostal) {
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}

	// Constructor copia de la clase Cliente
	public Cliente(Cliente cliente) {
		this.nombre = cliente.getNombre();
		this.dni = cliente.getDni();
		this.direccion = cliente.getDireccion();
		this.localidad = cliente.getLocalidad();
		this.codigoPostal = cliente.getCodigoPostal();

	}

	// Métodos getter de los atributos
	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getNumClientes() {
		return numClientes;
	}

	// Método para comprobar el código postal introducido
	private void compruebaCodigoPostal() throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}");
		Matcher emparejador;

		emparejador = patron.matcher(codigoPostal);
		// Lanzamos excepción si el código Postal es erroneo
		if (!emparejador.matches()) {
			throw new ExcepcionAlquilerVehiculos("El formato del Código Postal es erroneo");
		}

	}

	// Método para comprobar el DNI introducido
	private void compruebaDni() throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("[0-9A-Z][0-9]{7}[A-Z]");
		Matcher emparejador;

		emparejador = patron.matcher(dni);
		// Lanzamos excepción si el DNI no es correcto
		if (!emparejador.matches()) {
			throw new ExcepcionAlquilerVehiculos(" El formato del DNI es erroneo");
		}

	}
	// Método toString que representa al cliente

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion + ", localidad=" + localidad
				+ ", codigoPostal=" + codigoPostal + ", identificador=" + identificador + ", numClientes=" + numClientes
				+ ", cliente=" + cliente + "]";
	}
	
}
