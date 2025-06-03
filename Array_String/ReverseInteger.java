
//7. Reverse Integer

public class ReverseInteger {
    public int reverse(int x) {
        int result  = 0;

        while( x != 0){
            int digit = x % 10;
            x /= 10;

            if (result >= Integer.MAX_VALUE / 10 ) return 0; // Overflow
            if ( result <= Integer.MIN_VALUE / 10 ) return 0; // Underflow

            result = result * 10 + digit;

        }

        return  result;
    }

    public static void main(String[] args){
        ReverseInteger solution = new ReverseInteger();

        int x1 = 123;
        System.out.println("Original number: " + x1);
        System.out.println("Reversed number: " + solution.reverse(x1));

        int x2 = -123;
        System.out.println("\nOriginal number: " + x2);
        System.out.println("Reversed number: " + solution.reverse(x2));

        int x3 = 120;
        System.out.println("\nOriginal number: " + x3);
        System.out.println("Reversed number: " + solution.reverse(x3));

    }
}
