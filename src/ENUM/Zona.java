package ENUM;

import java.util.Random;

public enum Zona {

	PROA(new Integer[]{2,4,6}), POPA(new Integer[]{1,3,5}), BABOR(new Integer[]{8,10,12}), ESTRIBOR(new Integer[]{9,11,13});
	
	public final Integer[] escaleras;
	private static final Random PRNG = new Random();
	
	private Zona(Integer[] escaleras) {
		
		this.escaleras = escaleras;
		
	}

    public static Zona randomZona()  {
    	Zona[] zonas = values();
        return zonas[PRNG.nextInt(zonas.length)];
    }
	
}
