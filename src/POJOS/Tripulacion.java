package POJOS;

import ENUM.Responsabilidad;

public class Tripulacion extends Persona {

	private Responsabilidad nivelResponsabilidad;
	
	public Tripulacion() {
		
		super();
		this.nivelResponsabilidad = Responsabilidad.randomResponsabilidad();
		
	}

	public Responsabilidad getNivelResponsabilidad() {
		return nivelResponsabilidad;
	}

	public void setNivelResponsabilidad(Responsabilidad nivelResponsabilidad) {
		this.nivelResponsabilidad = nivelResponsabilidad;
	}

	@Override
	public String toString() {
		return "Tripulacion: Responsabilidad = " + nivelResponsabilidad + " | " + super.toString();
	}
	
	
	
}
