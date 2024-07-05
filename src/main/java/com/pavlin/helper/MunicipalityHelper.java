package com.pavlin.helper;

import com.pavlin.model.Municipality;
import com.pavlin.reader.AreaReader;
import java.util.Comparator;
import java.util.Optional;

public class MunicipalityHelper {

  public static Optional<Municipality> getMunicipalityByPostCode(String postCode) {
    var areas = AreaReader.readAreas();

    if (areas.isEmpty()) {
      return Optional.empty();
    }

    return areas.stream()
        .flatMap(area -> area.getMunicipalities().stream())
        .filter(municipality -> containsPostCode(municipality, postCode))
        .findFirst();
  }

  public static Optional<Municipality> getMunicipalityByMostCities() {
    var areas = AreaReader.readAreas();

    if (areas.isEmpty()) {
      return Optional.empty();
    }

    return areas.stream()
        .flatMap(area -> area.getMunicipalities().stream())
        .max(Comparator.comparing(municipality -> municipality.getCities().size()));
  }

  public static boolean containsPostCode(Municipality municipality, String postCode) {
    return municipality.getCities().stream()
        .anyMatch(city -> city.getPostCodes().contains(postCode));
  }
}
