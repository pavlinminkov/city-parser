package com.pavlin.model;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Area {

  private final String name;
  private final List<Municipality> municipalities = new ArrayList<>();

  public Area(String name) {
    this.name = name;
  }

  public void addMunicipality(Municipality municipality) {
    municipalities.add(municipality);
  }
}

