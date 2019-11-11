package applications.algorithms;

/** Category: Algorithms
 * ID: Example19
 * Description: Find binary representation of an integer
 * Taken From:
 * Details:
 * TODO
 */
public class Example19 {

    public static String reverse(String s){

        int middle = s.length() >> 1;

        StringBuilder builder = new StringBuilder(s);

        for(int i=0; i<middle; ++i){
            char tmp = s.charAt(i);
            builder.setCharAt(i, s.charAt(s.length() -i -1));
            builder.setCharAt(s.length() -i -1, tmp);
        }

        return builder.toString();
    }

    public static String complement(String s){

        StringBuilder builder = new StringBuilder(s);

        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == '0'){
                builder.setCharAt(i, '1');
            }
            else{
                builder.setCharAt(i, '0');
            }
        }

        return builder.toString();
    }

    public static String addOne(String s){

        StringBuilder builder = new StringBuilder(s);
        builder.setCharAt(s.length()-1, '1');
        return builder.toString();
    }

    public static String binaryRepresentation(int n){

        boolean negative = false;
        if( n < 0){
            n = Math.abs(n);
            negative = true;
        }

        StringBuilder builder = new StringBuilder();

        while( n != 0){
              int i = n % 2;
              builder.append(i);
              n /= 2;
        }

        if(negative){
            // get the complement
            String s = Example19.complement(Example19.reverse(builder.toString()));

            // add 1 and return the string
            return Example19.addOne(s);
        }

        return Example19.reverse(builder.toString());
    }

    public static void main(String[] args){

        System.out.println("Binary representation of 37: "+Example19.binaryRepresentation(37));
        System.out.println("Binary representation of 13: "+Example19.binaryRepresentation(13));
        System.out.println("Binary representation of 17: "+Example19.binaryRepresentation(17));
        System.out.println("Binary representation of -17: "+Example19.binaryRepresentation(-17));
    }
}
