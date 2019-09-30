#!/usr/bin/env groovy

@GrabResolver(name='Maven Central', root='http://repo1.maven.org/')
@Grab(group='io.lettuce', module='lettuce-core', version='5.1.8.RELEASE')

import io.lettuce.core.RedisClient
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.sync.RedisStringCommands

RedisClient client = RedisClient.create("redis://localhost");
StatefulRedisConnection<String, String> connection = client.connect();
RedisStringCommands sync = connection.sync();

sync.set("lettuce-core", "5.1.8.RELEASE")
String value = sync.get("lettuce-core");
println value