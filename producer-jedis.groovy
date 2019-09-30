#!/usr/bin/env groovy

@GrabResolver(name='Maven Central', root='http://repo1.maven.org/')
@Grab(group='redis.clients', module='jedis', version='3.1.0')
import redis.clients.jedis.Jedis

Jedis jedis = new Jedis("localhost", 6379, 0)
jedis.connect();

jedis.lpush("queue#tasks", "firstTask");
jedis.lpush("queue#tasks", "secondTask");
 
String task = jedis.rpop("queue#tasks");
println task