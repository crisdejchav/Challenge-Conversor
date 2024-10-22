import java.io.IOException;
import java.util.HashMap;

import services.ApiConection;

public class Principal {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ApiConection con = new ApiConection();
        HashMap<String, Double> currencies;
        double value;
        do{
        String[] divisas = menu.start();
        if (divisas == null){
            break;
        }
        value = menu.getValue();
        try {
            
            currencies = con.getCurrencyOf(divisas[0]);
        } catch (IOException | InterruptedException e) {
            currencies = new HashMap<>();
            System.out.println("Error en la Api.");
        }
        System.out.println("El resultado de la conversion: "+divisas[0]+" => "+divisas[1]+ " de: $"+value+" es: "+(currencies.get(divisas[1])*value));
    }while(true);
    }
    
}
