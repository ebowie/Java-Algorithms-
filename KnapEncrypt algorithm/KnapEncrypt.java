
/**
 * This program is converter for a 10 bit encryption key that turns in to integers
 * or binary code.
 * 
 * @author (Eric Bowers ) 
 * @version (7/13/2013)
 */
import java.util.*;
import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class  KnapEncrypt
{
    
    public static void main (String [] args) throws IOException
    {
        //variables 
        int a,b,c,d,e,f,g,h,i,j;
        int total =0;
        int count = 0 ; 
        int size =10;
        String line ;
        char playAgain = ' ';
        int [] encode = new int[10];
        int [] binaryCode = new int[10];
        String [] scan;
        StringTokenizer token;
        ////////////////////////////////////////////////////////////////////////////
        
        
        ///////////////////////////////////////////////////////////////////////////
        do
        {
        //objects 
        File myfile = new File(args[0]);// file with a argument for the file 
        Scanner input = new Scanner (myfile);// input to count the length of the file
        Scanner input2 = new Scanner(myfile);// input to enter data into the file
        Scanner keyboard = new Scanner(System.in);//input from keyboard
        
        // this counting the input to find the length of it
        while(input.hasNext())
        {
            line= input.nextLine();
            count++;
        }
        
       
        
        
        // the counting is then put in to  a array
        scan = new String[count];
      
        // this loop put everything that is in the file in to the array
         int t =0;
        while(input2.hasNext())
            {
              line = input2.nextLine();
            
              scan[t] = line;
              t++;
            }
        ////////////////////////////////////////////////////////////////////////////////////////
        
            
        ///////////////////////////////////////////////////////////////////////////////////////    
            
            //this loop take the encode and puts it to a array and prints it out 
            System.out.print("Encode Array:");
            for(int m = 0;m<count;m++)
        { 
              if(scan[m].length() > 30)// it checks the lengths of each items in file 
              {
                token = new StringTokenizer(scan[m]);// then it splits the encode in to seperate lines 
                for(int s = 0; s<10; s++)
                {
                  encode[s] =Integer.parseInt(token.nextToken()); //converts each string in to a integer
                  System.out.print( encode[s]+" ");   // prints it out 
                }
            } 
        }
        System.out.println("\n");
        
        ///////////////////////////////////////////////////////////////////////////////////////////
        
        
        
        //////////////////////////////////////////////////////////////////////////////////////////
        
        
        //this is the algorithm for converting binary to a integer  
        for(int p =0; p<count;p++)
        {
            // making sure the binary is 10 bits long 
            if(scan[p].length() == 10)
            {
             total =0;
            for(int k=0;k<10;k++)
            {
               binaryCode[k] = Integer.parseInt(scan[p].substring(k,k+1)); // takes each string converts it into a integer
            }
            System.out.print("Input:");
       
                // this converts then binary in to a integer 
                for(int l =0; l<10; l++)
                        {
                            if(binaryCode[l] == 1)
                            {
                                total += encode[l];
                            }
                            System.out.print( binaryCode[l]);// its prints out right here 
                        }
                        
                        System.out.println("\nOutput:" + total+"\n");
                    } 
                    else if(scan[p].length() > 4 && scan[p].length()< 30) //this is for if the binary code is to long or short and not equal to 10 
                    {
                     System.out.println("Input:"+scan[p]);
                     System.out.println("Output:----------"+"\n");
                   
                    }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        //////////////////////////////////////////////////////////////////////////////////////////////////
        //this a algorithm that converts integer to binary code 
        for(int x = 0; x<count;x++)
        {
             if(scan[x].length() < 10)// this scans to see the string length is less then 10 
                {
                 int sum = Integer.parseInt(scan[x]);// converts the string to integer
                 int finalTotal=0;
                 Random rand = new Random();// use a randome numbers 
                 long start = System.currentTimeMillis();//this use to stop a loop in time of 3 seconds 
                 for(int m = 0; m<10;m++)
                   {
                       binaryCode[m]=0;// makes sure that the array is clears from any other stuff left in it 
                   }
                 do
                 {
                           ArrayList<Integer> list = new ArrayList<Integer>(size);// this a array list for the randome numbers to not be duplicated 
                           int [] randomNumber = new int [10];// random numbers between 0 and 9 
                           int z =0;
                            for(int n = 0; n < size; n++) {
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
                      h = randomNumber[7];
                      i = randomNumber[8];
                      j = randomNumber[9];
                    
                      //letters are use in this algorithm to access the encode key 
                     int total1 = encode[a]+ encode[b];
                     int total2 = encode[a]+ encode[b]+ encode[c];
                     int total3 = encode[a]+ encode[b]+ encode[c]+ encode[d];
                     int total4 = encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e];
                     int total5 = encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e]+ encode[f];
                     int total6 = encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e]+ encode[f]+ encode[g];
                     int total7 = encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e]+ encode[f]+ encode[g]+ encode[h];
                     int total8 = encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e]+ encode[f]+ encode[g]+ encode[h]+ encode[i];
                     int total9= encode[a]+ encode[b]+ encode[c]+ encode[d]
                     + encode[e]+ encode[f]+ encode[g]+ encode[h]+encode[i]
                     + encode[j];
                     
                     
                     // then these were to which total has equal to the sum
                     if(sum == total1)
                     {
                     finalTotal = total1;
                     a = encode[a];
                     b = encode[b];
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
                     a = encode[a];
                     b = encode[b];
                     c = encode[c];
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
                     a = encode[a];
                     b = encode[b];
                     c = encode[c];
                     d = encode[d];
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
                     a = encode[a];
                     b = encode[b];
                     c = encode[c];
                     d = encode[d];
                     e = encode[e];
                     f = 0;
                     g = 0; 
                     h = 0;
                     i = 0;
                     j = 0;
                     }
                     if(sum == total5)
                     {
                     finalTotal = total5;
                     a = encode[a];
                     b = encode[b];
                     c = encode[c];
                     d = encode[d];
                     e = encode[e];
                     f = encode[f];
                     g = 0; 
                     h = 0;
                     i = 0;
                     j = 0;
                     }
                     if(sum == total6)
                     {
                     finalTotal = total6;
                     a = encode[a];
                     b = encode[b];
                     c = encode[c];
                     d = encode[d];
                     e = encode[e];
                     f = encode[f];
                     g = encode[g];
                     h = 0;
                     i = 0;
                     j = 0;
                     }
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
                     // if the integer is not found from the sum then the timeing wil break the loop 
                     
                     if(System.currentTimeMillis()-start>= 3000)
                     {
                         break;
                      }
                     
                 }while(sum != finalTotal);
                  
                 // this puts the input of integer 
                    if(finalTotal !=0)
                    {
                   System.out.println("Input:"+ finalTotal);
                   }
                   else
                   {
                       System.out.println("Input:"+ sum);
                    }
                 // this puts the each integer in to the binary code 
                   for(int m = 0;m<10;m++)
                   {
                       if(a == encode[m])
                          binaryCode[m] = 1;
                       if(b == encode[m])
                          binaryCode[m] = 1;   
                       if(c == encode[m])
                          binaryCode[m] = 1; 
                       if(d == encode[m])
                          binaryCode[m] = 1;
                       if(e == encode[m])
                          binaryCode[m] = 1;
                       if(f == encode[m])
                          binaryCode[m] = 1;
                       if(g == encode[m])
                          binaryCode[m] = 1;
                       if(h == encode[m])
                          binaryCode[m] = 1;
                       if(i == encode[m])
                          binaryCode[m] = 1; 
                       if(j == encode[m])
                          binaryCode[m] = 1;
                   }
                   
                   // this prints out the binary code 
                   if(finalTotal != 0)
                   {
                   System.out.print("Output:");
                   for(int m = 0; m<10;m++)
                   {
                       System.out.print(binaryCode[m]);
                   }
                   }
                   else
                   {
                       System.out.print("Output:----------");
                    }
                   System.out.println("\n");
                }
                }     
        System.out.println("\ndo want encode the binary numbers again, enter y");// this start the program all over 
        playAgain = keyboard.next().charAt(0);
        
    }while(playAgain == 'y' || playAgain == 'Y');
    
    
    

}
}