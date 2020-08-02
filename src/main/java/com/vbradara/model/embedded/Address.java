package com.vbradara.model.embedded;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

  private String country;
  private String place;
  private String street;
  private String zipCode;

}
