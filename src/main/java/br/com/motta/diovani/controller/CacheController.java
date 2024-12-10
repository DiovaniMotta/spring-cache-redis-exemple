package br.com.motta.diovani.controller;

import br.com.motta.diovani.services.CacheService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/cache")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CacheController {
    
    CacheService service;

    @GetMapping("/clear/{name}")
    public void clearCache(@PathVariable String name) {
        service.clearCache(name);
    }
}
