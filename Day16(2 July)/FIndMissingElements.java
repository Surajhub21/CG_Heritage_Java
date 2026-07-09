import java.util.*;
import java.lang.*;
import java.io.*;

class FindMissingElements{

    public static void main(String[] args){
        int[] arr = {10 , 9, 11, 13, 8};

        int smallest = arr[0];
        int largest = arr[0];
        int actualSum = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
            if(arr[i] < smallest){
                smallest = arr[i];
            }

            actualSum+=arr[i];
        }

        int expectedSum = 0;
        for(int i = smallest; i <= largest; i++){
            expectedSum+=i;
        }

        System.out.println("Missing number is : "+ (expectedSum-actualSum));
    }
}