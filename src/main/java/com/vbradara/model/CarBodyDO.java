package com.vbradara.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car_body")
@AttributeOverride(name = "id", column = @Column(name = "body_id"))
public class CarBodyDO extends AbstractEntity{

  @Column(nullable = false, unique = true)
  private String type;

  @OneToMany(mappedBy = "body")
  private Set<CarDO> cars = new HashSet<>();

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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
