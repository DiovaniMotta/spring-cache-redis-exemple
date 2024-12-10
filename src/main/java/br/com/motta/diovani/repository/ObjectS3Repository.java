package br.com.motta.diovani.repository;

import br.com.motta.diovani.entity.ObjectS3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ObjectS3Repository extends JpaRepository<ObjectS3, UUID> {
}
