package com.thattallprogrammer.Thoth.data.cci.reference;

import com.thattallprogrammer.Thoth.data.cci.Cci;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CciReference
{
  private @Id String index;
  private String creator;
  private String title;
  private String version;
  private String location;

  @ManyToMany(mappedBy = "references")
  Set<Cci> ccis = new HashSet<>();

  public String getIndex()
  {
    return index;
  }

  public void setIndex(String index)
  {
    this.index = index;
  }

  public String getCreator()
  {
    return creator;
  }

  public void setCreator(String creator)
  {
    this.creator = creator;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getVersion()
  {
    return version;
  }

  public void setVersion(String version)
  {
    this.version = version;
  }

  public String getLocation()
  {
    return location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CciReference that = (CciReference) o;
    return Objects.equals(index, that.index) && Objects.equals(creator, that.creator) && Objects.equals(title, that.title) && Objects.equals(version, that.version) && Objects.equals(location, that.location);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(index, creator, title, version, location);
  }
}
