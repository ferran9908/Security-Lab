import java.util.Scanner;

public class Caesar_cipher {

    public static String Encrypt(String text,int shift){
     String result="";
     int n= text.length();
     for(int i=0;i<n;i++){
         char c = text.charAt(i);
         if(Character.isLetter(c)){
             if(Character.isUpperCase(c)){
                 char temp = (char)(c+shift);
                 if(temp>'Z'){
                     temp = (char)(c-(26-shift));
                     result+=temp;
                 }
                 else{
                     result+=temp;
                 }
             }
             else if(Character.isLowerCase(c)){
                 char temp = (char)(c+shift);
                 if(temp>'z'){
                     temp = (char)(c-(26-shift));
                     result+=temp;
                 }
                 else{
                     result+=temp;
                 }
             }
         }else{
             result+=c;
         }
     }
     return result;
    }
    public static String Decrypt(String text,int shift){
     String result="";
     int n= text.length();
     for(int i=0;i<n;i++){
         char c = text.charAt(i);
         if(Character.isLetter(c)){
             if(Character.isUpperCase(c)){
                 char temp = (char)(c-shift);
                 if(temp<'A'){
                     temp = (char)(c+(26-shift));
                     result+=temp;
                 }
                 else{
                     result+=temp;
                 }
             }
             else if(Character.isLowerCase(c)){
                 char temp = (char)(c-shift);
                 if(temp<'a'){
                     temp = (char)(c+(26-shift));
                     result+=temp;
                 }
                 else{
                     result+=temp;
                 }
             }
         }else{
             result+=c;
         }
     }
     return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        String plaintext ="",cipher="efgfoe uif fbtu xbmm pg uif dbtumf";
        int  choice,key=1;
        do{
        System.out.println("1.Read Input:");
        System.out.println("2.Encrypt");
        System.out.println("3.Decrypt");
        System.out.println("4.Exit");
        System.out.print("Enter your choice: ");
        choice=in.nextInt();
        in.nextLine();
        switch(choice){
            case 1:
              System.out.println("Enter your text and shift(1-26):");
              plaintext=in.nextLine();
              key=in.nextInt();
              System.out.println();
              break;
            case 2:
              if(!"".equals(plaintext)){
              cipher=Encrypt(plaintext,key);
              System.out.println("Encrypted text: "+cipher);
              System.out.println();
              }
              else{
                  System.out.println("Please give an input text :)");
                  System.out.println();
              }
              break;
            case 3:
              if(!"".equals(cipher)){
              String decr=Decrypt(cipher,key);
              System.out.println("Decrypted text: "+decr);
              System.out.println();}
              else{
                  System.out.println("Ciphered text not available");
                  System.out.println();
              }
              break;
          }

        }while(choice!=4);
    }
    
}
