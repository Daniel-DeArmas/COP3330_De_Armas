import java.util.Scanner;

public class Encrypter {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a 4-digit number to be Encrypted. ");
        String Value = scan.next();
        String encryptedValue = Encrypter.Encrypt(Value);
        System.out.println("Encrypted:");
        System.out.println(encryptedValue);

        System.out.println("Enter a 4-digit number to be Decrypted. ");
        Value = scan.next();
        String decryptedValue = Decrypter.Decrypt(Value);
        System.out.println("Decrypted:");
        System.out.println(decryptedValue);
    }

    public static String Encrypt(String str){
        String x = "";
        int[] intArray = new int[str.length()];

        Encrypter.stringToArrayDigitEncrypt(intArray,str);

        Encrypter.arrayPositionSwapped(intArray,0,2);

        Encrypter.arrayPositionSwapped(intArray,1,3);

        x=Encrypter.arrayToString(intArray,str,x);

        return x;
    }

    public static void arrayPositionSwapped(int intArray[],int a, int b){
        int temp = intArray[a];
        intArray[a] = intArray[b];
        intArray[b] = temp;
    }

    public static String arrayToString(int intArray[],String str,String x){
        for (int i = 0; i < str.length(); i++) {
            x = x + intArray[i];
        }
        return x;
    }

    public static void stringToArrayDigitEncrypt(int intArray[],String str){
        for (int i = 0; i < str.length(); i++) {
            //intArray[i] = str.substring(i,i+1);
            intArray[i] = (Character.digit(str.charAt(i),10)+7)%10;
            //System.out.print(intArray[i]);
        }
    }

    public static void stringToArrayDigitDecrypt(int intArray[],String str){
        for (int i = 0; i < str.length(); i++) {
            //intArray[i] = str.substring(i,i+1);
            intArray[i] = (Character.digit(str.charAt(i),10)+3)%10;
            //System.out.print(intArray[i]);
        }
    }
}
