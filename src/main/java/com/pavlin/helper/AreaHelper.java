package com.pavlin.helper;

import com.pavlin.model.Area;
import java.util.List;
import java.util.Optional;

public class AreaHelper {

  public static Optional<Area> getAreaByPostCode(String postCode, List<Area> areas) {
    return areas.stream()
        .filter(tempArea -> AreaHelper.containsPostCode(tempArea, postCode))
        .findFirst();
  }

  public static boolean containsPostCode(Area area, String postCode) {
    return area.getMunicipalities().stream()
        .anyMatch(municipality -> MunicipalityHelper.containsPostCode(municipality, postCode));
  }
}
