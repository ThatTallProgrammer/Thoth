package com.thattallprogrammer.Thoth.cci;

import com.thattallprogrammer.Thoth.cci.reference.CciReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
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

  @ManyToMany
  private Set<CciReference> references = new HashSet<>();

  public Cci()
  {
  }

  public Cci(String cciId, String status, Date publishDate, String contributor,
             String type, String parameter, String definition, String note)
  {
    this.cciId = cciId;
    this.status = status;
    this.publishDate = publishDate;
    this.contributor = contributor;
    this.type = type;
    this.parameter = parameter;
    this.definition = definition;
    this.note = note;
  }

  public String getCciId()
  {
    return cciId;
  }

  public void setCciId(String cciId)
  {
    this.cciId = cciId;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public Date getPublishDate()
  {
    return publishDate;
  }

  public void setPublishDate(Date publishDate)
  {
    this.publishDate = publishDate;
  }

  public String getContributor()
  {
    return contributor;
  }

  public void setContributor(String contributor)
  {
    this.contributor = contributor;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getParameter()
  {
    return parameter;
  }

  public void setParameter(String parameter)
  {
    this.parameter = parameter;
  }

  public String getDefinition()
  {
    return definition;
  }

  public void setDefinition(String definition)
  {
    this.definition = definition;
  }

  public String getNote()
  {
    return note;
  }

  public void setNote(String note)
  {
    this.note = note;
  }

  public Set<CciReference> getReferences()
  {
    return references;
  }

  public void setReferences(Set<CciReference> references)
  {
    this.references = references;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cci cci = (Cci) o;
    return Objects.equals(cciId, cci.cciId);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(cciId);
  }

  @Override
  public String toString()
  {
    return "Cci{" +
        "cciId='" + cciId + '\'' +
        ", status='" + status + '\'' +
        ", publishDate=" + publishDate +
        ", contributor='" + contributor + '\'' +
        ", type='" + type + '\'' +
        ", parameter='" + parameter + '\'' +
        ", definition='" + definition + '\'' +
        ", note='" + note + '\'' +
        '}';
  }
}