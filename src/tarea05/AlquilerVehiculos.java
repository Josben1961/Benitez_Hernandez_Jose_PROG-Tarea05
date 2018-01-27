package tarea05;

public class AlquilerVehiculos {
	private final int MAX_TURISMOS = Integer.MAX_VALUE;
	private final int MAX_CLIENTES = Integer.MAX_VALUE;
	private final int MAX_ALQUILERES = Integer.MAX_VALUE;

	private Turismo[] turismos;
	private Cliente[] clientes;
	private Alquiler[] alquileres;

	// Constructor por defecto
	public AlquilerVehiculos() {
		turismos = new Turismo[MAX_TURISMOS];
		clientes = new Cliente[MAX_CLIENTES];
		alquileres = new Alquiler[MAX_ALQUILERES];
	}

	// M�todos getters
	public Turismo[] getTurismos() {
		return turismos;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public Alquiler[] getAlquileres() {
		return alquileres;
	}

	// M�todo get de Cliente con un par�metro (dni) para saber si existe este
	// cliente.
	public Cliente getCliente(String dni) {
		int posicion = 0;
		boolean clienteDni = false;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i].getDni().equals(dni)) {
				clienteDni = true;
				posicion = i;
			}
		}
		if (clienteDni) {
			return clientes[posicion];
		} else {
			return null;
		}

	}

	// M�todo para agregar clientes
	public void addCliente(Cliente cliente) {
		int posicion = 0;
		boolean posicionArray = false;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] == null) {
				posicionArray = true;
				posicion = i;
			} else if (clientes[i].getDni().equals(cliente.getDni())) {
				throw new ExcepcionAlquilerVehiculos("Este cliente ya existe.");
			}
		}
		if (posicionArray)
			clientes[posicion] = cliente;
		else
			throw new ExcepcionAlquilerVehiculos("No se admiten m�s clientes.");
	}

	// M�todo para borrar un cliente (Si existe).
	public void delCliente(String dni) {
		int posicion = 0;

		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null && clientes[i].getDni().equals(dni)) {
				posicion = i;

				for (int c = posicion; c < clientes.length - 1; c++) {
					clientes[c] = clientes[c + 1];
				}
				clientes[clientes.length - 1] = null;
			} else {
				throw new ExcepcionAlquilerVehiculos("No existe este cliente.");
			}
		}
	}

	// M�todo get de Turismo con un par�metro (matricula) para saber si existe este
	// Turismo.
	public Turismo getTurismo(String matricula) {
		int posicion = 0;
		boolean turismoMatricula = false;

		for (int i = 0; i < turismos.length; i++) {
			if (turismos[i].getMatricula().equals(matricula)) {
				turismoMatricula = true;
				posicion = i;
			}
		}

		if (turismoMatricula)
			return turismos[posicion];
		else
			return null;
	}

	// M�todo para agregar turismos si se puede.
	public void addTurismo(Turismo turismo) {
		int posicion = 0;
		boolean posicionArray = false;
		for (int i = 0; i < turismos.length; i++) {
			if (turismos[i] == null) {
				posicionArray = true;
				posicion = i;
			} else if (turismos[i].getMatricula().equals(turismo.getMatricula())) {
				throw new ExcepcionAlquilerVehiculos("Este turismo ya existe.");
			}
		}
		if (posicionArray)
			turismos[posicion] = turismo;
		else
			throw new ExcepcionAlquilerVehiculos(" Almac�n de turismos completo.");
	}

	// M�todo para borrar un turismo si este existe y sino, lanzar excepci�n.
	public void delTurismo(String matricula) {
		int posicion = 0;

		for (int i = 0; i < turismos.length; i++) {
			if (turismos[i] != null && turismos[i].getMatricula().equals(matricula)) {
				posicion = i;

				for (int j = posicion; j < turismos.length - 1; j++) {
					turismos[j] = turismos[j + 1];
				}
				turismos[turismos.length - 1] = null;
			} else {
				throw new ExcepcionAlquilerVehiculos("El turismo introducido no existe.");
			}
		}
	}

	// M�todo para crear un nuevo alquiler si el turismo est� disponible.
	public void openAlquiler(Cliente cliente, Turismo turismo) {
		int posicion = 0;
		boolean posicionOpen = false;

		for (int i = 0; i < alquileres.length; i++) {
			if (alquileres[i] == null && alquileres[i].getTurismo().getDisponible()) {
				posicionOpen = true;
				posicion = i;
			} else {
				throw new ExcepcionAlquilerVehiculos("El turismo no est� disponible.");
			}
		}

		if (posicionOpen)
			alquileres[posicion] = new Alquiler(cliente, turismo);
	}

	// M�todo para cerrar un alquiler
	public void closeAlquiler(Cliente cliente, Turismo turismo) {
		int posicion = 0;
		boolean posicionClose = false;

		for (int i = 0; i < alquileres.length; i++) {
			if (alquileres[i].getCliente() == cliente && alquileres[i].getTurismo() == turismo) {
				posicionClose = true;
				posicion = i;
			}
		}

		if (posicionClose)
			alquileres[posicion].close();
	}
}
