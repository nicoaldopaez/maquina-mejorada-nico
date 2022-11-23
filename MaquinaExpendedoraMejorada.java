public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //Muestra la cantidad de billetes vendidos
    private int numeroBilletesVendidos;
    //Permite elegir billete con o sin premio
    private boolean tipoMaquina;
    //N�mero m�ximo de billetes a imprimir
    private int cantidadMaximaBilletes;
    
    

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino,boolean conPremio, int cantidadBilletes ) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        tipoMaquina = conPremio;
        cantidadMaximaBilletes = cantidadBilletes;
    }
    
    /**
     * Segundo constructor de la maquina mejorada
     */
    public MaquinaExpendedoraMejorada(boolean conPremio) {
        precioBillete = 100;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Leon";
        estacionDestino = "Murcia";
        numeroBilletesVendidos = 0;
        tipoMaquina = conPremio;
    }
    
    /**
     * Vac�a el dinero de la m�quina
     */
    public int vaciarDineroDeLaMaquina (){
        int vaciarDineroDeLaMaquina = balanceClienteActual + totalDineroAcumulado;
        
        
        if (balanceClienteActual >0){
            vaciarDineroDeLaMaquina = -1;
        }
        else {
            totalDineroAcumulado = 0;
        }
        return vaciarDineroDeLaMaquina;
           
    }
    
    /**
     * Devuelve el n�mero de billetes vendidos.
     */
    public int getNumeroBilletesVendidos() {
        return numeroBilletesVendidos;
    }
    
    public void imprimirNumeroBilletesvendidos() {
        System.out.println ("El n�mero de billetes vendidos es: " + numeroBilletesVendidos);
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroBilletesVendidos >= cantidadMaximaBilletes){
            System.out.println ("Has superado el m�ximo de billetes");
        }
        else{
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = (precioBillete - balanceClienteActual);
        if (numeroBilletesVendidos >= cantidadMaximaBilletes){
            System.out.println ("Has superado el m�ximo de billetes");
        }
        
        else{
            if (cantidadDeDineroQueFalta <= 0) {
                numeroBilletesVendidos += 1;
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();   
                if (tipoMaquina == true){
                    if(numeroBilletesVendidos %4 == 0){
                       System.out.println("Te has llevado un premio!!"); 
                    }
                }
    
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
            }
            else {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                    
            }                
        }
        
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }
}
