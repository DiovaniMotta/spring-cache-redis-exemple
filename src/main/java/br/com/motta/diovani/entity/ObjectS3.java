package br.com.motta.diovani.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "objects_from_s3")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObjectS3 {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    UUID id;
    @Column(length = 1000)
    String path;
    @Column(length = 1000)
    String tenant;
    @Column(name = "object_id",length = 1000)
    String objectId;
    @Column(name = "file_name",length = 1000)
    String fileName;
    @Column(name = "last_modified_date")
    LocalDateTime lastModifiedDate;
    @Column(name = "file_size_byte")
    Long size;
}
