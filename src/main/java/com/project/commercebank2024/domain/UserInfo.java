package com.project.commercebank2024.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long uId;

  @Column(unique = true)
  private String userName;

  private String password;
  private String role;
  private Timestamp createdAt;
  private Timestamp modifiedAt;
  private Timestamp lastLogin;
  private Timestamp lastFailedLogin;
  private int consFailedLoginAttempts;
  private String createdBy;
  private String modifiedBy;
  private String userEmail;

  @OneToMany(mappedBy = "userInfo")
  @JsonIgnore
  private List<UserApps> userApps = new ArrayList<>();

  public void addUserApps(UserApps appToAdd) {
    userApps.add(appToAdd);
  }
}
