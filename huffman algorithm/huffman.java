import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Collections;
import java.lang.Character;
/**
 * This program is design to do the huffman algorithm by taking in letters and there frequency and turning then in to binary code
 * 
 * @author (Eric Bowers ) 
 * @version (8/6/2013)
 */
public class huffman
{
  public static void main(String [] args) throws IOException
 {
     File myfile = new File(args[0]);// for the input file 
     // these scanner are four counting some to get the length of a a array or input in some in to the array 
     Scanner input = new Scanner(myfile);// use the input file 
     Scanner input2= new Scanner(myfile);// use the input file 
     Scanner keyboard = new Scanner(System.in);// for using the keyboard input 
     ArrayList<Double> al = new ArrayList<Double>();// i used this array list to make sure i wouldnt run in to any index out bound exception
     ArrayList<String> al2 = new ArrayList<String>();// i used this array list to make sure i wouldnt run in to any index out bound exception
     ArrayList<String> binary = new ArrayList<String>();
     ArrayList<String> stringLetters = new ArrayList<String>();
     
     System.out.println("I have three input files that are a different frequency "
     +"\nor different input in the input file, check then if you want.");
      
     int count2=0;// count2 is iniliatized
     // this loop will count how many words or letters there are in the file
     while(input.hasNext())
     {
      String test ="";
      test=input.next();
      count2++;
      }
               
           String [] scan = new String[count2]; 
           int k =0;
          // this loop inputs the words or letters into the array of scan 
         while(input2.hasNext())
         {
             scan[k] = input2.next();
             
               k++;
         }
        
           int g =0;// is for one of the loops 
           int count3 = count2/2;//this is to determine the length of each line of word or letter 
           String [] letters = new String[count3];// this inilialized
           char [] charLetters = new char[count3];// this inilialized
           String [] sortedFreqency = new String[count3]; // this inilialized
           String [] orginalFreqency = new String[count3];// this inilialized
           double  [] intFreqency = new double[count3];// this inilialized
           String[] codeWord = new String[count3];// this inilialized
           DecimalFormat df = new DecimalFormat("#.##");// this keeps the frequency to a three decimal place number
           int m = 0;
           int n = 0;
           
           // this for loop separate the character and frequency to two different arrays
           for(int h =0; h<count2;h++)
           {
               
               char a = scan[h].charAt(0);
               // puting each number and letter and in differnt array
               if(Character.isDigit(a))
               {
                    sortedFreqency[m] = scan[h];
                    orginalFreqency[m] = sortedFreqency[m];
                    m++;
                }
                else
               {
                   letters[n]=scan[h];
                     charLetters[n] = scan[h].charAt(0);
                   n++;
                }
           
            }
         
            
            
            // this for loop sorts the frequencys and sort the letter with the freqency and places in two different array lists
          for(int a =0; a<count3;a++)
          {
              Arrays.sort(sortedFreqency );// sorts in acsending order
               
              for(int b=0;b<count3;b++)
              {
                 if(sortedFreqency[a] == orginalFreqency[b])
                 {
                     al2.add(a, letters[b]);// adds to the arraylist 
                     
                 }
               }
               
               intFreqency[a] = Double.parseDouble(sortedFreqency[a]);// adds to the arraylist
               al.add(a, Double.parseDouble(sortedFreqency[a]));// adds to the array list
             
            }
           
            
            
            
            int sum =0;// inlialize to 0
            int sum1 =1;// inlialize to 1
             double num;
             // this greedy algorithm using a array binary tree 
             // this for loops calculates the frequency together by the least frequency in arraylist and then determines what binary number goes with it
           for(int e =0; e<al.size();e++)
           {  
              
              
               String let = "";
               if(al.size() == 1)
               {break;}
                   
              // this if statement is to shift a frequency if one added frequency is greater than the rest of the other frequency then the array list will be resorted 
              if(al.size()!=2)
              {
               if(al.get(0)> al.get(1) && al.get(0)> al.get(2))
               {
                num = al.get(0);
                let = al2.get(0);
                al.remove(0);
                al2.remove(0);
                al.add(2,num);
                al2.add(2,let);
               }
            }
               num = al.get(e)+al.get(e+1);// add two frequency together
               num = Double.parseDouble( df.format(num));// coverting the number in a three decimal place 
               let = al2.get(e)+ al2.get(e+1);// combineing the two letters together
               
              
               // this is another shift frequency 
                if(al.size() == 2 && al.get(0) > al.get(1))
               {
                 num = al.get(0);
                 let = al2.get(0);
                 al.remove(0);
                   al2.remove(0);
                   al.add(1,num);
                   al2.add(1,let);
                }
               // this add the binary number and letters in to new arraylist
               if(e==0)
               {
                  stringLetters.add(sum,al2.get(e));
                  binary.add(sum,"0");
                  sum += 2;
               }
                // this add the binary number and letters in to new arraylist
                if((e+1)==1)
                {
                    stringLetters.add(sum1,al2.get(e+1));
                    
                    binary.add(sum1,"1");
                    
                    sum1 += 2;
                    
                }
                
               al.remove(0);// remove zero index from array list 
               al.remove(0);/// remove zero index from array list 
               
               al2.remove(0);// remove zero index from array list 
               al2.remove(0);// remove zero index from array list 
               
               al.add(0,num);// adds then new frequency 
               al2.add(0,let);// adds then new frequency 
               
               
               
               e--;// makes sure e stays at zero
            }
            
            
            // this for loops put the binary number to its right letter to get its own binary code 
            for(int x= 0; x<letters.length;x++)
            {   codeWord[x] = "";
                
                for(int y=0;y<stringLetters.size();y++)
                {
                    for(int z =0;z < stringLetters.get(y).length();z++)
                    {
                        if(charLetters[x] == stringLetters.get(y).charAt(z))
                        {
                             
                           codeWord[x]+=  binary.get(y);// tranfer in the binary numbers 
                            
                          
                             
                        }
                        
                    }
                    
                }
                
            }
             
          // this reverses the order of the code to its right order 
                for(int L =0; L<letters.length;L++)
                {
                   StringBuffer rev = new StringBuffer(codeWord[L]);// object inlialize
                  rev.reverse();// reverse method
                  codeWord[L]="";
                  codeWord[L]+= rev;// puting the binary back in order
                }
                    
              // this displays the table of the binary code and letters and frequency      
             System.out.println(     "Symbol    |   "+ letters[0] +"     "+letters[1] +"     "+letters[2] +"     "+letters[3] +"     "+letters[4]);       
             System.out.println("__________|____________________________________");       
          System.out.println("Frequency | "+ orginalFreqency[0] +"   "+orginalFreqency[1] +"   "+orginalFreqency[2] +"   "+orginalFreqency[3] +"   "+orginalFreqency[4]);
          System.out.println("Codeword  |  "+ codeWord[0] +"    "+codeWord[1] +"    "+codeWord[2] +"    "+codeWord[3] +"    "+codeWord[4]);
        
      
     
            // this stores all the items in the array list
            Object [] sortedLetters = al2.toArray();
            Object [] sortedBinary = binary.toArray();
            Object [] letter = stringLetters.toArray();
            Object[]  doubleFreqency =al.toArray();
            
            
           
 }
}
 