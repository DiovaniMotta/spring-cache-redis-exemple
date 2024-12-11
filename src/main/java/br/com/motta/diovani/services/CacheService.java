package br.com.motta.diovani.services;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@EnableScheduling
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CacheService {

    CacheManager cacheManager;

    @Scheduled(fixedDelay = 3600000)
    public void clearCache() {
        System.err.println("Executando limpeza agendada do cache");
        Cache objectsCache = cacheManager.getCache("objects_S3_id_names");
           if(Objects.nonNull(objectsCache)) {
            System.err.println("Cache objects_S3_id_names limpo!");
            objectsCache.clear();
        }
    }

    public void clearCache(String cacheName) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
    }
}
