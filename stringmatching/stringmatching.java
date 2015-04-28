import java.util.*;
import java.io.*;

/**
 * Write a description of class stringmatching here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stringmatching
{
   public static void main(String[]args)throws IOException
   {
       File myfile = new File("input.txt");
       Scanner input = new Scanner(myfile);
       Scanner input2 = new Scanner(myfile);
        Scanner input3 = new Scanner(myfile);
       Scanner keyboard = new Scanner (System.in);
       int count = 0;
       int count2 = 0;
       StringTokenizer token;
       StringTokenizer token2;
       String [] line;
       String [] words;
       char charWord;
       char charWord2;
       char extraLetter;
       char [] letters;
       int [] idNumber;
       String word;
       int size=0;
       int size2;
       int userIdNumber=0;
       int number=0;
       int id=0;
       int subString=0;
      
      System.out.print("Input File:"); 
       while(input.hasNext())
       {
         String test = input.nextLine();
         System.out.println(  test);
         count++;
       }
       
       line = new String[count];
       
       System.out.print("Pattern:");
      word = keyboard.nextLine();
      size = word.length();
      charWord = word.charAt(0);
      charWord2 = word.charAt(1);
      for(int j=0;j<size;j++)
      {
       userIdNumber += (int)word.charAt(j);
          
          
        }
       
        
        int count3=0;
        
        while(input2.hasNext())
       {
          
         for(int i = 0;i<count;i++)
         {
            line[i] = input2.nextLine(); 
         }
            
         
           
       }
       
       
       
       for(int k = 0;k<count;k++)
       {  
           token = new StringTokenizer(line[k]);
            token2 = new StringTokenizer(line[k]);
          count3 =0;
          count2=0;
          size2 =0;
          size2 = line[k].length();
          letters = new char[size2];
          for( int a =0;a<size2;a++)
          {
              letters[a]=line[k].charAt(a);
              extraLetter = line[k].charAt(a+1);          
              if(charWord ==letters[a]&&charWord2 == extraLetter)
              {
                  subString = a + 1;
                  break;
                }
              
            }
          
            while(token.hasMoreTokens())
            {   
                String test3;
                
                test3 = token.nextToken();
                
                count3++;
                
           
           
            }
           words = new String [count3];
              while(token2.hasMoreTokens())
               {
                  words[count2] = token2.nextToken(); 
                  
                  count2++;
                }
                idNumber = new int[count2];
               for(int x =0;x<count2;x++)
               { size = words[x].length();
                   number= 0;
                   for(int y=0; y<size;y++)
                   {
                      number += (int)words[x].charAt(y);
                     
                    }
                   
                   idNumber[x] = number;
                }
             
                
                for(int z=0;z<count2;z++)
                {
                   if(userIdNumber == idNumber[z])
                   {
                       System.out.println("match found at line "+(k+1)+"character starting at" + subString);
                       id = idNumber[z]; 
                       break;
                    }
                   
                    
                }
                if(userIdNumber == id)
                {
                    break;
                }
                
        }
       
          if(userIdNumber != id)
          {
           System.out.println("match not found ");
              
            }
        
   }
}
