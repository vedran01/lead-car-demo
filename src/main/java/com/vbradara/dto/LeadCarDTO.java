package com.vbradara.dto;

import com.vbradara.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class LeadCarDTO {
  private Long id;
  private Long leadId;
  private Set<String> brands = new HashSet<>();
  private Set<String> models = new HashSet<>();
  private Set<String> engines = new HashSet<>();
  private Set<String> bodies = new HashSet<>();
  private short engineCcFrom;
  private short engineCcTo;
  private double priceFrom;
  private double priceTo;

  public LeadCarDTO(LeadCarDO car){
    setId(car.getId());
    setLeadId(car.getLead().getId());
    setEngineCcFrom(car.getEngineCcFrom());
    setEngineCcTo(car.getEngineCcTo());
    setPriceFrom(car.getPriceFrom());
    setPriceTo(car.getPriceTo());
    mapBrands(car.getBrands());
    mapModels(car.getModels());
    mapEngines(car.getEngines());
    mapBodies(car.getBodies());

  }

  private void mapBodies(Set<CarBodyDO> bodies) {
    Set<String> _bodies = new HashSet<>();
    if(bodies != null){
      for(CarBodyDO bodyDO : bodies){
        _bodies.add(bodyDO.getType());
      }
    }

    setBodies(_bodies);

  }

  private void mapEngines(Set<CarEngineDO> engines) {
    Set<String> _engines = new HashSet<>();

    if(engines != null){
      for(CarEngineDO engineDO : engines){
          _engines.add(engineDO.getType());
        }
      }

    setEngines(_engines);

  }

  private void mapModels(Set<CarModelDO> models) {
    Set<String> _models = new HashSet<>();

    if(models != null){

      for(CarModelDO carModelDO : models){
        _models.add(carModelDO.getName());
      }

    }
    setModels(_models);
  }

  private void mapBrands(Set<CarBrandDO> brands) {
    Set<String> _brands = new HashSet<>();

    if(brands != null){

      for(CarBrandDO brandDO : brands){
        _brands.add(brandDO.getName());
      }

    }

    setBrands(_brands);
  }

}
