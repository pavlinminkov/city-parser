package com.pavlin;

import com.pavlin.helper.AreaHelper;
import com.pavlin.helper.CityHelper;
import com.pavlin.helper.MunicipalityHelper;
import com.pavlin.model.Area;
import com.pavlin.model.Municipality;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      boolean exit = false;
      while (!exit) {
        List<String> options = Arrays.asList(
            "Get area/municipality/city by postcode",
            "Get largest area/municipality (by city count)",
            "Get all cities with their post code",
            "Exit");
        listOptions(options);

        Integer input = getInt(scanner);

        switch (input) {
          case 1:
            handlePostCodeOption(scanner);
            break;
          case 2:
            handleLargestCity(scanner);
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

  private static void handleLargestCity(Scanner scanner) {
    List<String> options = Arrays.asList(
        "Get area by postcode",
        "Get municipality by postcode",
        "Exit");
    listOptions(options);

    Integer option = getInt(scanner);

    switch (option) {
      case 1:
        Optional<Area> area = AreaHelper.getAreaByMostCities();

        if (area.isEmpty()) {
          System.out.println("Error loading areas");
          return;
        }

        System.out.println("Largest area is " + area.get().getName());
        break;
      case 2:
        Optional<Municipality> municipality = MunicipalityHelper.getMunicipalityByMostCities();

        if (municipality.isEmpty()) {
          System.out.println("Error loading municipalities");
          return;
        }

        System.out.println("Largest municipality is " + municipality.get().getName());
        break;
      case 3:
        break;
      default:
        System.out.println("Wrong input");
        break;
    }
  }

  private static void handlePostCodeOption(Scanner scanner) {
    List<String> options = Arrays.asList(
        "Get area by postcode",
        "Get municipality by postcode",
        "Get city by postcode",
        "Back"
    );

    String postCode = getString("Enter post code: ", scanner);

    listOptions(options);

    Integer option = getInt(scanner);
    switch (option) {
      case 1:
        Optional<Area> area = AreaHelper.getAreaByPostCode(postCode);
        if (area.isEmpty()) {
          System.out.println("Post code not found");
        } else {
          System.out.println("Area: " + area.get().getName());
        }
        break;
      case 2:
        var municipality = MunicipalityHelper.getMunicipalityByPostCode(postCode);
        if (municipality.isEmpty()) {
          System.out.println("Post code not found");
        } else {
          System.out.println("Municipality: " + municipality.get().getName());
        }
        break;
      case 3:
        var city = CityHelper.getCityByPostCode(postCode);
        if (city.isEmpty()) {
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

  private static void listOptions(List<String> options) {
    for (int i = 0; i < options.size(); i++) {
      System.out.println((i + 1) + ". " + options.get(i));
    }
  }
}