package longIncSubPack;

import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Random rand = new Random(); 
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("random.txt"));
		
		for(int i = 0; i < 100; i++) {
			if(i < 99)
				bw.write(rand.nextInt(1000) + ",");
			if(i == 99)
				bw.write(rand.nextInt(1000));
		}
		
		bw.close();
		
		
		BufferedReader br = new BufferedReader(new FileReader("random.txt"));
		
		String line = br.readLine();
		String[] arr = line.split(",");
		
		int greatestSequence = 0;
		int tempSequence = 0;
		int placeHolder = Integer.parseInt(arr[0]);
		
		int startOfSubsequence = -1;
		int endOfSubsequence = -1;
		
		int tempStartSeq = -1;
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(i == 0) {
				tempSequence = 1;
				tempStartSeq = 0;
			}
			else {
				int temp = Integer.parseInt(arr[i]);
				if(temp > placeHolder) {
					tempSequence++;
					placeHolder = Integer.parseInt(arr[i]);
					if(tempSequence == 1) {
						tempStartSeq = i;
					}
				}
				else if(temp <= placeHolder){
					placeHolder = Integer.parseInt(arr[i]);
					if(tempSequence > greatestSequence) {
						greatestSequence = tempSequence;
						startOfSubsequence = tempStartSeq;
						endOfSubsequence = i;
					}
					tempSequence = 0;
				}
			}
		}
		
		if(tempSequence > greatestSequence) {
			greatestSequence = tempSequence;
		}
		System.out.println("The greatest Increasing subsequence is: " + greatestSequence + " from " + startOfSubsequence + " to " + endOfSubsequence);

	}

}
