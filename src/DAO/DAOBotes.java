package DAO;

import java.util.ArrayList;

import ENUM.Zona;
import POJOS.Bote;
import POJOS.Persona;

public class DAOBotes {

	private static DAOBotes dao;
	
	private DAOBotes() {
		
	}
	
	public Bote[] getBotes(ArrayList<Persona> arrayPersonas) {
		
		Integer[] contPersonasZona = {0, 0, 0, 0};
		
		for (int i = 0; i < arrayPersonas.size(); i++) {
			
			switch (arrayPersonas.get(i).getZona()) {
			case PROA:
						contPersonasZona[0]++;
				break;
				
			case ESTRIBOR:
						contPersonasZona[1]++;
				break;
				
			case POPA:
						contPersonasZona[2]++;
				break;
				
			case BABOR:
						contPersonasZona[3]++;
				break;

			default:
				break;
			}
			
		}
		
		for (int i = 0; i < contPersonasZona.length; i++) {
					
			if(contPersonasZona[i]<10) contPersonasZona[i] = 1;
			
			else contPersonasZona[i] = (contPersonasZona[i]/10) + 1;
			
		}
		
		int numeroBotes = 0;
		
		for (int i = 0; i < contPersonasZona.length; i++) {
			
			numeroBotes+= contPersonasZona[i];
			
		}
		
		Bote[] vectorBotes = new Bote[numeroBotes];
		
		int cont = 0;
		
		for (int i = 0; i < numeroBotes; i++) {
			
			if(cont>=contPersonasZona.length) cont=0;
			
			if(contPersonasZona[cont]!=0) {
				
				Bote bote = new Bote();
				
				bote.setZonaBarco(Zona.values()[cont]);
				
				vectorBotes[i] = bote;
				
				contPersonasZona[cont]--;
				
				cont++;
				
			}
			
			else {
				cont++;
				i--;
			}
			
			
			
		}
		
		return vectorBotes;
		
	}
	
	public static DAOBotes getInstance() {
		
		if(dao==null) dao = new DAOBotes();
		
		return dao;
		
	}
	
}
