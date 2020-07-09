package map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		String string = "一粒尘可填海，一根草斩尽日月星辰，弹指间天翻地覆。\r\n" + 
				"群雄并起，万族林立，诸圣争霸，乱天动地。问苍茫大地，谁主沉浮？！\r\n" + 
				"一个少年从大荒中走出，一切从这里开始……";
		Map<Character, Integer> map = cout(string);
		System.out.println(map);
		System.out.println("------------------------------------");
		}

	private static Map<Character, Integer> cout(String string) {
		Map<Character, Integer>  map= new HashMap<Character, Integer>();
		Integer ix = 1;
		for (int i = 0; i < string.length(); i++) {
			Character character = string.charAt(i);
			if (map.containsKey(character)) {
				map.put(character,map.get(character)+1);
			}
			else {
				map.put(character, ix);
			}
		}
		return map;
	}

}
