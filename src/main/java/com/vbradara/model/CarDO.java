package com.vbradara.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
@AttributeOverride(name = "id", column = @Column(name = "car_id"))
public class CarDO extends AbstractEntity {

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne(optional = false)
  @JoinColumn(name = "brand_id")
  private CarBrandDO brand;

  @ManyToOne(optional = false)
  @JoinColumn(name = "model_id")
  private CarModelDO model;

  @Column(name = "price", nullable = false)
  private double price;

  @Column(name = "engine_cc", nullable = false)
  private short engineCc;

  @Column(name = "power", nullable = false)
  private short power;

  @ManyToOne(optional = false)
  @JoinColumn(name = "engine_id")
  private CarEngineDO engine;

  @ManyToOne(optional = false)
  @JoinColumn(name = "body_id")
  private CarBodyDO body;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CarBrandDO getBrand() {
    return brand;
  }

  public void setBrand(CarBrandDO brand) {
    brand.addCar(this);
    this.brand = brand;
  }

  public CarModelDO getModel() {
    return model;
  }

  public void setModel(CarModelDO model) {
    model.addCar(this);
    this.model = model;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public short getEngineCc() {
    return engineCc;
  }

  public void setEngineCc(short engineCc) {
    this.engineCc = engineCc;
  }

  public short getPower() {
    return power;
  }

  public void setPower(short power) {
    this.power = power;
  }

  public CarEngineDO getEngine() {
    return engine;
  }

  public void setEngine(CarEngineDO engine) {
    engine.addCar(this);
    this.engine = engine;
  }

  public CarBodyDO getBody() {
    return body;
  }

  public void setBody(CarBodyDO body) {
    body.addCar(this);
    this.body = body;
  }
}
