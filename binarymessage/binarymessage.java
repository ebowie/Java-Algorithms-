import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
/**
 *This programs take a sentence and converts the letters int to binary and integers and back to a sentence 
 * 
 * @author (Eric Bowers ) 
 * @version (07/14/2013)
 */
public class binarymessage
{
   public static void main(String [] args) throws IOException 
   {
     File myfile = new File(args[0]); // the object file tha the file goes through 
     Scanner input = new Scanner(myfile); // the file goes through a scanner 
     Scanner keyboard = new Scanner(System.in);// inputs a message in to the program
     String sentence; // use for the messafe 
     StringTokenizer token;// seperate the sentence 
     int size=0;// iniliatize the size to zero 
     char [] letters;// array for all the letters 
     int [] acsii; // array for all the ascii numbers
     String charLine=""; //use for any character 
     String[] binary; // use to input binary numbers in too 
     String [] tenBitBinary; // use for ten bit binary numbers 
     int [] binarySum; // use for the integers of the binary number 
     int encode [] = new int [10]; // use for the encryption key 
      int encode2 [] = new int [7]; // converter the encryption key into 7 integers 
     int zerosLength=0; // to use display the amount of zeros to input 
     int zerosLength2=0; // to use display the amount of zeros to input 
     int [] binaryInt; // use for turn binary strings into integers
     int [] binaryNum = {64,32,16,8,4,2,1}; // binary number list in a already to comparble 
     int [] acsii2;// to display the ascii numbers again 
     String [] sevenBitBinary;// to display the seven bit binary 
     
     System.out.println("enter a message");// to input a sentence 
     sentence = keyboard.nextLine(); // to make sure it got inputed 
     size = sentence.length();// to finf out the size of the sentence to use it in t loops 
     int a,b,c,d,e,f,g,h,i,j; // for the alorgithm for integers  
     int size2 = 7;// for the algorithm 
    
    char letter;// to display letters 
     String finalSentence = ""; // to display the final sentence 
        
     
      
    
     
    
     
     letters = new char[size]; // to iniliatize  the size of the array 
     sevenBitBinary = new String[size];// to iniliatize  the size of the array 
     // this loop is putting all the character in the array 
     for(int l = 0;l<size;l++)
     {
         letters[l] =sentence.charAt(l);
         
         
     }
     acsii = new int[size];// to iniliatize  the size of the array 
     // this loop is putting all the  ascii numbers in the array 
     for(int n =0;n<size;n++)
     {
        acsii[n] =(int)letters[n];
     }
     binary = new String[size];// to iniliatize  the size of the array 
     tenBitBinary= new String[size];// to iniliatize  the size of the array 
     // this double for loop converters the binary and put it in the ten binary code and seven binary code by adding zeros 
     for(int k =0;k<size;k++)
     {
      binary[k] = Integer.toBinaryString(acsii[k]);   
      zerosLength = binary[k].length();
      zerosLength2 = binary[k].length();
      
       zerosLength=10 - zerosLength;
       zerosLength2 =7 - zerosLength2;
       String zeros = "";
       String zeros2 = "";
       
        for(int x =0; x<zerosLength2;x++)
       {
          zeros2 += 0;
        
       }
       
       sevenBitBinary[k]= zeros2 + binary[k];
       for(int x =0; x<zerosLength;x++)
       {
          zeros += 0;
        
       }
        tenBitBinary[k] = zeros + binary[k];
     }
     
     // this while loop take encrption key and seperates each number from it and put it in the array 
     while(input.hasNext())
     {
         for(int y=0; y<10;y++)
         {
        String line = input.next();
        
        encode[y] = Integer.parseInt(line);
          
        }
     }
     // this takes the encrption key turns it in a seven bit encrption key for the algorithm i use 
     encode2[0]=encode[3];
     encode2[1]=encode[4];
     encode2[2]=encode[5];
     encode2[3]=encode[6];
     encode2[4]=encode[7];
     encode2[5]=encode[8];
     encode2[6]=encode[9];
     
       
     binarySum = new int [size];// to iniliatize  the size of the array 
     
     // this double for loop figure out the sum from the binary code  
       for(int u =0;u<size;u++)
       {
           for(int v =0; v<7;v++)
           {
               int one; 
               one = Integer.parseInt(sevenBitBinary[u].substring(v,v+1));
               if(one == 1)
               {
                   
                binarySum[u] += encode[v];   
               }
            }
           
           
       }
     
       
       binaryInt = new int[7];// to iniliatize  the size of the array 
       acsii2 = new int [size];// to iniliatize  the size of the array  
       
       // this huge for loop diaplay each letters of conversion and use the algorithm in there to converter it back to a sentence 
       for(int s =0; s<size;s++)
       {        
                  System.out.println("\n");
           // display letter 
                 System.out.print("Letters:");
                 System.out.println(letters[s]);
            // display acsii number      
                 System.out.print("Convert to acsii:");
                 System.out.println(acsii[s]);
             // display bit binary    
                 System.out.print("Convert to seven bit binary:");
                 System.out.println(sevenBitBinary[s]);
              // display ten bit binary   
                 System.out.print("Convert to ten bit binary:");
                 System.out.println(tenBitBinary[s]);
                      
                     int sum = binarySum[s];//
                    int finalTotal=0;
                 Random rand = new Random();// use a randome numbers 
                 long start = System.currentTimeMillis();//this use to stop a loop in time of 3 seconds 
                 for(int m = 0; m<7;m++)
                   {
                       binaryInt[m]=0;// makes sure that the array is clears from any other stuff left in it 
                   }
                 do
                 {
                           ArrayList<Integer> list = new ArrayList<Integer>(size2);// this a array list for the randome numbers to not be duplicated 
                           int [] randomNumber = new int [7];// random numbers between 0 and 9 
                           int z =0;
                            for(int n = 0; n < size2; n++) {
                                list.add(n);// add to the list of the array list 
                            }
                             // this loop the list until not duplicates product
                            while(list.size() > 0) {
                            int index = rand.nextInt(list.size());
                           randomNumber[z]=list.remove(index);
                           z++;
                        }
                   
                       
                        
                      // each number is a letter   
                      a = randomNumber[0];
                      b = randomNumber[1];
                      c = randomNumber[2];
                      d = randomNumber[3];
                      e = randomNumber[4];
                      f = randomNumber[5];
                      g = randomNumber[6];
                      /*
                      h = randomNumber[7];
                      i = randomNumber[8];
                      j = randomNumber[9];
                      */
                      //letters are use in this algorithm to access the encode key 
                     
                     int total0 = encode[a]; 
                     int total1 = encode[a]+ encode[b];
                     int total2 = encode[a]+ encode[b]+ encode[c];
                     int total3 = encode[a]+ encode[b]+ encode[c]+ encode[d];
                     int total4 = encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e];
                     int total5 = encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e]+ encode[f];
                     int total6 = encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e]+ encode[f]+ encode[g];
                    /*
                     int total7 = encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e]+ encode[f]+ encode[g]+ encode[h];
                     int total8 = encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e]+ encode[f]+ encode[g]+ encode[h]+ encode[i];
                     int total9= encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e]+ encode[f]+ encode[g]+ encode[h]+encode[i]
                     + encode[j];
                     */
                     
                     // then these were to which total has equal to the sum
                      if(sum == total0)
                     {
                     finalTotal = total0;
                     a = encode2[a];
                     b = 0;
                     c = 0;
                     d = 0;
                     e = 0;
                     f = 0;
                     g = 0; 
                     h = 0;
                     i = 0;
                     j = 0;
                     }
                     if(sum == total1)
                     {
                     finalTotal = total1;
                     a = encode2[a];
                     b = encode2[b];
                     c = 0;
                     d = 0;
                     e = 0;
                     f = 0;
                     g = 0; 
                     h = 0;
                     i = 0;
                     j = 0;
                     }
                     if(sum == total2)
                     {
                     finalTotal = total2;
                     a = encode2[a];
                     b = encode2[b];
                     c = encode2[c];
                     d = 0;
                     e = 0;
                     f = 0;
                     g = 0; 
                     h = 0;
                     i = 0;
                     j = 0;
                     }
                     if(sum == total3)
                     {
                     finalTotal = total3;
                     a = encode2[a];
                     b = encode2[b];
                     c = encode2[c];
                     d = encode2[d];
                     e = 0;
                     f = 0;
                     g = 0; 
                     h = 0;
                     i = 0;
                     j = 0;
                     }
                     if(sum == total4)
                     {
                     finalTotal = total4;
                     a = encode2[a];
                     b = encode2[b];
                     c = encode2[c];
                     d = encode2[d];
                     e = encode2[e];
                     f = 0;
                     g = 0; 
                     h = 0;
                     i = 0;
                     j = 0;
                     }
                     if(sum == total5)
                     {
                     finalTotal = total5;
                     a = encode2[a];
                     b = encode2[b];
                     c = encode2[c];
                     d = encode2[d];
                     e = encode2[e];
                     f = encode2[f];
                     g = 0; 
                     h = 0;
                     i = 0;
                     j = 0;
                     }
                     if(sum == total6)
                     {
                     finalTotal = total6;
                     a = encode2[a];
                     b = encode2[b];
                     c = encode2[c];
                     d = encode2[d];
                     e = encode2[e];
                     f = encode2[f];
                     g = encode2[g];
                     h = 0;
                     i = 0;
                     j = 0;
                     }
                    /*
                     if(sum == total7)
                     {
                     finalTotal = total7;
                     a = encode[a];
                     b = encode[b];
                     c = encode[c];
                     d = encode[d];
                     e = encode[e];
                     f = encode[f];
                     g = encode[g];
                     h = encode[h];
                     i = 0;
                     j = 0;
                     }
                     if(sum == total8)
                     {
                     finalTotal = total8;
                     a = encode[a];
                     b = encode[b];
                     c = encode[c];
                     d = encode[d];
                     e = encode[e];
                     f = encode[f];
                     g = encode[g];
                     h = encode[h];
                     i = encode[i];
                     j = 0;
                     }
                     if(sum == total9)
                     {
                     finalTotal = total9;
                     a = encode[a];
                     b = encode[b];
                     c = encode[c];
                     d = encode[d];
                     e = encode[e];
                     f = encode[f];
                     g = encode[g];
                     h = encode[h];
                     i = encode[i];
                     j = encode[j];
                     }
                     */
                     // if the integer is not found from the sum then the timeing wil break the loop 
                     
                     if(System.currentTimeMillis()-start>= 3000)
                     {
                         break;
                      }
                     
                 }while(sum != finalTotal);
                  
                 // this puts the input of integer 
                    if(finalTotal !=0)
                    {
                   System.out.println("encryption key:"+ finalTotal);
                   }
                   else
                   {
                       System.out.println("Input:"+ sum);
                    }
                 // this puts the each integer in to the binary code 
                   for(int m = 0;m<7;m++)
                   {
                       if(a == encode2[m])
                          binaryInt[m] = 1;
                       if(b == encode2[m])
                           binaryInt[m] = 1;   
                       if(c == encode2[m])
                           binaryInt[m] = 1; 
                       if(d == encode2[m])
                          binaryInt[m] = 1;
                       if(e == encode2[m])
                           binaryInt[m] = 1;
                       if(f == encode2[m])
                           binaryInt[m] = 1;
                       if(g == encode2[m])
                          binaryInt[m] = 1;
                       /*
                          if(h == encode[m])
                          binaryInt[m] = 1;
                       if(i == encode[m])
                           binaryInt[m] = 1; 
                       if(j == encode[m])
                         binaryInt[m] = 1;
                         */
                   }
                   
                  
                 // display ten bit binary
                 System.out.print("Convert back to ten bit binary:");
                 System.out.println(tenBitBinary[s]);
                  // display seven bit binary
                 System.out.print("Convert back to seven bit binary:");
                 System.out.println(sevenBitBinary[s]);
                  
                 //convert to ascii number s
                   for(int m =0; m<7;m++)
                   {
                       if(binaryInt[m] == 1)
                       {    
                           acsii2[s]+= binaryNum[m];
                           
                       }
                       
                    }
                 
                    
                System.out.print("back to ascii:");    
                System.out.println(acsii2[s]);
                letter = (char)acsii2[s];
                System.out.print("back to letter:");
                System.out.println(letter);
                finalSentence += letter;
                }
                System.out.println("\n your message is:"+ finalSentence);// sentence of back together 
    }
}
