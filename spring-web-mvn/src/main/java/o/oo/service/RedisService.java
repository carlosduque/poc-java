package o.oo.service;


interface RedisService {
    void store(String key, String value);
    String retrieve(String key);
}