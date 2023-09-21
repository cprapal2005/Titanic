package ENUM;

import java.util.Random;

public enum Responsabilidad {

	MUY_BAJA, BAJA, MEDIA, ALTA, MUY_ALTA;
	
	private static final Random PRNG = new Random();
	
	public static Responsabilidad randomResponsabilidad()  {
		Responsabilidad[] responsabilidad = values();
        return responsabilidad[PRNG.nextInt(responsabilidad.length-1)];
    }
	
}
