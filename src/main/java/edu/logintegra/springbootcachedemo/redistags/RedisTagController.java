package edu.logintegra.springbootcachedemo.redistags;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisTagController {

    private final RedisTagRepository redisTagRepository;

    public RedisTagController(RedisTagRepository redisTagRepository) {
        this.redisTagRepository = redisTagRepository;
    }

    @PostMapping("/save")
    public void save(@RequestParam String name) {
        RedisTag redisTag = new RedisTag();
        // redisTag.setId("???"); // Jeśli nie podamy `id`, Redis utworzy je automatycznie
        redisTag.setName(name);

        redisTagRepository.save(redisTag);
    }

    @GetMapping("/list")
    public Iterable<RedisTag> list() {
        return redisTagRepository.findAll();
    }
}
