package map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {

	public static void main(String[] args) {
		String s = "人物、情节、环境是小说的三要素。情节一般包括开端、发展、高"
				+ "潮、结局四部分，有的包括序幕、尾声。环境包括自然环境和社会环境。 "
				+ "小说按照篇幅及容量可分为长篇、中篇、短篇和微型小说（小小说）。"
				+ "按照表现的内容可分为神话、仙侠、武侠、科幻、悬疑、古传、当代、浪漫青春"
				+ "、游戏竞技等。按照体制可分为章回体小说、日记体小说、书信体小说、自传体小说。"
				+ "按照语言形式可分为文言小说和白话小说。";
		System.out.println(1.0/s.length());
		Map<Character, Double> hashMap = new HashMap<Character, Double>();
		hashMap=MapDemo1.geMap(hashMap, s);
		System.out.println(hashMap);
	}
	public static Map<Character, Double> geMap(Map<Character, Double> map,String string){
		double d = 1.0/string.length();
		Character character;
		for (int i = 0; i < string.length(); i++) {
			character = string.charAt(i);
			if (map.containsKey(character)) {
				map.put(character, d+map.get(character));
			}
			else {
				map.put(character, d);
			}
		}
		return map;
	}

}
