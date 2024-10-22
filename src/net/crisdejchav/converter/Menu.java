import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Map<Integer, Runnable> actions;
    private Map<Integer, String> enuMap;

    private int[] options = {0, 0};
    private int index = 0;
    private Scanner sc;  // Declarar el Scanner como un campo de clase

    public Menu() {

        actions = new HashMap<>();
        actions.put(1, this::convertCOP);
        actions.put(2, this::convertARS);
        actions.put(3, this::convertBRL);
        actions.put(4, this::convertCNY);
        actions.put(5, this::convertJPY);
        actions.put(6, this::convertRUB);

        enuMap = new HashMap<>();
        enuMap.put(1, "COP");
        enuMap.put(2, "ARS");
        enuMap.put(3, "BRL");
        enuMap.put(4, "CNY");
        enuMap.put(5, "JPY");
        enuMap.put(6, "RUB");

        sc = new Scanner(System.in);  // Inicializar el Scanner
    }

    public void showMenu(){
        System.out.println("1) Peso Colombiano");
        System.out.println("2) Peso Argentino");
        System.out.println("3) Real Brasileño");
        System.out.println("4) Yuan Chino");
        System.out.println("5) Yen Japones");
        System.out.println("6) Rublo Ruso");
        System.out.println("0) Salir.");
    }

    public void convertCOP() {
        System.out.println("Has seleccionado Peso Colombiano.");
        options[index] = 1;
    }

    public void convertARS() {
        System.out.println("Has seleccionado Peso Argentino.");
        options[index] = 2;
    }

    public void convertBRL() {
        System.out.println("Has seleccionado Real Brasileño.");
        options[index] = 3;
    }

    public void convertCNY() {
        System.out.println("Has seleccionado Yuan Chino.");
        options[index] = 4;
    }

    public void convertJPY() {
        System.out.println("Has seleccionado Yen Japones.");
        options[index] = 5;
    }

    public void convertRUB() {
        System.out.println("Has seleccionado Rublo Ruso.");
        options[index] = 6;
    }

    public String[] start() {
        int option;

        System.out.println("Bienvenido al conversor de moneda\nEscribe el numero de la divisa que deseas convertir\n");
        showMenu();
        
        index = 0;
        System.out.println("Ingresa un numero para seleccionar una opcion:");
        option = sc.nextInt();  // Reutiliza el Scanner de la clase
        
        if (option == 0) {
            System.out.println("Saliendo del programa...");
            return null;
        }

        Runnable action = actions.get(option);
        if (action != null) {
            action.run();
        } else {
            System.out.println("Opción inválida, intenta de nuevo.");
        }
        
        index++;
        System.out.println("Ingresa un numero para seleccionar otra opcion:");
        option = sc.nextInt();

        action = actions.get(option);
        if (action != null) {
            action.run();
        } else {
            System.out.println("Opción inválida, intenta de nuevo.");
        }

        String[] result = {enuMap.get(options[0]), enuMap.get(options[1])};
        return result;
    }

    public double getValue() {
        System.out.println("Ingresa el valor a convertir:");
        return sc.nextDouble();  // Reutiliza el mismo Scanner
    }
}
