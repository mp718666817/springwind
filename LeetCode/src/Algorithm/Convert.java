package Algorithm;

public class Convert {
    public String convert(String s, int numRows) {
    	if (s==""||numRows==1||s==null||s.length()<numRows) {
			return s;
		}
    	String s1 = "";
    	for (int i = 0; i < numRows; i++) {
			for (int j = i; j< s.length() ;j = j+2*numRows-2) {
				s1 = s1+(s.charAt(j));
				if (i!=0&&i!=numRows-1&&j+2*numRows-2-2*i<s.length()) {
					s1=s1+s.charAt(j+2*numRows-2-2*i);
				}
			}
		}
    	return s1;
    }
    public static void main(String[] args) {
		Convert con = new Convert();
		String s1 = "PAYPALISHIRING" ;
		System.out.println(con.convert(s1,4));
	}
}
