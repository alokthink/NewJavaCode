
public class Frogram3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stu 
		int []arr= {1,2,3,4,5,6,7};
		 int j=arr.length-1;
		 int k=0; 
		 StringBuilder s=new StringBuilder();
		 for(int i=0;i<(arr.length/2)+1;i++) {
			 if(k==j) {
				 s.append(arr[j]); 
			 }else {
				 s.append(arr[j]);
				 s.append(arr[k]);
				 j--;
				 k++;   
			 }
			 
		     
		 }  
		 System.out.println(s);
		 

			
			

}
}
