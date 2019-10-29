package applications.algorithms;

/** Category: Algorithms
  * ID: FindNumberOfDigitsInInteger
  * Description: Find the number of digits in a given integer
  * Taken From:
  * Details:

  * We can get the number of digits contained in an integer by continuously
  * dividing with 10 as long as the number is greater than 0
*/
public class Example7
{

    public static void run(String[] args){

        int number = 100;
        int numberCopy = number;
        int count = 0;

        while(numberCopy > 0){
            count++;
            numberCopy /= 10;
        }

        System.out.println("Number of digits for "+number+" is: "+count);
    }

    public static void main(String[] args){

        Example7.run(args);
    }
}
