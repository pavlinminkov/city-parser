package com.pavlin.model;

import java.util.List;

public class City {

  private final String id;
  private final String name;
  private final CityType type;
  private final String townHall;
  private final String phoneCode;
  private final String latitude;
  private final String longitude;
  private final List<String> postCodes;

  private City(CityBuilder cityBuilder) {
    this.id = cityBuilder.id;
    this.name = cityBuilder.name;
    this.type = cityBuilder.type;
    this.townHall = cityBuilder.townHall;
    this.phoneCode = cityBuilder.phoneCode;
    this.latitude = cityBuilder.latitude;
    this.longitude = cityBuilder.longitude;
    this.postCodes = cityBuilder.postCodes;
  }

  public static CityBuilder builder() {
    return new CityBuilder();
  }

  public static class CityBuilder {

    private String id;
    private String name;
    private CityType type;
    private String townHall;
    private String phoneCode;
    private String latitude;
    private String longitude;
    private List<String> postCodes;

    private CityBuilder() {
    }

    public CityBuilder id(String id) {
      this.id = id;
      return this;
    }

    public CityBuilder name(String name) {
      this.name = name;
      return this;
    }

    public CityBuilder type(CityType type) {
      this.type = type;
      return this;
    }

    public CityBuilder townHall(String townHall) {
      this.townHall = townHall;
      return this;
    }

    public CityBuilder phoneCode(String phoneCode) {
      this.phoneCode = phoneCode;
      return this;
    }

    public CityBuilder latitude(String latitude) {
      this.latitude = latitude;
      return this;
    }

    public CityBuilder longitude(String longitude) {
      this.longitude = longitude;
      return this;
    }

    public CityBuilder postCodes(List<String> postCodes) {
      this.postCodes = postCodes;
      return this;
    }

    public City build() {
      return new City(this);
    }
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public CityType getType() {
    return type;
  }

  public String getTownHall() {
    return townHall;
  }

  public String getPhoneCode() {
    return phoneCode;
  }

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public List<String> getPostCodes() {
    return postCodes;
  }

  @Override
  public String toString() {
    return "City{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", type=" + type +
        ", townHall='" + townHall + '\'' +
        ", phoneCode='" + phoneCode + '\'' +
        ", latitude='" + latitude + '\'' +
        ", longitude='" + longitude + '\'' +
        ", postCodes=" + postCodes +
        '}';
  }
}