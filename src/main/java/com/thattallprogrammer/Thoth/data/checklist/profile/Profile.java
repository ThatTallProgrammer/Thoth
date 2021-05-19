package com.thattallprogrammer.Thoth.data.checklist.profile;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Profile
{
  private @Id String id;

  private String Title;

  @Column(columnDefinition = "TEXT")
  private String description;
}
