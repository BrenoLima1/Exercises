public class Triangle {
    public static void main(String[] args) {
        int altura = 5;

        for (int i = 1; i <= altura; i++) {
            // espaços à esquerda
            for (int j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            // asteriscos (2*i - 1)
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
