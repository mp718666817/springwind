import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.pojo.User;
import redis.clients.jedis.Jedis;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.94.130", 6379);
        String name = jedis.get("name");
        System.out.println(name);
        String user = jedis.get("user");
        String substring = user.substring(23, 45);

        System.out.println(user);
        System.out.println(substring);
        JSONObject objects = JSONObject.parseObject(substring);
        User user1 = JSONObject.parseObject(objects.toJSONString(), new TypeReference<User>() {
        });
        System.out.println(user1);
    }
}
