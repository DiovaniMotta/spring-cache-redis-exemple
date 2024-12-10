package br.com.motta.diovani.services;

import br.com.motta.diovani.entity.ObjectS3;
import br.com.motta.diovani.repository.ObjectS3Repository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ObjectS3Service {

    ObjectS3Repository repository;

    @Cacheable(value = "objects_S3_elements",key = "'findAll_' + #page + '_' + #size")
    public List<ObjectS3> findAll(int page, int size) {
        System.err.println(format("%s (findAll) - Buscando registros no banco de dados. Página: %d, Tamanho: %d", this.getClass().getSimpleName(), page, size));
        Pageable pageable = PageRequest.of(page, size);
        var recordsPageable = repository.findAll(pageable);
        return recordsPageable.getContent();
    }

    @Cacheable(value = "objects_S3_names", key = "'listByName_' + #page + '_' + #size")
    public List<String> listByName(int page, int size) {
        System.err.println(format("%s (listByName) - Buscando registros no banco de dados. Página: %d, Tamanho: %d", this.getClass().getSimpleName(), page, size));
        Pageable pageable = PageRequest.of(page, size);
        var recordsPageable = repository.findAll(pageable);
        return recordsPageable.stream()
                .map(ObjectS3::getFileName)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "objects_S3_id_names", key = "'listByIdAndName_' + #page + '_' + #size")
    public Map<UUID, String> listByIdAndName(int page, int size) {
        System.err.println(format("%s (listByIdAndName) - Buscando registros no banco de dados. Página: %d, Tamanho: %d", this.getClass().getSimpleName(), page, size));
        Pageable pageable = PageRequest.of(page, size);
        var recordsPageable = repository.findAll(pageable);
        var contents = recordsPageable.getContent();
        if(Objects.isNull(contents)) {
            return Collections.emptyMap();
        }
        return contents.stream()
                .collect(Collectors.toMap(ObjectS3::getId, ObjectS3::getFileName));
    }
}
