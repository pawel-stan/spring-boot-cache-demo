package edu.logintegra.springbootcachedemo.redistags;

import org.springframework.data.repository.CrudRepository;

public interface RedisTagRepository extends CrudRepository<RedisTag, String> {
}
