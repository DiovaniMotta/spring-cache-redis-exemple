package br.com.motta.diovani.infra.cache;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ComponentScan(basePackages = { "br.com.motta.diovani.infra.cache" })
@FieldDefaults(level = AccessLevel.PROTECTED)
public class RedisConfiguration {

    @Value("${spring.redis.host:localhost}")
    String host;

    @Value("${spring.redis.port:6379}")
    int port;

    @Value("${spring.redis.password:}")
    String password;

    @Value("${spring.redis.database:0}")
    int database;
}
