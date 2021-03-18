
public class Quest2 {

	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5};
		StringBuilder b=new StringBuilder();
		int k=3;
		for(int i=k-1;i>=0;i--) {
			b.append(arr[i]);
		}
		for(int n=arr.length-1;n>=k;n--) {
			b.append(arr[n]);	
		}
		
		System.out.println(b);
	}

}
