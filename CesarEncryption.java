import java.util.Scanner;



/**
 * Cesar Entschlüsselung
 */

public class Cesar {
    public static int keyIn;
    public static String strAbc = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
    public static void main(String[] args) {
        System.out.println("_____Program-Start____");
        
        //Read letters in an split them in parts
        String inputverschluesseln = inputReader();
        //inputverschluesseln = inputverschluesseln.replace(" ", "");
        char[] inputVerschluesseltChar = inputverschluesseln.toCharArray();

        Scanner schluesselINput = new Scanner(System.in);
        System.out.println("Schluessel bitte eingeben");
        int schluessel = schluesselINput.nextInt();
        schluesselINput.close();

        verschluesseln(inputVerschluesseltChar, schluessel);

        System.out.println("__________");        
        
        System.out.println("Versuch entschlüsseln");
   
        System.out.println("_____Program-Ende______");
    }

    //Method to read a String in and spliting it to parts
    public static String inputReader(){
        System.out.println("Bitte gebe etwas ein");
        String reader = System.console().readLine();  
        reader.replace(" ", "");    
        String input = reader.toLowerCase();

        return input;        
    }

    //Method to print an array to console
    public static void printArrayToConsol(char[] printArray){

        for(int i = 0; i < printArray.length; i++)
        {
            System.out.println(printArray[i]);
        }
    }

    public static void verschluesseln(char[] input, int schluessel){
        //ABC String nach Zeichen trennen und in CharArray umwandeln
        String str = strAbc.replace(",", "");
        char[] abcChar = str.toCharArray();
        char[] verschluesselt = new char[input.length];
        int postion = 0;

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

        System.out.println(verschluesselt);
        
    }

    // Methode zum entschlüsseln
    public static void entschluesseln(char[] verschluesseltArray){
        
    }
}