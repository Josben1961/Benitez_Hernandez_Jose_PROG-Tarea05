package tarea05;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alquiler {
	
	private Cliente cliente;
	private Turismo turismo;
	private Date fecha;
	private int dias;	
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private final int MS_DIA = 1000 * 60 * 60 * 24;
	private final double PRECIO_DIA = 30;
	
	
	// Constructor con dos parámetros
	public Alquiler(Cliente cliente, Turismo turismo) {
		this.cliente = cliente;
		this.turismo = turismo;
		fecha= new Date();
		dias = 0;
		turismo.setDisponible(false);
	}

	// Métodos getters
	public Cliente getCliente() {
		return cliente;
	}


	public Turismo getTurismo() {
		return turismo;
	}


	public Date getFecha() {
		return fecha;
	}


	public int getDias() {
		return dias;
	}
			
}
