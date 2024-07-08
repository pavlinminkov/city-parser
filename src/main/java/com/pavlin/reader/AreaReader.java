package com.pavlin.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavlin.mapper.AreaMapper;
import com.pavlin.model.Area;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AreaReader {

  private static final String AREA_FILE_PATH = "src/main/resources/Places-in-Bulgaria.json";
  private static List<Area> areas;

  public static List<Area> readAreas() {
    if (Objects.isNull(areas)) {
      List<Area> tempAreas = new ArrayList<>();

      try (InputStream inputStream = new FileInputStream(AREA_FILE_PATH)) {
        JsonNode rootNode = new ObjectMapper().readTree(inputStream);

        rootNode.fieldNames().forEachRemaining(areaName -> {
          JsonNode areaNode = rootNode.get(areaName);

          Area area = AreaMapper.mapAreaNodeToArea(areaName, areaNode);

          tempAreas.add(area);
        });

        areas = tempAreas;
      } catch (FileNotFoundException exception) {
        System.out.println("File not found at location " + AREA_FILE_PATH);
        return Collections.emptyList();
      } catch (IOException exception) {
        System.out.println("Problem when reading file " + exception.getMessage());
        return Collections.emptyList();
      }
    }

    return areas;
  }
}
