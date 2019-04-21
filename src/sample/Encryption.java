package sample;

public class Encryption {
    public static int low = 32;
    public static int high = 127;
    public static int ran = high-low;

    public static String encrypt(String input, int shift) {
        char[] newString = input.toCharArray();
        for (int i = 0; i < newString.length; i++) {
            //System.out.println("Old char val");
            //System.out.println(newString[i]+0);
            int newCharVal = (((newString[i]+ shift)-low)%(ran)+low);
            //System.out.println("New char val");
            //System.out.println(newCharVal);
            //System.out.println("New char:");
            char newChar = (char)newCharVal;
            //System.out.println(newChar);
            newString[i] = newChar;
        }
        //System.out.println(' '+0);

        return String.valueOf(newString);
    }

    public static String decrypt(String input, int shift){
        char[] newString = input.toCharArray();
        for (int i = 0; i < newString.length; i++) {
            //System.out.println("Old char val");
            //System.out.println(newString[i]+0);
            int newCharVal = (int)((newString[i]-shift -low +ran)%(ran)+low);
            //System.out.println("New char val");
            //System.out.println(newCharVal);
            char newChar = (char)newCharVal;
            //System.out.println("New char:");
           // System.out.println(newChar);
            newString[i] = newChar;
        }
        return String.valueOf(newString);
    }

}
