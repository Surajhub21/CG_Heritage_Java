public class PrimeNumber {
    public static void main(String[] args) {
      int num = 10;
      System.out.print(PrimeChecker(num)?"Prime" : "Not Prime");
 
    }
    private static boolean PrimeChecker(int num){
      for(int i = 2 ; i*i<= num; i++){
        if(num % i == 0)
          return false;
      }
      return true;
    }
}