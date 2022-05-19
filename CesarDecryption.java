import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

public class CesarDecryption {
    public static char[] abcArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static char[] pwArray1;
    public static void main(String[] args) {
        
        inputReader();
        //char[] pwArray = {'g','b','c','j',}; 
        StringBuilder pwDecrypted = new StringBuilder(); //StringBuilder helps to build a string letter by letter
        int key = 0;
        int positionABC = 0;
        List<String> pwDecryptedList = new ArrayList<String>();
        
        System.out.println("------Program Start------");
       
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
        
        System.out.println("Passwort Länge " + pwArray1.length);
        int count = 0;
        for (String string : pwDecryptedList) {
            System.out.println("Nr. " + count + ": " + string);
            count++;
        }
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
}
                