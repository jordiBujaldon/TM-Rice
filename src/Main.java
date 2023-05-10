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
            String result = encodeRiceWithM32(i);
            System.out.println(i + " = " + result + " | total bits = " + result.replace(" ", "").length());
        }

        System.out.println();
        System.out.println("============================");
        System.out.println("Exercici d):");

        /*
        for (int i = -1023; i < 1024; i++) {
            String result = encodeRiceWithM256(i);
            System.out.println(i + " = " + result + " | total bits = " + result.replace(" ", "").length());
        }
         */
    }

    /**
     * Mètode que fa la codificació Rice amb un M de 256
     *
     * @param N Número a codificar
     * @return El resultat en binari formatejat
     */
    private static String encodeRiceWithM32(int N) {
        StringBuilder result = new StringBuilder();
        int Q = Math.abs(N) / 32;
        int R = Math.abs(N) % 32;
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