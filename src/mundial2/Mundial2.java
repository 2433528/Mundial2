/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mundial2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Mundial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int cantVotos = 0;
        Map<String, Integer> lugar = new HashMap<>();
        Integer puntos = 0;
        String nombreLugar = "";

        cantVotos = sc.nextInt();
        sc.nextLine();
        while (cantVotos != 0) {
            for (int i = 1; i <= cantVotos; i++) {
                nombreLugar = sc.next();
                if (lugar.containsKey(nombreLugar)) {
                    puntos = lugar.get(nombreLugar) + 1;
                    lugar.put(nombreLugar, puntos);
                } else {
                    lugar.put(nombreLugar, 1);
                }
            }
            Integer maxVotos = Collections.max(lugar.values());
            Integer repetidos = Collections.frequency(lugar.values(), maxVotos);
            if (repetidos > 1) {
                System.out.println("EMPATE");
            } else {
                for (Map.Entry<String, Integer> sedes : lugar.entrySet()) {
                    if (Objects.equals(sedes.getValue(), maxVotos)) {
                        System.out.println(sedes.getKey());
                    }
                }
            }
            lugar.clear();
            cantVotos = sc.nextInt();
            sc.nextLine();
        }
    }
    
}
