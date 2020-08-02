package com.vbradara.model.embedded;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Contact {

  private String mail;
  private String phone;
  private String fax;

}
