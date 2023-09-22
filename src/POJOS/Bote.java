package POJOS;

import java.util.ArrayList;
import java.util.Arrays;

import ENUM.Zona;

public class Bote {
	
	private Integer identificacion;
	private Integer numeroPlazas;
	private Zona zonaBarco;
	private ArrayList<Persona> arrayPersonas;
	
	private static Integer contador = 0;
	private static Integer id = 0;
	
	public Bote() {
		
		this.arrayPersonas = new ArrayList<Persona>();
		id++;
		this.identificacion = id;
		this.numeroPlazas = 10;
		if(contador>=Zona.values().length) contador = 0;
		this.zonaBarco = Zona.values()[contador];
		contador++;
		
	}

	public Integer getIdentificacion() {
		return identificacion;
	}

	public Integer getNumeroPlazas() {
		return numeroPlazas;
	}

	public Zona getZonaBarco() {
		return zonaBarco;
	}
	
	

	public void setZonaBarco(Zona zonaBarco) {
		this.zonaBarco = zonaBarco;
	}

	public static Integer getId() {
		return id;
	}

	public ArrayList<Persona> getArrayPersonas() {
		return arrayPersonas;
	}

	@Override
	public String toString() {
		return "Bote Nº" + this.identificacion + ": Numero de Plazas - " + this.numeroPlazas + "\nZona: " + this.zonaBarco.name() + " / Se accede por las escaleras " + Arrays.deepToString(this.zonaBarco.escaleras);
	}

}
