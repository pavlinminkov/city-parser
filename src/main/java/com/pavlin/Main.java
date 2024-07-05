package com.pavlin;

import com.pavlin.helper.AreaHelper;
import com.pavlin.helper.CityHelper;
import com.pavlin.helper.MunicipalityHelper;
import com.pavlin.model.Area;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      boolean exit = false;
      while (!exit) {
        System.out.println("1. Get area/municipality/city by postcode");
        System.out.println("2. Get largest area/municipality (by city count)");
        System.out.println("3. Get all cities with their post code");
        System.out.println("4. Exit");

        Integer input = getInt(scanner);

        switch (input) {
          case 1:
            handlePostCodeOption(scanner);
            break;
          case 2:
            break;
          case 3:
            CityHelper.getCities()
                .forEach(w -> System.out.println(w.getName() + " " + w.getPostCodes()));
            break;
          case 4:
            exit = true;
            break;
          default:
            System.out.println("Oops, wrong input. Please try again");
            break;
        }
      }

      System.out.println("Bye :)");
    }
  }

  private static void handlePostCodeOption(Scanner scanner) {
    String postCode = getString("Enter post code: ", scanner);

    System.out.println("1. Get area by postcode");
    System.out.println("2. Get municipality by postcode");
    System.out.println("3. Get city by postcode");
    System.out.println("4. Back");

    Integer option = getInt(scanner);
    switch (option) {
      case 1:
        Optional<Area> area = AreaHelper.getAreaByPostCode(postCode);
        if(area.isEmpty()) {
          System.out.println("Post code not found");
        } else {
          System.out.println("Area: " + area.get().getName());
        }
        break;
      case 2:
        var municipality = MunicipalityHelper.getMunicipalityByPostCode(postCode);
        if(municipality.isEmpty()) {
          System.out.println("Post code not found");
        } else {
          System.out.println("Municipality: " + municipality.get().getName());
        }
        break;
      case 3:
        var city = CityHelper.getCityByPostCode(postCode);
        if(city.isEmpty()) {
          System.out.println("Post code not found");
        } else {
          System.out.println("City: " + city.get().getName());
        }
        break;
      case 4:
        break;
      default:
        System.out.println("Oops, wrong input. Please try again");
        break;
    }
  }

  private static String getString(String message, Scanner scanner) {
    String input = null;

    while (Objects.isNull(input)) {
      System.out.print(message);
      try {
        input = scanner.nextLine();
      } catch (Exception ex) {
        // TODO check if needed
        System.out.println("Error reading line");
      }
    }

    return input;
  }

  private static Integer getInt(Scanner scanner) {
    Integer input = null;

    while (Objects.isNull(input)) {
      System.out.print("Enter number: ");
      try {
        input = scanner.nextInt();
      } catch (Exception ex) {
        System.out.println("Not a number please try again");
      }

      scanner.nextLine();
    }

    return input;
  }

}