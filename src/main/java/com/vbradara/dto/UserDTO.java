package com.vbradara.dto;

import com.vbradara.model.UserDO;
import com.vbradara.model.embedded.Address;
import com.vbradara.model.embedded.Contact;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UserDTO {
  private Long id;
  private String username;
  private String password;
  @NotEmpty(message = "First name must not be empty")
  private String firstName;
  @NotEmpty(message = "Last name must not be empty")
  private String lastName;
  private Contact contact;
  private Address address;

  public UserDTO(UserDO user){
    setId(user.getId());
    setUsername(user.getUsername());
    setFirstName(user.getFirstName());
    setLastName(user.getLastName());
    setContact(user.getContact());
    setAddress(user.getAddress());
  }

  public UserDO toDO() {
    UserDO userDO = new UserDO();
    userDO.setFirstName(firstName);
    userDO.setLastName(lastName);
    userDO.setContact(contact);
    userDO.setAddress(address);

    if(username != null && !username.isEmpty()){
      userDO.setUsername(username);
    }

    if(password != null && !password.isEmpty()){
      userDO.setPassword(password);
    }

    return userDO;
  }
}
