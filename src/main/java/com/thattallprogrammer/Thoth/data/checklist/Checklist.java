package com.thattallprogrammer.Thoth.data.checklist;

import com.thattallprogrammer.Thoth.data.checklist.profile.Profile;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Checklist
{
  private @Id String checklistId;
  private @Temporal(TemporalType.DATE) Date dateAccepted;
  private String title;
  private String notice;
  //  private BenchmarkReference reference;
  private String releaseInfo;
  private String version;

  @Column(columnDefinition = "TEXT")
  private String description;

  @OneToMany(cascade=CascadeType.ALL)
  private Set<Profile> profiles;
}
