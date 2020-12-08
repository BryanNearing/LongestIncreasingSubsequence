package longIncSubPack;

import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence {
	
	static int max_ref;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Random rand = new Random(); 
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("How many numbers do you want to look through?");
		int n = s.nextInt();
		
		System.out.println("Looking through " + n + " numbers");
		
		int[] arr = new int[n];
		int[] lis = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(100);
			lis[i] = 1;
		}
		
		for(int i = 0; i < n - 1; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println(arr[n - 1]);
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		int seq = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(lis[i] > seq)
				seq = lis[i];
		}	
		
		System.out.println("The longest increasing subsequence is " + seq);
		
	}
	
}

