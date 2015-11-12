package test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	
	private static class Rectangle{
		
		int num;
		int length;
		int wide;
		Rectangle(){}
		
		@SuppressWarnings("unused")
		Rectangle(int num,int length,int wide){
			this.length = length;
			this.num = num;
			this.wide = wide;
		}
		
		int getNum() {
			return num;
		}
		void setNum(int num) {
			this.num = num;
		}
		int getLength() {
			return length;
		}
		void setLength(int length) {
			this.length = length;
		}
		int getWide() {
			return wide;
		}
		void setWide(int wide) {
			this.wide = wide;
		}
		
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		for(int i = 0;i<count;i++){
			List<Rectangle> recList = new ArrayList<Rectangle> ();
			int recCount = scan.nextInt();
			for(int j = 0;j<recCount;j++){
				
				Rectangle rec = new Rectangle();
				int num = scan.nextInt();
				rec.setNum(num);
				int para_1 = scan.nextInt();
				int para_2 = scan.nextInt();
				if(para_1>para_2){
					rec.setLength(para_1);
					rec.setWide(para_2);
				}else {
					rec.setWide(para_1);
					rec.setLength(para_2);
				}
				recList.add(rec);
			}//以上为初始化工作
			
			List<Rectangle> newRecList = new ArrayList<Main.Rectangle>();
			Rectangle[] recArray = new Rectangle[recList.size()];
			recList.toArray(recArray);
			for(int j = 0;j<recArray.length-1;j++){
				int minRec = j;
				for(int k = j+1;k<recArray.length;k++){
					int flag = 0;//交换标志
					if(recArray[minRec].num>recArray[k].num)
						flag = 1;
					else if(recArray[minRec].getNum()==recArray[k].getNum()){
						if(recArray[minRec].length>recArray[k].length)
							flag = 1;
						else if(recArray[minRec].getLength()==recArray[k].getLength())
						{
							if(recArray[minRec].wide>recArray[k].wide)
								flag = 1;
						}
					}
					if(flag==1){
						minRec = k;
					}
				}
				
				Rectangle rec = new Rectangle();
				rec = recArray[j];
				recArray[j] = recArray[minRec];
				recArray[minRec] = rec;
			}//排序
			
			newRecList.add(recArray[0]);
			for(int j = 1;j<recArray.length;j++){
				if(recArray[j].getNum()==newRecList.get(newRecList.size()-1).getNum()&&
						recArray[j].getLength()==newRecList.get(newRecList.size()-1).getLength()&&
						recArray[j].getWide()==newRecList.get(newRecList.size()-1).getWide())
					continue;
				else newRecList.add(recArray[j]);
			}//去重
			
			
			for(Rectangle rec : newRecList){
				System.out.println(rec.getNum()+" "+rec.getLength()+" "+rec.getWide());
			}//输出
		}
	}
}
