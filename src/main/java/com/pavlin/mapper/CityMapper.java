package com.pavlin.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.pavlin.model.City;
import com.pavlin.model.CityType;
import java.util.ArrayList;
import java.util.List;

public class CityMapper {

  public static City mapCityNodeToCity(String cityId, JsonNode cityNode) {
    List<String> postCodes = extractPostCodes(cityNode);

    return City.builder()
        .id(cityId)
        .name(cityNode.get("name").asText())
        .type(CityType.fromDescription((cityNode.get(("type")).asText())))
        .townHall(cityNode.get("town_hall").asText())
        .phoneCode(cityNode.get("phone_code").asText())
        .latitude(cityNode.get("latitude").asText())
        .longitude(cityNode.get("longitude").asText())
        .postCodes(postCodes)
        .build();
  }

  private static List<String> extractPostCodes(JsonNode cityNode) {
    List<String> postCodes = new ArrayList<>();
    if (cityNode.has("post_codes")) {
      for (JsonNode postCodeNode : cityNode.get("post_codes")) {
        postCodes.add(postCodeNode.asText());
      }
    }

    return postCodes;
  }
}
