package com.crud.sheet.security;

import com.crud.sheet.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


@Data
@RequiredArgsConstructor
public class RegistrationForm {

  private String username;
  private String password;
  private String name;
  
  public User toUser(PasswordEncoder passwordEncoder) {
    return new User(username, passwordEncoder.encode(password), name);
  }
  
}
