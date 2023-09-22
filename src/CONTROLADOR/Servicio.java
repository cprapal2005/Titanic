package CONTROLADOR;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import DAO.DAOBotes;
import DAO.DAOPersonas;
import ENUM.Responsabilidad;
import POJOS.Bote;
import POJOS.Pasajero;
import POJOS.Persona;
import POJOS.Tripulacion;

public class Servicio {

		private static Servicio servicio;
		
		private ArrayList<Persona> arrayPersonas;
		public Bote[] vectorBotes;
		
		private Servicio() {
			
			arrayPersonas = DAOPersonas.getInstance().getPersonas();
			vectorBotes = DAOBotes.getInstance().getBotes(arrayPersonas);
			
			
		}
		
		public static Servicio getInstance() {
			
			if(servicio == null) servicio = new Servicio();
			
			return servicio;
			
		}
		
		public void gestionarBotes() throws InterruptedException {
			
			for (int i = 0; i < vectorBotes.length; i++) {
				
				System.out.println("\n" + vectorBotes[i].toString() + "\n");
				
				Thread.sleep(3000);
				
				for (int j = 0; j < vectorBotes[i].getNumeroPlazas(); j++) {
					
					gestionNiñosPequeños(i);
					
				}
				
				for (int j = 0; j < vectorBotes[i].getNumeroPlazas(); j++) {
					
					gestionAncianos(i);
						
				}
				
				for (int j = 0; j < vectorBotes[i].getNumeroPlazas(); j++) {
					
					gestionMinusvalidos(i);
					
				}
				
				for (int j = 0; j < vectorBotes[i].getNumeroPlazas(); j++) {
					
					gestionAdultos(i);
					
				}
				
				for (int j = 0; j < vectorBotes[i].getNumeroPlazas(); j++) {
					
					gestionTripulacion(i);
					
				}
				
				for (int j = 0; j < vectorBotes[i].getArrayPersonas().size(); j++) {
					
					System.out.println(vectorBotes[i].getArrayPersonas().get(j));
					
					Thread.sleep(1500);
					
				}
					
			}
				
		}
		
		private void gestionNiñosPequeños(Integer i) {
			
			ArrayList<Persona> arrayFamilia = new ArrayList<Persona>();
			
			for (int k = 0;k < this.arrayPersonas.size() ; k++) {
				
				if(Period.between(this.arrayPersonas.get(k).getFechaNacimiento().toLocalDate(), LocalDate.now()).getYears()<18) {
					
					Pasajero niñoEncontrado = (Pasajero) this.arrayPersonas.get(k);
					
					for (int k2 = 0; k2 < this.arrayPersonas.size(); k2++) {
						
						if(k2!=k && this.arrayPersonas.get(k2) instanceof Pasajero) {
							
							Pasajero posibleFamiliar = (Pasajero) this.arrayPersonas.get(k2);
							
							if (niñoEncontrado.getNumeroHabitacion()==posibleFamiliar.getNumeroHabitacion()) {
								posibleFamiliar.setZona(niñoEncontrado.getZona());
								arrayFamilia.add(posibleFamiliar);
							}
								
						}
						
					}
					
					arrayFamilia.add(this.arrayPersonas.get(k));
					
					if(arrayFamilia.size()>1 && (arrayFamilia.size()+vectorBotes[i].getArrayPersonas().size())<=vectorBotes[i].getNumeroPlazas() && niñoEncontrado.getZona()==vectorBotes[i].getZonaBarco()) {
						
						for (int k2 = 0; k2 < arrayFamilia.size(); k2++) {
							
							vectorBotes[i].getArrayPersonas().add(arrayFamilia.get(k2));
							
						}
						
						k = this.arrayPersonas.size();
						
						arrayFamilia = new ArrayList<Persona>();
						
						for (int k2 = 0; k2 < vectorBotes[i].getArrayPersonas().size(); k2++) {
							
							for (int k3 = 0; k3 < this.arrayPersonas.size(); k3++) {
								
								if(vectorBotes[i].getArrayPersonas().get(k2).equals(this.arrayPersonas.get(k3))) this.arrayPersonas.remove(k3);
								
							}
							
						}
						
					}
					
					else arrayFamilia = new ArrayList<Persona>();
					
				}
				
			}
				
		}
		
		private void gestionAncianos(Integer i) {
			
			for (Persona persona : arrayPersonas) {
				
				if(Period.between(persona.getFechaNacimiento().toLocalDate(), LocalDate.now()).getYears()>79 && persona instanceof Pasajero) {
					
					if(vectorBotes[i].getArrayPersonas().size()<vectorBotes[i].getNumeroPlazas() && vectorBotes[i].getZonaBarco()==persona.getZona()) {
						
						vectorBotes[i].getArrayPersonas().add(persona);
						
					}
				
				}
					
			}
			
			for (int k2 = 0; k2 < vectorBotes[i].getArrayPersonas().size(); k2++) {
				
				for (int k3 = 0; k3 < this.arrayPersonas.size(); k3++) {
					
					if(vectorBotes[i].getArrayPersonas().get(k2).equals(this.arrayPersonas.get(k3))) this.arrayPersonas.remove(k3);
					
				}
				
			}
			
		}
		
		private void gestionMinusvalidos(Integer i) {
			
			for (Persona persona : arrayPersonas) {
				
				if(persona.isMinusvalia()==true && persona instanceof Pasajero) {
					
					if(vectorBotes[i].getArrayPersonas().size()<vectorBotes[i].getNumeroPlazas() && vectorBotes[i].getZonaBarco()==persona.getZona()) {
						
						vectorBotes[i].getArrayPersonas().add(persona);
						
					}
				
				}
					
			}
			
			for (int k2 = 0; k2 < vectorBotes[i].getArrayPersonas().size(); k2++) {
				
				for (int k3 = 0; k3 < this.arrayPersonas.size(); k3++) {
					
					if(vectorBotes[i].getArrayPersonas().get(k2).equals(this.arrayPersonas.get(k3))) this.arrayPersonas.remove(k3);
					
				}
				
			}
			
		}
		
		private void gestionAdultos(Integer i) {
			
			for (Persona persona : arrayPersonas) {
				
				if(persona instanceof Pasajero) {
					
					if(vectorBotes[i].getArrayPersonas().size()<vectorBotes[i].getNumeroPlazas() && vectorBotes[i].getZonaBarco()==persona.getZona()) {
						
						vectorBotes[i].getArrayPersonas().add(persona);
						
					}
				
				}
					
			}
			
			for (int k2 = 0; k2 < vectorBotes[i].getArrayPersonas().size(); k2++) {
				
				for (int k3 = 0; k3 < this.arrayPersonas.size(); k3++) {
					
					if(vectorBotes[i].getArrayPersonas().get(k2).equals(this.arrayPersonas.get(k3))) this.arrayPersonas.remove(k3);
					
				}
				
			}
			
		}
		
		private void gestionTripulacion(Integer i) {
			
			for (int j = 0; j < Responsabilidad.values().length; j++) {
				
				for (Persona persona : arrayPersonas) {
					
					if(persona instanceof Tripulacion && ((Tripulacion) persona).getNivelResponsabilidad()==Responsabilidad.values()[j]) {
						
						if(vectorBotes[i].getArrayPersonas().size()<vectorBotes[i].getNumeroPlazas() && vectorBotes[i].getZonaBarco()==persona.getZona()) {
							
							vectorBotes[i].getArrayPersonas().add(persona);
							
						}
					
					}
						
				}
				
				for (int k2 = 0; k2 < vectorBotes[i].getArrayPersonas().size(); k2++) {
					
					for (int k3 = 0; k3 < this.arrayPersonas.size(); k3++) {
						
						if(vectorBotes[i].getArrayPersonas().get(k2).equals(this.arrayPersonas.get(k3))) this.arrayPersonas.remove(k3);
						
					}
					
				}
				
			}
			
		}
		
}
