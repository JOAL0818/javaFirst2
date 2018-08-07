package july;

import java.util.Scanner;

public class Practice0726 {

	public static void main(String[] args) {

		
		int j = 1;
		while (j <= 3) {
			int i = 1;
			while (i<j+1) {
				System.out.printf("*");
				i++;
			}
			System.out.println("");
			j++;
		}
		j=1;
		while(j<3) {
		  int i=1;
		  while (i<j-1) {
			  System.out.printf("*");
				i++;
		  }
		  System.out.println("");
			j++;
		}
	}
}
