package com.pavlin.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavlin.mapper.AreaMapper;
import com.pavlin.model.Area;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AreaReader {

  private static final String AREA_FILE_PATH = "src/main/resources/Places-in-Bulgaria.json";

  public static List<Area> readAreas() throws IOException {
    List<Area> areas = new ArrayList<>();

    JsonNode rootNode = new ObjectMapper().readTree(new File(AREA_FILE_PATH));
    rootNode.fieldNames().forEachRemaining(areaName -> {
      JsonNode areaNode = rootNode.get(areaName);

      Area area = AreaMapper.mapAreaNodeToArea(areaName, areaNode);

      areas.add(area);
    });

    return areas;
  }
}
