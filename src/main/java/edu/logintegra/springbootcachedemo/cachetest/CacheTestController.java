package edu.logintegra.springbootcachedemo.cachetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CacheTestController {

    private final CacheTestService cacheTestService;

    @Autowired
    public CacheTestController(CacheTestService cacheTestService) {
        this.cacheTestService = cacheTestService;
    }

    @GetMapping(path = "/square")
    public String square(@RequestParam int x) {
        return cacheTestService.square(x);
    }
}
