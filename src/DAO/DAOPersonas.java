package DAO;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import ENUM.Responsabilidad;
import POJOS.Pasajero;
import POJOS.Persona;
import POJOS.Tripulacion;

public class DAOPersonas {

	private static DAOPersonas dao;
	
	private final Integer NUMEROPASAJEROS = 10;
	
	private final Integer NUMEROTRIPULACION = 3;
	
	private DAOPersonas() {
		
	}
	
	private Map<Pasajero, Pasajero> getPasajeros() {
		
		Map<Pasajero, Pasajero> hashMapPasajeros = new HashMap<>();
		
		for (int i = 0; i < NUMEROPASAJEROS; i++) {
			
			Pasajero pasajero = new Pasajero();
			
			hashMapPasajeros.put(pasajero, pasajero);
			
		}
		
		Pasajero.flag = true;
		
		TreeMap<Pasajero, Pasajero> treeMapPasajeros = new TreeMap<>(hashMapPasajeros);
		
		return treeMapPasajeros;
		
	}
	
	private Map<Tripulacion, Tripulacion> getTripulacion() {
		
		Map<Tripulacion, Tripulacion> hashMapTripulacion = new HashMap<>();
		
		for (int i = 0; i < NUMEROTRIPULACION; i++) {
			
			Tripulacion tripulante = new Tripulacion();
			
			if(Period.between(tripulante.getFechaNacimiento().toLocalDate(), LocalDate.now()).getYears()>=18) hashMapTripulacion.put(tripulante, tripulante);
			
		}
		
		int numeroTripulantes = hashMapTripulacion.size();
		
		do {
			
			Tripulacion capitan = new Tripulacion();
			
			if(Period.between(capitan.getFechaNacimiento().toLocalDate(), LocalDate.now()).getYears()>=18) {
				capitan.setNivelResponsabilidad(Responsabilidad.MUY_ALTA);
				hashMapTripulacion.put(capitan, capitan);
			}
			
		} while (hashMapTripulacion.size()<=numeroTripulantes);
		
		TreeMap<Tripulacion, Tripulacion> treeMapTripulacion = new TreeMap<>(hashMapTripulacion);
		
		return treeMapTripulacion;
		
	}
	
	public static DAOPersonas getInstance() {
		
		if(dao==null) dao = new DAOPersonas();
		
		return dao;
		
	}
	
	public ArrayList<Persona> getPersonas() {
		
		ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();
		
		arrayPersonas.addAll(getPasajeros().values().stream().collect(Collectors.toList()));
		
		arrayPersonas.addAll(getTripulacion().values().stream().collect(Collectors.toList()));
		
		return arrayPersonas;
		
	}
	
	
	
}
