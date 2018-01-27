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

	// Métodos getters
	public Turismo[] getTurismos() {
		return turismos;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public Alquiler[] getAlquileres() {
		return alquileres;
	}

	// Método get de Cliente con un parámetro (dni) para saber si existe este cliente.
	public Cliente getCliente (String dni) {
		int posicion = 0;
		boolean clienteDni = false;
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i].getDni().equals(dni)) {
				clienteDni = true;
				posicion = i;
			}
		}
		if(clienteDni) {
			return clientes[posicion];
		}else {
			return null;
		}
	
	}
	
	// Méetodo para agregar clientes
	public void addCliente(Cliente cliente) {
		int posicion = 0;
		boolean posicionArray = false;
		for (int i=0; i<clientes.length; i++) {
			if(clientes[i] == null){
				posicionArray = true;
				posicion = i;
			}else if (clientes[i].getDni().equals(cliente.getDni())) {
				throw new ExcepcionAlquilerVehiculos ("Este cliente ya existe.");
			}
		}
		if(posicionArray)
			clientes[posicion] = cliente;
		else
			throw new ExcepcionAlquilerVehiculos ("No se admiten más clientes.");
	}
}
