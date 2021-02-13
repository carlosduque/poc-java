package o.oo.service;

public class DefaultRedisService implements RedisService {
 
    public void store(String key, String value) {
        System.out.println(key + ":" + value);
    }
    
    public String retrieve(String key) {
        return "default-string"
    }
}