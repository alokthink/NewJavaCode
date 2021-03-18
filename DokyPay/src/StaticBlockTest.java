
public class StaticBlockTest {


		 public static StaticBlockTest tt=new StaticBlockTest();  
	     public StaticBlockTest(){  
	        System.out.print("a");  
	    } 
	    {
	        System.out.print("b");  
	    }
	    static{  
	        System.out.print("c"); 
	    }  
	    public static void main(String args[]){  
	         new StaticBlockTest();
	    }     
	}


