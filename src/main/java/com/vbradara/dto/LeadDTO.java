package com.vbradara.dto;

import com.vbradara.model.LeadDO;
import com.vbradara.model.UserDO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class LeadDTO {
  private Long id;
  @Valid
  @NotNull
  private UserDTO data;


  public LeadDTO(LeadDO lead) {
    this.id = lead.getId();
    this.data = new UserDTO(lead.getUser());
  }


  public LeadDO toDO() {
    LeadDO leadDO = new LeadDO();
    UserDO userDO = data.toDO();
    leadDO.setUser(userDO);
    return leadDO;

  }
}
