package com.pavlin.helper;

import com.pavlin.model.Area;
import com.pavlin.reader.AreaReader;
import java.util.Comparator;
import java.util.Optional;

public class AreaHelper {

  public static Optional<Area> getAreaByPostCode(String postCode) {
    var areas = AreaReader.readAreas();

    if (areas.isEmpty()) {
      return Optional.empty();
    }

    return areas.stream()
        .filter(area -> containsPostCode(area, postCode))
        .findFirst();
  }

  public static Optional<Area> getAreaByMostCities() {
    var areas = AreaReader.readAreas();

    if (areas.isEmpty()) {
      return Optional.empty();
    }

    return areas.stream()
        .max(Comparator.comparing(AreaHelper::getCityCountByArea));
  }

  public static int getCityCountByArea(Area area) {
    return area.getMunicipalities().stream()
        .mapToInt(w -> w.getCities().size())
        .sum();
  }

  public static boolean containsPostCode(Area area, String postCode) {
    return area.getMunicipalities().stream()
        .anyMatch(municipality -> MunicipalityHelper.containsPostCode(municipality, postCode));
  }
}
