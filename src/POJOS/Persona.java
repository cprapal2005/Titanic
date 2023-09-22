package POJOS;

import java.sql.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ENUM.Pais;
import ENUM.Zona;

public abstract class Persona implements Comparable<Persona> {

	private String dni, nombre;
	private Pais pais;
	private Zona zona;
	private boolean minusvalia;
	private Date fechaNacimiento;
	
	private Random rd = new Random();
	
	@SuppressWarnings("deprecation")
	public Persona() {
		
		this.dni = DNI.generaDNIAleatorio();
		this.nombre = NombresAleatorios.generarNombresAleatorios(1)[0];
		this.pais = Pais.randomPais();
		this.zona = Zona.randomZona();
		this.minusvalia = rd.nextBoolean();
		this.fechaNacimiento = randomDate(new Date(30, 1, 1), new Date(121, 1, 1));
		
	}
	
	
	
	public String getDni() {
		return dni;
	}



	public String getNombre() {
		return nombre;
	}



	public Pais getPais() {
		return pais;
	}



	public Zona getZona() {
		return zona;
	}


	
	

	public void setZona(Zona zona) {
		this.zona = zona;
	}



	public boolean isMinusvalia() {
		return minusvalia;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	private static Date randomDate(Date startInclusive, Date endExclusive) {
		ThreadLocalRandom r =ThreadLocalRandom.current();
	    return new Date(r.nextLong(startInclusive.getTime(), endExclusive.getTime()));
	}

	@Override
	public String toString() {
		return "DNI = " + dni + " | Nombre = " + nombre + " | Pais = " + pais + " | Minusvalia = " + minusvalia + " | Zona = " + zona + " | Fecha Nacimiento = " + fechaNacimiento;
	}
	
	public int compareTo(Persona persona) {
	      return this.nombre.compareTo(persona.nombre);
	   }
	
	
	
}
