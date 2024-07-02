package com.pavlin;

import com.pavlin.model.Area;
import com.pavlin.reader.AreaReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    try {
      Area area = AreaReader.readAreas().stream()
          .filter(currentArea -> currentArea.getMunicipalities().stream()
              .anyMatch(municipality -> municipality.getCities().stream()
                  .anyMatch(city -> city.getName().equals("Добринище"))))
          .findFirst()
          .orElseThrow();

      System.out.println(area);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}