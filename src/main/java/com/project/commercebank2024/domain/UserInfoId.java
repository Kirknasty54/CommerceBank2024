package com.project.commercebank2024.domain;

import java.io.Serializable;
import java.util.Objects;

public class UserInfoId implements Serializable {

  private Long uId;
  private String userName;

  public UserInfoId() {
  }

  public UserInfoId(Long uId, String userName) {
    this.uId = uId;
    this.userName = userName;
  }

  // Getters and setters

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserInfoId that = (UserInfoId) o;
    return Objects.equals(uId, that.uId) && Objects.equals(userName, that.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uId, userName);
  }
}
