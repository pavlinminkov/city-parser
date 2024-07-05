package com.pavlin;

import com.pavlin.helper.AreaHelper;
import com.pavlin.model.Area;
import com.pavlin.model.City;
import com.pavlin.model.Municipality;
import com.pavlin.reader.AreaReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {

  public static void main(String[] args) {
    try {
      List<Area> areas = AreaReader.readAreas();
      String postCode = "3458";

      Optional<Area> area = AreaHelper.getAreaByPostCode(postCode, areas);

      if(area.isEmpty()) {
        System.out.println("There is no area with post code " + postCode);
        return;
      }

      System.out.println("Area with postcode " + postCode + " is " + area.get().getName());
    } catch (IOException e) {
      System.out.println("Problem reading file");
    }
  }
}