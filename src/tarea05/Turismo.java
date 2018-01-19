package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utilidades.Entrada;

public class Turismo {

	private String matricula;
	private String marca;
	private String modelo;
	private int cilindrada;
	private boolean disponible;

	// Objeto de la clase Turismo
	Turismo turismo = new Turismo(matricula, marca, modelo, cilindrada);

	// Constructor con cuatro par�metros
	public Turismo(String matricula, String marca, String modelo, int cilindrada) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;

	}

	// Constructor copia de la clase Turismo
	public Turismo(Turismo turismo) {
		this.matricula = turismo.getMatricula();
		this.marca = turismo.getMarca();
		this.modelo = turismo.getModelo();
		this.cilindrada = turismo.getCilindrada();

	}

	// M�todos getter
	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public boolean isDisponible() {
		return disponible;
	}

	// M�todo setter para disponible
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Turismo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", cilindrada="
				+ cilindrada + ", disponible=" + disponible + "]";
	}

	// M�todo para comprobar la matr�cula introducida.
	// Matr�cula correcta: Cuatro n�meros, espacio y tres letras may�sculas
	// (excluyendo vocales)
	private void compruebaMatricula() throws ExcepcionAlquilerVehiculos {
		Pattern patron = Pattern.compile("([0-9]{4})+ ([BCDFGHJKLMNPQRSTVWXYZ]{3})");
		Matcher emparejador;

		emparejador = patron.matcher(matricula);
		// Lanzamos excepci�n si la matr�cula es erronea
		if (!emparejador.matches()) {
			throw new ExcepcionAlquilerVehiculos("El formato de la matr�cula es erroneo");
		}
		
	}
	private void compruebaCilindrada() throws ExcepcionAlquilerVehiculos {
		if (cilindrada<0) {
			throw new ExcepcionAlquilerVehiculos("La cilindrada no puede ser menor que 0");
		}

	}
}
