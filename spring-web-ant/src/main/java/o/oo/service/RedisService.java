package o.oo.service;


public interface RedisService {
    void store(String key, String value);
    String retrieve(String key);
}