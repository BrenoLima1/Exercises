public class PrimeNumber {

    public static boolean isPrimeNumber(int number){
        if (number <= 1) {
            return false;
        }
            for(int i = 2; i <= Math.sqrt(number); i++){
                if(number % i == 0){
                    return false;
                }
            }

        return true;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i);
            }
        }

    }
}
