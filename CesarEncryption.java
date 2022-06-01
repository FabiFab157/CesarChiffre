import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Cesar Entschlüsselung
 */
public class CesarEncryption {

    public static char[] pwArray;
    private static String strAbc = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
    public static void main(String[] args) {
        System.out.println("_____Program-Start____");
        
        encrypt(inputReader(), encryptKey());
   
        System.out.println("_____Program-Ende______");
    }

    //Method to read a String in and spliting it to parts
    private static char[] inputReader(){
        //variable to stop loop when input of user is a number or special character
        boolean goOn = true;
        while(goOn == true){
               //Read letters in an split them in parts
                System.out.println("Type in your message");
                String reader = System.console().readLine();  
                reader.replace(" ", "");    
                String input = reader.toLowerCase();

                pwArray = input.toCharArray();
                if(isNumber(pwArray) == false){
                    goOn = false;
                    return pwArray = null;   
                }
                goOn = false; //stop the loop
        }
        return pwArray;
    }

    private static int encryptKey()
    {
        int key = 0;
        if(pwArray == null)
        {
            return key = 0;
            
        }else{
            //request for encryotion key
            try{
                Scanner keyInput = new Scanner(System.in);
                System.out.println("Type in your key");
                key = keyInput.nextInt();
                keyInput.close();
            }catch(NoSuchElementException e){
                System.out.println("WRONG TYPING ONLY NUMBERS ARE ALLOWED!");
                return key = 0;
            }
            return key;
        }         
    }

    //Mehtod to encrypt message
    private static void encrypt(char[] input, int schluessel){
        if(pwArray != null)
        {
            //Separate ABC string by character and convert to CharArray
            String str = strAbc.replace(",", "");
            char[] abcChar = str.toCharArray();
            char[] encryptText = new char[input.length];
            int postion = 0;

            //added method with modulu
            for(int i = 0; i < input.length; i++){
                for(int j = 0; j < abcChar.length; j++){
                    if(input[i] == abcChar[j]){
                        postion = j + schluessel;
                        if(postion > abcChar.length-1)
                        {
                            postion = postion % abcChar.length;
                        }
                        encryptText[i] = abcChar[postion];
                    }
                }
            }
            System.out.print("Encrypted message: ");
            System.out.println(encryptText);  
        }else{
            System.out.println("Program is closed");
        }  
    }

    //Methode to verify if a number or char has been typed in
    private static boolean isNumber(char[] inputArray)
    {
        for(int i = 0; i < inputArray.length; i++){
            if(Character.isLetter(inputArray[i]) == false){
                System.out.println("WRONG TYPING number or special character ARE NOT ALLOWED!");
                System.out.println("You have typed: " +  inputArray[i]);
                return false;
            }
        }
        return true;
    }
}

/*Things to do
- erro catch type in message --> numbers check
*/