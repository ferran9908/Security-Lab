import java.util.*;

class CeaserCipher{

  public static StringBuffer encrypt(String text, int shift){
    StringBuffer encryptedData = new StringBuffer();
    for(int i = 0; i < text.length(); i++){
      if(Character.isUpperCase(text.charAt(i))){
        char ch = (char)(((int) text.charAt(i) + shift - 65) % 26  + 65);
        encryptedData.append(ch);
      }
      else{
        char ch = (char)(((int) text.charAt(i) + shift - 97) % 26  + 97);
        encryptedData.append(ch);
      }
    }
    return encryptedData;

  }
  public static StringBuffer decrypt(String text, int shift){
    StringBuffer encryptedData = new StringBuffer();
    for(int i = 0; i < text.length(); i++){
      if(Character.isUpperCase(text.charAt(i))){
        char ch = (char)(((int) text.charAt(i) - shift - 65) % 26  + 65);
        encryptedData.append(ch);
      }
      else{
        char ch = (char)(((int) text.charAt(i) - shift - 97) % 26  + 97);
        encryptedData.append(ch);
      }
    }
    return encryptedData;

  }

  public static void main( String[] args ){
    Scanner sc = new Scanner(System.in);
    int choice = 0;
    while(true){

      System.out.println(" 1. Perform Encryption using CeaserCipher\n 2. Exit\n");
      choice = sc.nextInt();
      sc.nextLine();
        if(choice >= 2){
          break;
        }
      System.out.print("Input string to encrypt: ");
      String text = sc.nextLine();

      System.out.print("Enter shift value: ");
      int shift = sc.nextInt();
      StringBuffer encrypted = encrypt(text,shift);
      System.out.println("Encrypted Text: "+ encrypted);
      System.out.println("Decryption of " + encrypted.toString()+ ": " + decrypt(encrypted.toString(), shift));
    }
  }
}
