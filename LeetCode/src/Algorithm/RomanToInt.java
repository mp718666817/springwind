package Algorithm;

public class RomanToInt {
    public int romanToInt(String s) {
		int num = 0;
    	for (int i = 0; i < s.length(); i++) {
			/*
			 * if (s.charAt(i)=='I') { if
			 * (s.charAt(i+1)=='V'||s.charAt(i+1)=='X'&&i+1<s.length()) { num = num - 1; }
			 * else { num = num + 1; } } if () {
			 * 
			 * }
			 */
    		switch (s.charAt(i)) {
			case 'I':
				if(i+1<s.length()&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')) 
				{ num = num - 1;}
				else {
					num = num+1;
				}
				break;
			case 'V':
				num = num+5;
				break;
			case 'X':
				if(i+1<s.length()&&(s.charAt(i+1)=='C'||s.charAt(i+1)=='L'))
					num = num -10;
				else {
					num+=10;
				}
				break;
			case 'L':
				num+=50;
				break;
			case 'C':
				if(i+1<s.length()&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M'))
					num-=100;
				break;
			case 'D':
				num+=500;
				break;
			case 'M':
				num+=1000;
				break;
			default:
				break;
			}
		}
    	return num;
    }
    public static void main(String[] args) {
		RomanToInt int1 = new RomanToInt();
		String string = "LVIII";
		System.out.println(int1.romanToInt(string));
	}
}
