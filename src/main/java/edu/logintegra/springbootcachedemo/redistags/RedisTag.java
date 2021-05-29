package edu.logintegra.springbootcachedemo.redistags;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("redis-tags")
@Getter
@Setter
public class RedisTag implements Serializable {

    @Id
    private String id;

    private String name;
}
