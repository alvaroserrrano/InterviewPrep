/*Java implementation to Divide two 
integers without using multiplication, 
division and mod operator*/
import java.io.*;

class divInt {
    //Function to divide 2 ints -->return floor value
    static int divide (int dividend, int divisor){
        //Calc sign
        int sign;
        if(dividend < 0 || divisor < 0 ){
            sign = -1;
        }else{
            sign = 1;
        }
        //Update ints to floor value
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        //Init quotient
        int quotient = 0;

        while(dividend >= divisor){
            dividend -= divisor;
            ++quotient;
        }
        return sign * quotient;
    }

    public static void main (String[] args){
        int a = 10; 
        int b = 3;
        System.out.println(divide(a, b));

        a = 43;
        b = -8;
        System.out.println(divide(a, b));
    }
}