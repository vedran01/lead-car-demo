package com.vbradara.dto;

import com.vbradara.model.CarDO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDTO {

  private String name;
  private Long brandId;
  private String brandName;
  private Long modelId;
  private String model;
  private double price;
  private short engineCC;
  private short enginePower;
  private Long engineTypeId;
  private String engineTypeName;
  private Long bodyId;
  private String body;

  public CarDTO(CarDO car) {
    setName(car.getName());
    setBrandId(car.getBrand().getId());
    setBrandName(car.getBrand().getName());
    setModelId(car.getModel().getId());
    setModel(car.getModel().getName());
    setPrice(car.getPrice());
    setEngineCC(car.getEngineCc());
    setEnginePower(car.getPower());
    setEngineTypeId(car.getEngine().getId());
    setEngineTypeName(car.getEngine().getType());
    setBodyId(car.getBody().getId());
    setBody(car.getBody().getType());
  }

}
