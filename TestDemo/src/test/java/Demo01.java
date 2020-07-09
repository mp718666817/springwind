import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo01 {
    public static void main(String[] args) {
        Integer[] arr = {-12345, 9999, 520, 0,-38,-7758520,941213};
        Stream<Integer> stream = Arrays.stream(arr);
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer>0)
                    return true;
                else return false;
            }
        };
        Predicate<Integer> p1 = (s) -> s>=0;

        Predicate<Integer> p0 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (Math.abs(integer)>100)
                    return true;
                else return false;
            }
        };
        Predicate<Integer> p2 = (s)->Math.abs(s)>=100;
        Predicate<Integer> p3 = (s)->s%2==0;
        //打印自然数的个数
        Stream<String> stream1 = Arrays.stream(args);
        stream.filter(p1).forEach(System.out::println);
    }
    @Test
    public void test() {
        Function<ArrayList<Integer>, Integer> f1 = new Function<ArrayList<Integer>, Integer>() {
            @Override
            public Integer apply(ArrayList<Integer> integers) {
                Integer sum = 0;
                for (Integer i : integers) {
                    sum+=i;
                }
                return  sum/integers.size();
            }
        };
        Function<Map<String,Integer>,ArrayList<Integer>> f2 = new Function<Map<String, Integer>, ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> apply(Map<String, Integer> stringIntegerMap) {
                ArrayList<Integer> integers = new ArrayList<>();
                for (Integer value : stringIntegerMap.values()) {
                    integers.add(value);
                }
                return integers;
            }
        };
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("岑小村", 59);
        map.put("谷天洛", 82);
        map.put("渣渣辉", 98);
        map.put("蓝小月", 65);
        map.put("皮几万", 70);

        //利用Function求平均成绩
        Integer avg = f2.andThen(f1).apply(map);
        System.out.println("学生平均成绩为："+avg);
    }
    @Test
    public void test01() {
        Integer[] arr = {-12345, 9999, 520, 0, -38, -7758520, 941213};
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            integers.add(arr[i]);
        }
        Stream<Integer> stream = Arrays.stream(arr);

        ArrayList<String> list = new ArrayList<>();
        list.add("陈玄风");
        list.add("梅超风");
        list.add("陆乘风");
        list.add("曲灵风");
        list.add("武眠风");
        list.add("冯默风");
        list.add("罗玉风");
        list.stream().skip(5).forEach(System.out::println);
        Stream<Integer> stream1 = Stream.of(1, -2, -3, 4,-5);
        stream.map(Math::abs).forEach(System.out::println);
    }
}
