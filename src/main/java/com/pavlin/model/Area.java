package com.pavlin.model;

import java.util.ArrayList;
import java.util.List;

public class Area {

  private final String name;
  private final List<Municipality> municipalities = new ArrayList<>();

  public Area(String name) {
    this.name = name;
  }

  public void addMunicipality(Municipality municipality) {
    municipalities.add(municipality);
  }

  public String getName() {
    return name;
  }

  public List<Municipality> getMunicipalities() {
    return municipalities;
  }

  @Override
  public String toString() {
    return "Area{" +
        "name='" + name + '\'' +
        ", municipalities=" + municipalities +
        '}';
  }
}

