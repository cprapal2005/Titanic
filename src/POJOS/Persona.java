package POJOS;

import java.sql.Date;

import ENUM.Pais;
import ENUM.Zona;

public abstract class Persona {

	public String dni, nombre;
	public Pais pais;
	public Zona zona;
	public boolean minusvalia;
	public Date fechaNacimiento;
	
	public Persona() {
		
		this.dni = DNI.generaDNIAleatorio();
		this.nombre = NombresAleatorios.generarNombresAleatorios(1).toString();
		//this.pais; BUSCAR PAIS ALEATORIO
		
	}
	
	
}
