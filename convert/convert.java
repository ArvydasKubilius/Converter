
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import com.axk680.conversion.*;
public class convert{
 public static void main(String[] args){
	 char inType;
	 char outType;
	 String line;
	 BufferedReader inputFile = null;
	 PrintWriter outputFile = null;
	if(!(args.length==3)){
		throw new IllegalArgumentException("Invalid input");
	}else if (!(args[0].length()==2)){
		throw new IllegalArgumentException("Invalid input");
	}else if (!((validTypeProp(args[0].charAt(0)))&&(validTypeProp(args[0].charAt(1))))) {
		throw new IllegalArgumentException("Invalid input");
	} else {
		inType = args[0].charAt(0);
		outType = args[0].charAt(1);
	}
	try {
		inputFile = new BufferedReader(new FileReader(args[1]));
		outputFile = new PrintWriter(new FileWriter(args[2]));
	}catch (IOException e){
		System.out.println(e);
		System.exit(1);
	}
	try {
		while((line = inputFile.readLine()) != null){
			outputFile.println(converter(line, inType, outType));
		}
		inputFile.close();
		outputFile.close();
	}	catch (IOException e) {
		System.out.println(e);
		System.exit(1);
	}
 }

  public static String converter (String line, char in, char out){
	String s = "";
	if (in =='b'){
		if (!((line.length() == 8 )&&checkB(line))){
			throw new IllegalArgumentException("Invalid input in data file ");
			
		}
		if(out == 'd'){
			s = conversion.bToD(line);
		}else if (out == 'h'){
			s = conversion.bToH(line);
		}
	}else if (in == 'd'){
		if (!((line.length() < 4)&&(checkD(line)))){
			throw new IllegalArgumentException("Invalid input in data file");
		}
		long n = Long.parseLong(line);
		if (!((0 <= n)&&(n <= 255 ))){
			throw new IllegalArgumentException("Invalid input in data file");
		}
		
		if(out == 'b'){
			s = conversion.dToB(line);
		}else if (out == 'h'){
			s = conversion.dToH(line);
		}
	}else if (in == 'h') {
		if(!((line.length() < 3)&&(checkH(line)))){
			throw new IllegalArgumentException("Invalid input in data file");
		}
		if(out == 'd'){
			s = conversion.hToD(line);
		}else if (out == 'b'){
			s = conversion.hToB(line);
		}	
	} else {
		s = line;
	}
	return s;
  }
  

  public static boolean validTypeProp(char n){
	if (n == 'b'||n == 'd'||n == 'h'){
		return true;
	} else {
		return false;
	}
  }
    public static boolean checkB(String s){
	  boolean b = true;
	  for (int i = 0; i < s.length() ; i++){
		  if (!((s.charAt(i)=='1')||(s.charAt(i)=='0'))){
			  b = false;
		  }
	  }
	  return b;
  }
  public static boolean checkD(String s){
	  boolean b = true;
	  for (int i = 0; i < s.length(); i++){
		  if(!((s.charAt(i)<58)&&(47<s.charAt(i)))){
			  b = false;
		  }
	  }
	  return b;
  }
  public static boolean checkH(String s){
	  boolean b = true;
	  for (int i = 0; i<s.length(); i++){
		  if(!(((s.charAt(i)<58)&&(47<s.charAt(i)))||((s.charAt(i)<71)&&(64<s.charAt(i))))){
			  b = false;
		  }
	  }
	  return b;
  }
}

