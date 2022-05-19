import java.util.Scanner;
/**
 * Cesar Entschlüsselung
 */
public class CesarEncryption {
    public static int keyIn;
    public static String strAbc = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
    public static void main(String[] args) {
        System.out.println("_____Program-Start____");
        
        //Read letters in an split them in parts
        String inputverschluesseln = inputReader();
        char[] inputVerschluesseltChar = inputverschluesseln.toCharArray();

        //request for encryotion key
        Scanner schluesselINput = new Scanner(System.in);
        System.out.println("Type in your key");
        int schluessel = schluesselINput.nextInt();
        schluesselINput.close();

        verschluesseln(inputVerschluesseltChar, schluessel);
   
        System.out.println("_____Program-Ende______");
    }

    //Method to read a String in and spliting it to parts
    public static String inputReader(){
        System.out.println("Type in your message");
        String reader = System.console().readLine();  
        reader.replace(" ", "");    
        String input = reader.toLowerCase();

        return input;        
    }

    //Mehtod to encrypt message
    public static void verschluesseln(char[] input, int schluessel){
        //Separate ABC string by character and convert to CharArray
        String str = strAbc.replace(",", "");
        char[] abcChar = str.toCharArray();
        char[] verschluesselt = new char[input.length];
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
                    verschluesselt[i] = abcChar[postion];
                }
            }
        }
        System.out.print("Encrypted message: ");
        System.out.println(verschluesselt);
        
    }
}

/*Thigs to do
- erro catch type in message --> numbers check
- erro catch type in key --> letter check
*/