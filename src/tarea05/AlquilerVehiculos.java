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

}
