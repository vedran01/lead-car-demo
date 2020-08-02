package com.vbradara.model;

import javax.persistence.*;

@Entity
@Table(name = "leads")
@AttributeOverride(name = "id", column = @Column(name = "lead_id"))
public class LeadDO extends AbstractAuditEntity {

  @OneToOne(optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", unique = true)
  private UserDO user;

  public UserDO getUser() {
    return user;
  }

  public void setUser(UserDO user) {
    this.user = user;
  }
}
