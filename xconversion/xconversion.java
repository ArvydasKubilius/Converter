
import static java.lang.Math.toIntExact;


public class xconversion {
  public static String xBToD (String s){
	int o = 0;
	int lngth = s.length();
	if (s.charAt(0) == '0'){
		for (int i=0; i <lngth; i++){
			if (s.charAt(i) == '1'){
				o = o + sqr(2, (lngth-i-1));	
			}
		
		}
	}else {
		o = sqr(2, (lngth));
		String revS = "";
		for (int j=0; j<lngth; j++){
			if (s.charAt(j) == '0'){
				revS = revS + "1";
			} else {
				revS = revS + "0";
			}
		}
		for (int i=0; i <lngth; i++){
			if (s.charAt(i) == '1'){
				o = o - sqr(2, (lngth-i-1));	
			}
		
		}
		o = 0 - o;
	
	
		
	}
	
    String k = Integer.toString(o);
    return k;
	}
	
  public static String xDToB (String o){
	int n = Integer.parseInt(o);
	String s = "";
	if (n < 128 && n > -128){
		if (n >= 0){
		s = s + "0";
		for (int i=0; i<7; i++){
			if(n >= sqr(2,(6-i))){
				s = s + "1";
				n = n - sqr(2, (6-i));
			} else {
				s = s + "0";
			}
		}
		} else{
			s = s + "1";
			n = sqr(2, 7) + n ;
			for (int i=0; i<7; i++){
			if(n >= sqr(2,(6-i))){
				s = s + "1";
				n = n - sqr(2, (6-i));
			} else {
				s = s + "0";
			}
		}
			
		}
			
	} else if (n <32767 && n > -32768){
		if (n > 0){
		s = s + "0";
		for (int i=0; i<15; i++){
			if(n >= sqr(2,(14-i))){
				s = s + "1";
				n = n - sqr(2, (14-i));
			} else {
				s = s + "0";
			}
		}
		} else{  ///negatyvai
			s = s + "1";
			n = sqr(2, 15) + n ;
			for (int i=0; i<15; i++){
			if(n >= sqr(2,(14-i))){
				s = s + "1";
				n = n - sqr(2, (14-i));
			} else {
				s = s + "0";
			}
		}
			
		}
		//baigiasi
	} else {
		if (n > 0){
		s = s + "0";
		for (int i=0; i<31; i++){
			if(n >= sqr(2,(30-i))){
				s = s + "1";
				n = n - sqr(2, (30-i));
			} else {
				s = s + "0";
			}
		}
		} else {
			s = s + "1";
			n = sqr(2, 31) + n ;
			for (int i=0; i<31; i++){
			if(n >= sqr(2,(30-i))){
				s = s + "1";
				n = n - sqr(2, (30-i));
			} else {
				s = s + "0";
			}
		}
		} 
	}

	return s;
  }
  
  public static String xHToB (String o){
    String digits = "0123456789ABCDEF";// visas raidynas
     String s = "";
    o = o.toUpperCase();
    int val = 0;
    for (int i = 0; i < o.length(); i++) {
		char c = o.charAt(i);
        int d = digits.indexOf(c);
        val = 16*val + d;
    }
     int n = val;
	if (o.length() < 3){
		//8bitu

		for (int i=0; i<8; i++){
		if(n >= sqr(2,(7-i))){
			s = s + "1";
			n = n - sqr(2, (7-i));
		} else {
			s = s + "0";
		}
	}

	} else if (o.length() < 5){
		// 16 bitu

		for (int i=0; i<16; i++){
		if(n >= sqr(2,(15-i))){
			s = s + "1";
			n = n - sqr(2, (15-i));
		} else {
			s = s + "0";
		}
	}

	} else {
		s = s + "0";
		for (int i=0; i<31; i++){
		if(n >= sqr(2,(30-i))){
			s = s + "1";
			n = n - sqr(2, (30-i));
		} else {
			s = s + "0";
		}
	}

	}
	return s;
  }
  
  public static String xHToD (String n){
	  return xBToD(xHToB(n));
  }
  
    public static String xBToH (String s){
	long o = 0;
	int lngth = s.length();
	if (lngth == 32){
			if (s.charAt(0) == '1'){
				o = o + sqr(2, (lngth-2));
				o = o * 2;
			}
			for (int i=1; i <lngth; i++){
			if (s.charAt(i) == '1'){
				o = o + sqr(2, (lngth-i-1));	
			}
			
	}
	}	else {
	for (int i=0; i <lngth; i++){
			if (s.charAt(i) == '1'){
				o = o + sqr(2, (lngth-i-1));	
			}
		
	}
	}
	long n = o;
	String k = "";
	String digits = "0123456789ABCDEF";
	while (n > 0){
		long num = n % 16;
		int numInt = toIntExact(num);
		k = digits.charAt(numInt) + k;
		n = n / 16;
		
	}
	if (k.equals("")){
		k = "0";
	}
return k;	
  }
  
  public static String xDToH (String s){
	  return xBToH(xDToB(s));
  }
    public static int sqr (int n, int k){
	  int o = 1;
	  for (int i=0; i<k; i++){
		o = o * n;
	  }
	  return o;
  }
}