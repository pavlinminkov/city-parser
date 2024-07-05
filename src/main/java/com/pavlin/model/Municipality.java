package com.pavlin.model;

import java.util.ArrayList;
import java.util.List;

public class Municipality {

  private final String name;
  private final List<City> cities = new ArrayList<>();

  public Municipality(String name) {
    this.name = name;
  }

  public void addCity(City city) {
    cities.add(city);
  }

  public String getName() {
    return name;
  }

  public List<City> getCities() {
    return cities;
  }

  @Override
  public String toString() {
    return "Municipality{" +
        "name='" + name + '\'' +
        ", cities=" + cities +
        '}';
  }
}
