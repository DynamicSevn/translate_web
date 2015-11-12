package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		for(int i = 0;i<count;i++){
			int allCount = scan.nextInt();
			int countPer = scan.nextInt();
			if(allCount%(countPer+1)>0)
				System.out.println("Win");
			else System.out.println("Lose");
		}
	}

}
