package POJOS;

import java.time.LocalDate;
import java.time.Period;

public class Pasajero extends Persona {
	
	private Integer numeroHabitacion;
	
	private static Integer contador = 1;
	
	public static boolean flag = false;
	
	public Pasajero() {
		
		super();
		
		if (flag==false) {
		
			this.numeroHabitacion = Pasajero.contador.intValue();
			
			if(Period.between(this.getFechaNacimiento().toLocalDate(), LocalDate.now()).getYears()>=18) {
				
				contador++;
				
			}
		}
		
	}

	public Integer getNumeroHabitacion() {
		return numeroHabitacion;
	}

	@Override
	public String toString() {
		return "Pasajero: Numero de Habitacion = " + numeroHabitacion + " | " + super.toString();
	}
	

}
