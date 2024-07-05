package com.pavlin.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavlin.mapper.AreaMapper;
import com.pavlin.model.Area;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AreaReader {

  private static final String AREA_FILE_PATH = "src/main/resources/Places-in-Bulgaria.json";

  public static List<Area> readAreas() throws IOException {
    List<Area> areas = new ArrayList<>();

    try (InputStream inputStream = new FileInputStream(AREA_FILE_PATH)) {
      JsonNode rootNode = new ObjectMapper().readTree(inputStream);

      rootNode.fieldNames().forEachRemaining(areaName -> {
        JsonNode areaNode = rootNode.get(areaName);

        Area area = AreaMapper.mapAreaNodeToArea(areaName, areaNode);

        areas.add(area);
      });

      return areas;
    }
  }
}
