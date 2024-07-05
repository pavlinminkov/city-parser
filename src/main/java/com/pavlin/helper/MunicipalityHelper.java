package com.pavlin.helper;

import com.pavlin.model.Municipality;

public class MunicipalityHelper {

  public static boolean containsPostCode(Municipality municipality, String postCode) {
    return municipality.getCities().stream()
        .anyMatch(city -> city.getPostCodes().contains(postCode));
  }
}
