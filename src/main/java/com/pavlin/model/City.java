package com.pavlin.model;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@Builder
@ToString
public class City {

  private String id;
  private String name;
  private CityType type;
  private String townHall;
  private String phoneCode;
  private String latitude;
  private String longitude;
  private List<String> postCodes;
}