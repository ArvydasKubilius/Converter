
public class conversion {
  
	public static String bToH(String n){
		return dToH(bToD(n));
	}
	
	public static String hToB(String n){
		return dToB(hToD(n));
	}
	

	
    public static int sqr (int n, int k){
	  int o = 1;
	  for (int i=0; i<k; i++){
		o = o * n;
	  }
	  return o;
  }
  public static String bToD (String s){
	int n = 0;
	for (int i=0;i < 8; i++){
		if (s.charAt(i) == '1'){
		n = n + sqr(2, (7-i));	
		}
	}
	String o = Integer.toString(n);
	return o;
  }
  public static String hToD (String s){
    String digits = "0123456789ABCDEF";
    s = s.toUpperCase();
    int val = 0;
    for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
        int d = digits.indexOf(c);
        val = 16*val + d;
    }
	String o = Integer.toString(val);
	return o; 
  }
  public static String dToB (String o){
	int n = Integer.parseInt(o);
	String s = "";
	for (int i=0; i<8; i++){
		if(n >= sqr(2,(7-i))){
			s = s + "1";
			n = n - sqr(2, (7-i));
		} else {
			s = s + "0";
		}
	}
	return s;
  }
  public static String dToH (String o){
		int n = Integer.parseInt(o);
	String digits = "0123456789ABCDEF";
	int k = n / 16;
	String s = "";
	s = s + digits.charAt(k) ;
	s = s + digits.charAt(n % 16);
	return s;
	  
  }
}
