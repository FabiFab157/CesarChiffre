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
        //Read letters in an split them in parts 
        System.out.println("Type in your message");
        Scanner readIn = new Scanner(System.in);
        
        
            if(readIn.hasNextDouble()){
                System.out.println("Please type in only letters");
                System.out.println("You have typed in: " + readIn.nextInt());
            } else {
                String reader = readIn.toString();
                reader.replace(" ", "");
                reader = reader.toLowerCase();
                pwArray = reader.toCharArray();
            }
            readIn.close();
        
        /* String reader = System.console().readLine();  
        reader.replace(" ", "");    
        String input = reader.toLowerCase();
        pwArray = input.toCharArray(); */

        return pwArray;        
    }

    private static int encryptKey()
    {
        //request for encryotion key
        Scanner keyInput = new Scanner(System.in);
        System.out.println("Type in your key");
        int key = keyInput.nextInt();
        keyInput.close();
        return key;
    }

    //Mehtod to encrypt message
    private static void encrypt(char[] input, int schluessel){
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
    }
}

/*Thigs to do
- erro catch type in message --> numbers check
- erro catch type in key --> letter check
*/