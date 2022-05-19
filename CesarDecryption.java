import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

public class CesarDecryption {
    private static char[] abcArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static char[] pwArray1;
    private static List<String> pwDecryptedList = new ArrayList<String>();
    private static int key = 0;
    private static int positionABC = 0;
    public static void main(String[] args) {
        System.out.println("------Program Start------");
        
        decrypt(inputReader());
        decryptList(pwDecryptedList);

        
        System.out.println("------Programm End------");
        
    }

    //method to read in the encrypted text 
    public static char[] inputReader(){
        System.out.println("Type in your encrypted text");
        String reader = System.console().readLine();
        reader.replace(" ", "");
        String input = reader.toLowerCase();
        pwArray1 = input.toCharArray();
        
        return pwArray1;
    }

    //method to decrypt text
    public static void decrypt(char[] encryptedText){
         //StringBuilder helps to build a string letter by letter
         StringBuilder pwDecrypted = new StringBuilder(); 
        while(key < 26)
        {
            for(int i = 0; i < pwArray1.length; i++)
            {
                char pwBuchstabe = pwArray1[i];
                for(int j = 0; j < abcArray.length; j++)
                {               
                    char abcBuchstabe = abcArray[j];
                    if(pwBuchstabe == abcBuchstabe)
                    {
                        positionABC = j + key;
                        if(positionABC > abcArray.length - 1)
                        {
                            positionABC = positionABC % abcArray.length;
                        }

                        //System.out.println("found it " + pwBuchstabe + " = " + abcBuchstabe);
                        pwDecrypted.append(abcArray[positionABC]); //StringBuilder
                    }
                }
            }
            pwDecryptedList.add(pwDecrypted.toString());
            pwDecrypted.setLength(0);
            key++;
        }

    }
    
    //print decrypted List on consol
    public static void decryptList(List<String>list){
        System.out.println("Passwort Länge " + pwArray1.length);
        int count = 0;
        for (String string : pwDecryptedList) {
            System.out.println("Nr. " + count + ": " + string);
            count++;
        }
    }
}
                