package br.com.motta.diovani.controller;

import br.com.motta.diovani.entity.ObjectS3;
import br.com.motta.diovani.services.ObjectS3Service;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/objects")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ObjectS3Controller {

    ObjectS3Service service;

    @GetMapping("/elements/{page}")
    public List<ObjectS3> findAll(@PathVariable int page){
        return service.findAll(page, 200);
    }

    @GetMapping("/names/{page}")
    public List<String> listByName(@PathVariable int page){
        return service.listByName(page, 200);
    }

    @GetMapping("/basic/{page}")
    public Map<UUID, String> listByIdAndName(@PathVariable int page){
        return service.listByIdAndName(page, 200);
    }
}
