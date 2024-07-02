package com.pavlin.model;

import lombok.Getter;

@Getter
public enum CityType {

  VILLAGE("с."), CITY("гр."), MONASTERY("ман."), RESORT_COMPLEX("к.к.");

  private final String description;

  CityType(String description) {
    this.description = description;
  }

  public static CityType fromDescription(String description) {
    for (CityType type : CityType.values()) {
      if (type.getDescription().equals(description)) {
        return type;
      }
    }
    throw new IllegalArgumentException("No CityType with description " + description + " found.");
  }

  @Override
  public String toString() {
    return description;
  }
}
