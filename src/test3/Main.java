package test3;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int count = scan.nextInt();
		scan.nextLine();
		for(int i = 0;i<count;i++){
			
			String subStr = scan.nextLine();
			String mainStr = scan.nextLine();
			if(subStr.length()<=10&&mainStr.length()>=subStr.length()){
			int index = 0;
			int results = 0;
			do{
				index = mainStr.indexOf(subStr, index);
				if(index>=0)
					results++;
				index++;
			}while(index>0);
			System.out.println(results);
			}
		}
		scan.close();
		
	}
}
