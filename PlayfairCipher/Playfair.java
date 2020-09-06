import java.util.Scanner;

public class Playfair {

  private String Keyword = new String();
  private String Key = new String();
  private char keyMatrix[][] = new char[5][5];

  public void setKey(String key) {
    boolean flag = false;
    String keyAdjusted = new String();
    keyAdjusted += k.charAt(0);
    for(int i = 1; i < key.length(); i++) {
      for(int j = 0; j < keyAdjusted.length(); j++) {
        if(key.charAt(i) == keyAdjusted.charAt(j)) flag = true
      }
      if(!flag) keyAdjusted += key.charAt(i);
      flag = false;

    }
    Keyword = keyAdjusted;
  }

  public void KeyGen()
  {
    boolean flag=true;
    char current;
    Key=Keyword;
    for ( int i = 0 ; i < 26 ; i++)
    {
      current=(char)(i+97);
      if(current=='j')
        continue;
      for(int j=0 ; j< Keyword.length() ; j++ )
      {
        if (current == KeyWord.charAt(j))
        {
          flag=false;
          break;
        }
      }
      if(flag)
        Key=Key+current;
      flag=true;
    }
    System.out.println(Key);
    matrix ();
  }

  private void matrix ()
  {
    int counter=0;
    for (int i=0 ; i<5 ;i++)
    {
      for (int j=0 ; j<5 ; j++)
      {
        key_matrix[i][j]=Key.charAt(counter);
        System.out.printf("%s ",key_matrix[i][j]);
        counter++;
      }
      System.out.println("\n");
    }
  }

    private String format(String old_text)
  {
    int i = 0;
    int j = 0;
    int len = 0;
    String text = new String();
    len = old_text.length();

    for (int tmp = 0; tmp < len; tmp++)
    {
      if (old_text.charAt(tmp) == 'j')
      {
        text = text + 'i';
      }
      else if(old_text.charAt(tmp)==' '){
        continue;
      }
      else
        text = text+old_text.charAt(tmp);
    }
    len = text.length();
    for (i = 0; i < len-1; i = i + 2)
    {
      if (text.charAt(i+1) == text.charAt(i))
      {
        text = text.substring(0, i+1) + 'x' + text.substring(i+1);
      }
      else
      {}
    }
    return text;
  }

  private String [] Divid2Pairs (String new_string)
  {
    String Original = format(new_string);
    int size= Original.length();
    if(size%2!=0)
    {
      size++;
      Original = Original+'x';
    }

    String x[]= new String[size/2];
    int counter=0;
    for ( int i=0 ; i<size/2 ;i++)
    {
      x[i]=Original.substring(counter, counter+2);
      System.out.print(x[i]+'\t');
      counter=counter+2;
    }
    System.out.println();
    return x;
  }

  public int[] GetDimensions(char letter)
  {
    int []key=new int[2];
    if ( letter == 'j')
      letter='i';
    for (int i=0 ; i<5 ;i++)
    {
      for (int j=0 ; j<5 ; j++)
      {
        if(key_matrix[i][j] == letter)
        {
          key[0]=i;
          key[1]=j;
          break;
        }
      }
    }
    return key;
  }

  public String Encrypt(String Source)
  {
    System.out.println("Encryption Start");
    String src_arr[]=Divid2Pairs(Source);
    String Code=new String();
    char one;
    char two;
    int part1[]=new int[2];
    int part2[]=new int[2];
    for (int i=0 ; i< src_arr.length ;i++ )
    {
      one = src_arr[i].charAt(0);
      two = src_arr[i].charAt(1);
      part1 = GetDimensions(one);
      part2 = GetDimensions(two);
      if(part1[0]==part2[0])
      {
        if (part1[1]<4)
          part1[1]++;
        else
          part1[1]=0;
        if(part2[1]<4)
          part2[1]++;
        else
          part2[1]=0;
      }

      else if (part1[1]==part2[1])
      {
        if (part1[0]<4)
          part1[0]++;
        else
          part1[0]=0;

        if(part2[0]<4)
          part2[0]++;
        else
          part2[0]=0;
      }
      else
      {
        int temp=part1[1];
        part1[1]=part2[1];
        part2[1]=temp;
      }
      Code= Code + key_matrix[part1[0]][part1[1]] + key_matrix[part2[0]][part2[1]];
    }

    System.out.println("Encrypted Text: "+Code+'\n');
    return Code;
  }

  public String Decrypt (String Code)
  {
    System.out.println("Decryption Start");
    String Original=new String();
    String src_arr[]=Divid2Pairs(Code);
    char one;
    char two;
    int part1[]=new int[2];
    int part2[]=new int[2];
    for (int i=0 ; i< src_arr.length ;i++ )
    {
      one = src_arr[i].charAt(0);
      two = src_arr[i].charAt(1);
      part1 = GetDimensions(one);
      part2 = GetDimensions(two);

      if(part1[0]==part2[0])
      {
        if (part1[1]>0)
          part1[1]--;
        else
          part1[1]=4;
        if(part2[1]>0)
          part2[1]--;
        else
          part2[1]=4;
      }

      else if (part1[1]==part2[1])
      {
        if (part1[0]>0)
          part1[0]--;
        else
          part1[0]=4;
        if(part2[0]>0)
          part2[0]--;
        else
          part2[0]=4;
      }
      else
      {
        int temp=part1[1];
        part1[1]=part2[1];
        part2[1]=temp;
      }
      Original =Original + key_matrix[part1[0]][part1[1]] + key_matrix[part2[0]][part2[1]];
    }
    System.out.println("Decrypted Text: "+Original+"\n");
    return Original;
  }


  public static void main(String[] args) {
    Playfair x = new Playfair();
    int choice = 0;
    Scanner sc = new Scanner(System.in);
    while(true){
      System.out.println("Enter your choice:\n1.Perform PlayFair Cipher\n2.Exit");
      choice=sc.nextInt();
      sc.nextLine();
      if(choice == 2){
        break;
      }
      System.out.println("Enter a keyword:");
      String keyword = sc.nextLine();
      x.setKey(keyword);
      System.out.println(x.KeyWord)
        x.KeyGen();
      System.out.println("Enter word to encrypt & decrypt:");
      String key_input = sc.nextLine();
      String Encrypted= x.Encrypt(key_input);
      x.Decrypt(Encrypted);
    };
  }
}

