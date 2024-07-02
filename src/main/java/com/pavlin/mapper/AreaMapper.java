package com.pavlin.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.pavlin.model.Area;
import com.pavlin.model.Municipality;

public class AreaMapper {

  public static Area mapAreaNodeToArea(String areaName, JsonNode areaNode) {
    Area area = new Area(areaName);

    areaNode.fieldNames().forEachRemaining(municipalityName -> {
      JsonNode municipalityNode = areaNode.get(municipalityName);

      Municipality municipality = MunicipalityMapper
          .mapMunicipalityNodeToMunicipality(municipalityName, municipalityNode);

      area.addMunicipality(municipality);
    });

    return area;
  }

}
