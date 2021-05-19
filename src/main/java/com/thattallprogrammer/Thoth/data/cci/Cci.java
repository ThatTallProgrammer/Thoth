package com.thattallprogrammer.Thoth.data.cci;

import com.thattallprogrammer.Thoth.data.cci.reference.CciReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cci
{
  private @Id String cciId;
  private String status;
  private @Temporal(TemporalType.DATE) Date publishDate;
  private String contributor;
  private String type;
  private String parameter;

  @Column(columnDefinition = "TEXT")
  private String definition;

  @Column(columnDefinition = "TEXT")
  private String note;

  @ManyToMany(cascade=CascadeType.ALL)
  private Set<CciReference> references = new HashSet<>();
}