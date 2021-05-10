package com.thattallprogrammer.Thoth.checklist;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Checklist
{
  private @Id String id;

  private @Temporal(TemporalType.DATE) Date dateAccepted;

  private String title;

  @Column(columnDefinition = "TEXT")
  private String description;

  private String notice;

  //  private BenchmarkReference reference;

  private String releaseInfo;

  private String version;

  public Checklist()
  {
  }

  public Checklist(String id, Date dateAccepted, String title, String description, String notice, String releaseInfo, String version)
  {
    this.id = id;
    this.dateAccepted = dateAccepted;
    this.title = title;
    this.description = description;
    this.notice = notice;
    this.releaseInfo = releaseInfo;
    this.version = version;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public Date getDateAccepted()
  {
    return dateAccepted;
  }

  public void setDateAccepted(Date dateAccepted)
  {
    this.dateAccepted = dateAccepted;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getNotice()
  {
    return notice;
  }

  public void setNotice(String notice)
  {
    this.notice = notice;
  }

  public String getReleaseInfo()
  {
    return releaseInfo;
  }

  public void setReleaseInfo(String releaseInfo)
  {
    this.releaseInfo = releaseInfo;
  }

  public String getVersion()
  {
    return version;
  }

  public void setVersion(String version)
  {
    this.version = version;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Checklist checklist = (Checklist) o;
    return Objects.equals(id, checklist.id);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(id);
  }

  @Override
  public String toString()
  {
    return "Checklist{" +
        "id='" + id + '\'' +
        ", dateAccepted=" + dateAccepted +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", notice='" + notice + '\'' +
        ", releaseInfo='" + releaseInfo + '\'' +
        ", version='" + version + '\'' +
        '}';
  }
}
