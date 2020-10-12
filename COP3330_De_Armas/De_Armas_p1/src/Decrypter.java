public class Decrypter {

    public static String Decrypt(String str){
        String x = "";
        int[] intArray = new int[str.length()];

        Encrypter.stringToArrayDigitDecrypt(intArray,str);

        Encrypter.arrayPositionSwapped(intArray,0,2);

        Encrypter.arrayPositionSwapped(intArray,1,3);

        x=Encrypter.arrayToString(intArray,str,x);

        return x;
    }
}
