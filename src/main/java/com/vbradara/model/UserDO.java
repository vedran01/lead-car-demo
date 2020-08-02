package com.vbradara.model;

import com.vbradara.model.embedded.Address;
import com.vbradara.model.embedded.Contact;

import javax.persistence.*;

@Entity
@Table(name = "user")
@AttributeOverride(name = "id", column = @Column(name = "userId"))
public class UserDO extends AbstractAuditEntity {
  @Column(nullable = false,unique = true)
  private String username;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Embedded
  private Contact contact;
  @Embedded
  private Address address;
  @OneToOne(mappedBy = "user", orphanRemoval = true)
  private LeadDO lead;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public LeadDO getLead() {
    return lead;
  }

  public void setLead(LeadDO lead) {
    this.lead = lead;
  }
}
