import java.util.HashMap;
class T{
private	 int x;
	 
	 
	private int getX() {
	return x;
}


public void setX(int x) {
	this.x = x;
}

}
public class sumPairs {
 

	public static void main(String[] args) {
		
		T t=new T();
	    t.setX(1);
		int arr1[] = {1, 0, -4, 7, 6, 4}; 
        int arr2[] = {0 , 4, -3, 2, 1}; 
        int x = 8; 
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr1.length;i++) {
        	map.put(arr1[i], 0);
        }
        for(int j=0;j<arr2.length;j++) {
        	if(map.containsKey(x-arr2[j])) {
        		System.out.println(x-arr2[j]+":"+arr2[j]);
        	}
        }

	}

}
