package com.vbradara.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car_brand")
@AttributeOverride(name = "id", column = @Column(name = "brand_id"))
public class CarBrandDO extends AbstractEntity {

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @OneToMany(mappedBy = "brand", orphanRemoval = true)
  private Set<CarDO> cars = new HashSet<>();


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<CarDO> getCars() {
    return cars;
  }

  public void setCars(Set<CarDO> cars) {
    this.cars = cars;
  }

  public boolean addCar(CarDO car){
    return cars.add(car);
  }

  public boolean removeCar(CarDO car){
    return cars.remove(car);
  }
}
