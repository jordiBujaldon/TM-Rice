import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe principal que mostra els diferents resultats
 * de la codificació Rice
 *
 * @author Sergio Lopez
 * @author Jordi Bujaldón
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Exercici b):");

        for (int i = -1023; i < 1024; i++) {
            String result = encodeRiceWithM(i, 32);
            System.out.println(i + " = " + result + " | total bits = " + result.replace(" ", "").length());
        }

        System.out.println();
        System.out.println("============================");
        System.out.println("Exercici d):");

        Map<Integer, Integer> values = new HashMap<>();
        int value = 999;
        int startRang = 1024;

        for (int i = 1; i < 24; i++) {
            int M = 0;
            for (int j = -1023; j < 1024; j++){
                M = (int) Math.pow(2, i);
                String result = encodeRiceWithM(j, M);
                if (value > result.replace(" ", "").length()) {
                    startRang = j;
                    value = result.replace(" ", "").length();
                }
            }
            System.out.println("M: " + M + " = minim " + value + " bits, amb rang l'inici de rang negatiu " + startRang);
            value = 999;
            startRang = 1024;
        }
    }

    /**
     * Mètode que fa la codificació Rice amb un M de 256
     *
     * @param N Número a codificar
     * @return El resultat en binari formatejat
     */
    private static String encodeRiceWithM(int N, int M) {
        StringBuilder result = new StringBuilder();
        int Q = Math.abs(N) / M;
        int R = Math.abs(N) % M;
        int sign = (N > 0) ? 1 : 0;

        result.append(sign).append(" ");

        for (int i = 0; i < Q; i++) {
            result.append("1");
        }
        result.append("0").append(" ");

        int numOfRBits = (int) (Math.log(256) / Math.log(2));
        String RBits = Integer.toBinaryString(R);
        if (RBits.length() < numOfRBits) {
            int remainingBits = numOfRBits - RBits.length();
            for (int i = 0; i < remainingBits; i++) {
                result.append("0");
            }
        }
        result.append(RBits);

        return result.toString();
    }
}