package com.pavlin.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.pavlin.model.City;
import com.pavlin.model.Municipality;

public class MunicipalityMapper {

  public static Municipality mapMunicipalityNodeToMunicipality(String municipalityName,
      JsonNode municipalityNode) {
    Municipality municipality = new Municipality(municipalityName);

    municipalityNode.fieldNames().forEachRemaining(cityId -> {
      JsonNode cityNode = municipalityNode.get(cityId);

      City city = CityMapper.mapCityNodeToCity(cityId, cityNode);

      municipality.addCity(city);
    });

    return municipality;
  }
}
