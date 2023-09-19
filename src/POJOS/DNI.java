package POJOS;

public class DNI {

	//Atributos
    private int numeroDNI;
    private char letraDNI;
    private String DNIcompleto;

    //Constantes
    private char letrasNIF[]={'T', 'R', 'W', 'A', 'G', 'M', 'Y', 
                                'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 
                                'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    
    private static char letrasNIE[]={'X', 'Y', 'Z'};
    
    private static char letrasCIF[]={'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','U','V','W'};
    private static boolean NUMERO_O_LETRAS[]={true,true,false,true,true,true,true,true,true,false,false,false,false,false,false,false,false,true,true,false}; //True = numero, false = letra
    private static char letrasCIFFINAL[]={'A','B','C','D','E','F','G','H','I','J'};
    
    private final int DIVISOR=23;
    public DNI(){
        this.generarDNIAleatorio();
    }
    
    public DNI(int numeroDNI){
        
        if(cuentaCifras(numeroDNI)>=7 && cuentaCifras(numeroDNI)<=8){
            this.numeroDNI=numeroDNI;
            letraNIF();
            completarDNI();
        }else{
            
            numeroDNI=0;
            letraDNI=' ';
            DNIcompleto="";
            
        }
        
    }
    
    public DNI(String DNIcompleto){
        
        if(comprobarDNI(DNIcompleto)){
            
            numeroDNI=Integer.parseInt(DNIcompleto.substring(0, DNIcompleto.length()-1));
            letraDNI=DNIcompleto.charAt(DNIcompleto.length()-1);
            completarDNI();
            
        }else{
            
            numeroDNI=0;
            letraDNI=' ';
            DNIcompleto="";
        }
        
    }
    
    private void generarDNIAleatorio(){
        
        numeroDNI=generaNumeroAleatorio(1000000,100000000);
        
        letraNIF();
        
        completarDNI();
        
    }
    
    
    private void completarDNI(){
        
        DNIcompleto=String.valueOf(numeroDNI)+letraDNI;
        
    }
    
    
    private void letraNIF(){
        
        if(cuentaCifras(numeroDNI)>=7 && cuentaCifras(numeroDNI)<=8){
            

            int res=numeroDNI-(numeroDNI/DIVISOR*DIVISOR);

            letraDNI=letrasNIF[res];
        }else{
        }	
     }
    
    private boolean comprobarDNI(String DNI){
        
        if(DNI.length()>=8 && DNI.length()<=9){
           try{
               
                boolean correcto=false;
                
                int dni=Integer.parseInt(DNI.substring(0, DNI.length()-1));
                int res=dni-(dni/DIVISOR*DIVISOR);
          
                String DNICalculado=String.valueOf(dni)+letrasNIF[res];
                if(DNICalculado.replace('0', ' ').trim().equals(DNI.replace('0', ' ').trim())){
                    correcto=true;
                }
                
                return correcto;
        }catch(NumberFormatException e){
            return false;
        }
       }else{
           return false;
       }
        
    }
    
    /**
     * Genera un numero aleatorio entre dos numeros. NOTA: se incluye el minimo, pero no el maximo
     * @param minimo
     * @param maximo
     * @return numero entre minimo y maximo
     */
    private static int generaNumeroAleatorio(int minimo, int maximo){
        
        int num=(int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
    
    public int getNumeroDNI() {
        return numeroDNI;
    }

    public char getLetraDNI() {
        return letraDNI;
    }

    public String getDNIcompleto() {
        return DNIcompleto;
    }
    
    //metodos estaticos
    
    private static char letraNIF(int DNI){
        
        if(cuentaCifras(DNI)>=7 && cuentaCifras(DNI)<=8){
            final int divisor=23;

            int res=DNI-(DNI/divisor*divisor);

            char letrasNIF[]={'T', 'R', 'W', 'A', 'G', 'M', 'Y', 
                              'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 
                              'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

            return letrasNIF[res];
        }else{
            return 0;
        }
        
		
     }
    
    
    //Metodos estaticos
    
    private static int cuentaCifras(int num){
        int contador=0;
        if(num==0){
            return 1;
        }else if(num>0){
             //bucle que cuenta las cifras
            while (num>0){
                num=(int)Math.floor(num/10);
                contador+=1;
            }
            return contador;
        }else{
            while (num<0){
                num=(int)Math.floor(num/10);
                contador+=1;
            }
            return contador;
        }
    }
    
    private static char devolverLetraNIF(String DNI){
        
       if(DNI.length()>=7 && DNI.length()<=8){
           try{
                final int divisor=23;
                int dni=Integer.parseInt(DNI);
                int res=dni-(dni/divisor*divisor);

                char letrasNIF[]={'T', 'R', 'W', 'A', 'G', 'M', 'Y', 
                                  'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 
                                  'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

                return letrasNIF[res];
        }catch(NumberFormatException e){
            return ' ';
        }
       }else{
           return ' ';
       }
       
    }
    
    public static String generaDNIAleatorio(){
        
        int numero=generaNumeroAleatorio(1000000,100000000);
        
        char letra=letraNIF(numero);
        
        if(cuentaCifras(numero)==7){
            return String.valueOf("0"+numero)+letra;
        }else{
            return String.valueOf(numero)+letra;
        }
        
        
    }
    
    public static String[] generaDNIsAletorios(int numeroDNIs){
        
        String DNIs[]=new String[numeroDNIs];
        
        String dni;
        
        for(int i=0;i<DNIs.length;i++){
        
            do{
                
                dni=generaDNIAleatorio();
                
            }while(existeDocumento(DNIs,dni));
            
            DNIs[i]=dni;
            
        }
        
        return DNIs;
        
    }
    
    private static boolean existeDocumento(String[] documentos,String valor){
        
        boolean encontrado=false;
        
        for(int i=0;i<documentos.length && !encontrado;i++){
            
            if(documentos[i]!=null){
                if(documentos[i].equals(valor)){
                    encontrado=true;
                }
            }
            
        }
        
        return encontrado;
        
    }
	
}
