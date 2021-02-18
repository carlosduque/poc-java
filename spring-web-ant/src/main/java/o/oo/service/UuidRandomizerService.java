package o.oo.service;

import java.util.UUID;

public class UuidRandomizerService implements RandomizerService {
    public String generate() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
