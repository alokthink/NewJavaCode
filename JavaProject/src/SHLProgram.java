import java.util.Scanner;

public class SHLProgram {
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOfProduct=sc.nextInt();
		String[] ch=new String[noOfProduct];
		for(int i=0;i<noOfProduct;i++) {
			ch[i]=sc.nextLine();
		}
		String[] totalProd= {"a","i","o","L","A"};
		System.out.println(ch);
		int cout=0;
		for(int i=0;i<noOfProduct;i++) {
			for(int j=0;j<totalProd.length;j++) {
				if(ch[i].equals(totalProd[j])) {
					cout++;
				}
			}

		}
		
		System.out.println(cout);

	}

}
