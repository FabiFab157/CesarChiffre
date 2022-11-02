import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

public class CesarDecryption {
    private static char[] abcArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static char[] pwArray;
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
    private static char[] inputReader(){
        boolean goOn = true;
        while(goOn == true)
        {
            //Read letters in and split them in parts
            System.out.println("Type in your encrypted text");
            String reader = System.console().readLine();
            reader.replace(" ", "");
            String input = reader.toLowerCase();

            pwArray = input.toCharArray();
            if(isNumber(pwArray) == false) //check if number contains
            {
                goOn = false;
                return pwArray = null;
            }
            goOn = false; //stops the loop
        }      
        return pwArray;
    }

    //method to decrypt text
    private static void decrypt(char[] encryptedText){
         //StringBuilder helps to build a string letter by letter
         StringBuilder pwDecrypted = new StringBuilder(); 
        while(key < 26)
        {
            for(int i = 0; i < pwArray.length; i++)
            {
                char pwBuchstabe = pwArray[i];
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
    private static void decryptList(List<String>list){
        System.out.println("Passwort Länge " + pwArray.length);
        int count = 0;
        for (String string : pwDecryptedList) {
            System.out.println("Nr. " + count + ": " + string);
            count++;
        }
    }

    //Methode to verify if a number or char has been typed in
    private static boolean isNumber(char[] pwArray)
    {
        for(int i = 0; i < pwArray.length; i++){
            if(Character.isLetter(pwArray[i]) == false){
                System.out.println("WRONG TYPING number or special character ARE NOT ALLOWED!");
                System.out.println("You have typed: " +  pwArray[i]);
                return false;
            }
        }
        return true;
    }
}                