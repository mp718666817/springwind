package Algorithm;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	String string = "";
    	if (strs.length==1) {
			return strs[0];
		}
    	boolean flag = false;
    	for (int i = 0; i < strs.length; i++) {
			
		}
    	while (true) {
    		int num = 0;
			for (int i = 0; i < strs.length; i++) {
				char c = strs[i].charAt(num);
				if (i == strs.length - 1 && flag == true) {
					string += c;
				}
				if (strs[i].charAt(num) != c) {
					return string;
				} else {
					flag = true;
				}
			}
			num++;
    	}
    }
}
