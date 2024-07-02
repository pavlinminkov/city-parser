package com.pavlin.model;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Municipality {

  private final String name;
  private final List<City> cities = new ArrayList<>();

  public Municipality(String name) {
    this.name = name;
  }

  public void addCity(City city) {
    cities.add(city);
  }
}
