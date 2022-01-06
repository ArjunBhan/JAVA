/**
 * Name: Arjun Bhan
 * Due Data: 9/23/2021
 * Class: CMPT 435 Algorithms Design and Analysis
 * Purpose: This program show how many times an item is in the list.
 */
public class Problem1 {
    public static int count(double[] A, double x) {
        int End = A.length - 1;
        int Start = 0;
        int StartInd = 0;
        int EndInd = 0;
        int CurVal = 0;

        //Searching for the first occurence of x
       while(Start<=End)
       {
           //Finding the middle value based on the values we know it is between.
           CurVal=(Start+(End-Start)/2);

           //Updating the amount of area we search in the list
           if(A[CurVal]>x)
           {
               End= CurVal-1;
           }

           else if(A[CurVal]<x)
           {
               Start=CurVal+1;
           }

           //Makes sure that if the final element of x is found the loop ends
           else
           {
               End=CurVal-1;
               StartInd=CurVal;
           }
       }
       //Searching for  the last occurence of x
        Start=0;
        End=A.length - 1;
        while(Start<=End)
        {
            CurVal=(Start+(End-Start)/2);
            if(A[CurVal]>x)
            {
                End= CurVal-1;
            }

            else if(A[CurVal]<x)
            {
                Start=CurVal+1;
            }

            //Makes sure that if the first element of x is found the loop ends.
            else
            {
                Start=CurVal+1;
                EndInd=CurVal;
            }
        }
        return ((EndInd-StartInd)+1);
    }

	
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        // test your count() method here

        double[] testarray = {1.1,1.3, 2.1, 2.1, 2.1,  6.7, 7.5, 7.5, 8.6, 9.0, 9.0, 9.0};
        double t1 = 2.1;
        double t2 = 8.6;
        double t3 = 9.0;
        double t4 = 1.1;
        System.out.println(t1 + " appears " + count(testarray, t1) + " times");

        System.out.println(t2 + " appears " + count(testarray, t2) + " times");

        System.out.println(t3 + " appears " + count(testarray, t3) + " times");
        System.out.println(t4 + " appears " + count(testarray, t4) + " times");
    }
}

