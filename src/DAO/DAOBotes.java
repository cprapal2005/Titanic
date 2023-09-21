package DAO;

import POJOS.Bote;

public class DAOBotes {

	private static DAOBotes dao;
	
	private Integer numeroBotes;
	
	private DAOBotes(Integer numeroBotes) {
		
		this.numeroBotes = numeroBotes;
		
	}
	
	public Bote[] getBotes() {
		
		if(numeroBotes<10) numeroBotes = 1;
		
		else numeroBotes = (numeroBotes/10) + 1;
		
		Bote[] vectorBotes = new Bote[numeroBotes];
		
		for (int i = 0; i < numeroBotes; i++) {
			
			vectorBotes[i] = new Bote();
			
		}
		
		return vectorBotes;
		
	}
	
	public static DAOBotes getInstance(Integer numeroBotes) {
		
		if(dao==null) dao = new DAOBotes(numeroBotes);
		
		return dao;
		
	}
	
}
