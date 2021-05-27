package edu.logintegra.springbootcachedemo.cachetest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheTestService {

    private final Logger log = LoggerFactory.getLogger(CacheTestService.class);

    @Cacheable(value = "demo-cache", key = "#x", condition = "#x > 5")
    public String square(int x) {
        Integer result = x * x;

        log.info("Kwadrat z " + x + " to " + result + ".");

        return String.valueOf(result);
    }
}
