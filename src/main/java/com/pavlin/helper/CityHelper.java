package com.pavlin.helper;

import com.pavlin.model.Area;
import com.pavlin.model.City;
import com.pavlin.reader.AreaReader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class CityHelper {

  public static Optional<City> getCityByPostCode(String postCode) {
    var areas = AreaReader.readAreas();

    if(areas.isEmpty()) {
      return Optional.empty();
    }

    return getCitiesStream(areas)
        .filter(city -> containsPostCode(city, postCode))
        .findFirst();
  }

  public static List<City> getCities() {
    var areas = AreaReader.readAreas();

    if(areas.isEmpty()) {
      return Collections.emptyList();
    }

    return getCitiesStream(areas).toList();
  }

  public static boolean containsPostCode(City city, String postCode) {
    return city.getPostCodes().contains(postCode);
  }

  private static Stream<City> getCitiesStream(List<Area> areas) {
    return areas.stream()
        .flatMap(area -> area.getMunicipalities().stream())
        .flatMap(municipality -> municipality.getCities().stream());
  }
}
