package com.vbradara.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY /*SEQUENCE*/)
  private Long id;

  @Version
  private int version;

}
