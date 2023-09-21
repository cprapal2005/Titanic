package ENUM;

import java.util.Random;

public enum Pais {

	ESPAÑA, FRANCIA, ITALIA, ALEMANIA, INGLATERRA;
	
	private static final Random PRNG = new Random();

    public static Pais randomPais()  {
    	Pais[] paises = values();
        return paises[PRNG.nextInt(paises.length)];
    }
	
}
