package com.mps.think.util;
import java.util.ArrayList;
import java.util.List;


public class EmailAuthorizationUtility 
{

	public static int getValueBasedOnLogic(int index)
	{
		 int result =0;
		 byte val1 =0;          			
         byte Modval = (byte)(index % 8);			
         val1 |= (byte)(1 << (Modval));			
		if(val1<0)
		{
			 result =0-val1;
        }else
        {
        	result =val1;
        }
		return result;
	}
	
		
	public static String addBinaryNumbers(List<String>binaryEquivalentArrayList) 
	{
		int sum=Integer.parseInt("0", 2);
	   for(int i=0;i<binaryEquivalentArrayList.size();i++)
	   {
		    int b = Integer.parseInt(binaryEquivalentArrayList.get(i), 2);
		    sum = sum + b;
	   }
	    return Integer.toBinaryString(sum);
	}
	
	
	public static String convertBinaryToHexadecimal(String binary)
	{
		String hexadecimal="";
		List<String> hexadecimalList=new ArrayList<String>();
		int[] hex = new int[1000];
		int i = 1, j = 0, rem, dec = 0, bin;
		bin = Integer.parseInt(binary);
		while (bin > 0) 
		{
		   rem = bin % 2;
		   dec = dec + rem * i;
		   i = i * 2;
		   bin = bin / 10;
		}
		i = 0;
		while (dec != 0) 
		{
		   hex[i] = dec % 16;
		   dec = dec / 16;
		   i++;
		}
		for (j = i - 1; j >= 0; j--)
		{
		   if (hex[j] > 9) 
		   {
			   hexadecimalList.add(""+(char)(hex[j] + 55));
		   } else
		   {
			   hexadecimalList.add(""+hex[j]);
		   }
		}
		for(String hexStr:hexadecimalList)
		{
			hexadecimal=hexadecimal+hexStr+"";
		}
		return hexadecimal;
	}
	
	
	public static String convertHexadecimalToBinary(String hexadecimal) 
	{ 
		char hexdec[] = new char[100] ; 
		hexdec = hexadecimal.toCharArray() ;
		String binaryEquivalent="";
		try
		{
			int i = 0; 
			while (hexdec[i] != '\u0000') 
			{ 
				switch (hexdec[i]) 
				{ 
					case '0': 
					{	
						binaryEquivalent=binaryEquivalent+"0000";
						break;
					}	
					case '1': 
					{	
						binaryEquivalent=binaryEquivalent+"0001";
						break; 
					}case '2': 
					{	
						binaryEquivalent=binaryEquivalent+"0010";
						break;
					} 
					case '3': 
					{	
						binaryEquivalent=binaryEquivalent+"0011";
						break;
					} 
					case '4': 
					{	
						binaryEquivalent=binaryEquivalent+"0100";
						break;
					}
					case '5': 
					{	
						binaryEquivalent=binaryEquivalent+"0101";
						break; 
					}
					case '6': 
					{	 
						binaryEquivalent=binaryEquivalent+"0110";
						break; 
					}
					case '7': 
					{	
						binaryEquivalent=binaryEquivalent+"0111";
						break; 
					}
					case '8': 
					{	 
						binaryEquivalent=binaryEquivalent+"1000";
						break; 
					}
					case '9': 
					{	 
						binaryEquivalent=binaryEquivalent+"1001";
						break; 
					}
					case 'A': 
					case 'a': 
					{	 
						binaryEquivalent=binaryEquivalent+"1010";
						break; 
					}
					case 'B': 
					case 'b': 
					{	 
						binaryEquivalent=binaryEquivalent+"1011";
						break; 
					}
					case 'C': 
					case 'c': 
					{
						binaryEquivalent=binaryEquivalent+"1100";
						break; 
					}
					case 'D': 
					case 'd': 
					{	
						binaryEquivalent=binaryEquivalent+"1101";
						break; 
					}
					case 'E': 
					case 'e': 
					{
						binaryEquivalent=binaryEquivalent+"1110";
						break;
					} 
					case 'F': 
					case 'f': 
					{ 
						binaryEquivalent=binaryEquivalent+"1111";
						break;
					} 
					default: 
					{
						binaryEquivalent=binaryEquivalent+"Invalid hexadecimal digit "+ hexdec[i];
					} 
				} 
				i++; 
			}
			if(binaryEquivalent.contains("Invalid hexadecimal digit"))
			{
				binaryEquivalent="Invalid hexadecimal digit found in input = "+hexadecimal;
			}
			return binaryEquivalent; 
		}
		catch (ArrayIndexOutOfBoundsException e)
		{ 
			if(binaryEquivalent.contains("Invalid hexadecimal digit"))
			{
				binaryEquivalent="Invalid hexadecimal digit found in input = "+hexadecimal;
			}
			return binaryEquivalent; 
		} 
	} 
}