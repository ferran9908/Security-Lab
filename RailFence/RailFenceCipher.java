import java.util.Scanner;
public class RailFenceCipher {

     static String Encryption(String data,int depth) {
		char[] encrypted = new char[data.length()];
		int n = 0;
		
		
		for(int k = 0 ; k < depth; k ++) {
			int index = k;
			boolean down = true;
			while(index < data.length() ) {
				
				encrypted[n++] = data.charAt(index);
				
				if(k == 0 || k == depth - 1) {
					index = index + 2 * (depth - 1);
				}
				else if(down) {
					index = index +  2 * (depth - k - 1);
					down = !down;
				}
				else {
					index = index + 2 * k;
					down = !down;
				}
			}
		}
		return new String(encrypted);
	}	
    static String Decryption(String data,int depth) {
		char[] decrypted = new char[data.length()];
		int n = 0;
		for(int k = 0 ; k < depth; k ++) {
			int index = k;
			boolean down = true;
			while(index < data.length() ) {
				decrypted[index] = data.charAt(n++);
				
				if(k == 0 || k == depth - 1) {
					index = index + 2 * (depth - 1);
				}
				else if(down) {
					index = index +  2 * (depth - k - 1);
					down = !down;
				}
				else {
					index = index + 2 * k;
					down = !down;
				}
			}
		}
        return new String(decrypted);
    }    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scn=new Scanner(System.in);
        int depth=0;
        String plainText="";
        String cipherText="";
        String decryptedText="";
        int choice;
        
        while(true){
        System.out.println("Enter your choice:\n1.Read Plaintext\n2.Read Depth\n3.Encrypt\n4.Decrypt\n5.Exit");
        choice=scn.nextInt();
        if(choice==1){
        System.out.println("Enter plain text:");
        scn.nextLine();
        plainText=scn.nextLine();
        }else if(choice==2){       
        System.out.println("Enter depth for Encryption:");
        depth=scn.nextInt();
        }else if(choice==3){       
        cipherText=Encryption(plainText,depth);
        System.out.println("Encrypted text is:\n"+cipherText);
        }else if(choice==4){       
        decryptedText=Decryption(cipherText, depth);
        System.out.println("Decrypted text is:\n"+decryptedText);
        }else{
            break;
        }
        }
    }
    
}

