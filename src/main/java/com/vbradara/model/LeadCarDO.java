package com.vbradara.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lead_car")
@AttributeOverride(name = "id", column = @Column(name = "car_id"))
public class LeadCarDO extends AbstractAuditEntity {

  @OneToOne(optional = false)
  private LeadDO lead;

  @OneToMany
  @JoinTable(name = "lead_carbrands",
      joinColumns = { @JoinColumn(name = "lead_car_id") },
      inverseJoinColumns ={ @JoinColumn(name = "brand_id") })
  private Set<CarBrandDO> brands = new HashSet<>();

  @OneToMany
  @JoinTable(name = "lead_carmodels",
      joinColumns = { @JoinColumn(name = "lead_car_id") },
      inverseJoinColumns ={ @JoinColumn(name = "model_id") })
  private Set<CarModelDO> models = new HashSet<>();

  @OneToMany
  @JoinTable(name = "lead_carengines",
      joinColumns = { @JoinColumn(name = "lead_car_id") },
      inverseJoinColumns ={ @JoinColumn(name = "engine_id") })
  private Set<CarEngineDO> engines = new HashSet<>();

  @OneToMany
  @JoinTable(name = "lead_carbodies",
      joinColumns = { @JoinColumn(name = "lead_car_id") },
      inverseJoinColumns ={ @JoinColumn(name = "body_id") })
  private Set<CarBodyDO> bodies = new HashSet<>();

  @Column(columnDefinition = "smallint default 0")
  private short ccaFrom;
  @Column(columnDefinition = "smallint default 0")
  private short ccaTo;
  @Column(columnDefinition = "decimal default 0")
  private double priceFrom;
  @Column(columnDefinition = "decimal default 0")
  private double priceTo;

  public LeadDO getLead() {
    return lead;
  }

  public void setLead(LeadDO lead) {
    this.lead = lead;
  }

  public Set<CarBrandDO> getBrands() {
    return brands;
  }

  public void setBrands(Set<CarBrandDO> brands) {
    this.brands = brands;
  }

  public Set<CarModelDO> getModels() {
    return models;
  }

  public void setModels(Set<CarModelDO> models) {
    this.models = models;
  }

  public Set<CarEngineDO> getEngines() {
    return engines;
  }

  public void setEngines(Set<CarEngineDO> engines) {
    this.engines = engines;
  }

  public Set<CarBodyDO> getBodies() {
    return bodies;
  }

  public void setBodies(Set<CarBodyDO> bodies) {
    this.bodies = bodies;
  }

  public short getCcaFrom() {
    return ccaFrom;
  }

  public void setCcaFrom(short ccaFrom) {
    this.ccaFrom = ccaFrom;
  }

  public short getCcaTo() {
    return ccaTo;
  }

  public void setCcaTo(short ccaTo) {
    this.ccaTo = ccaTo;
  }

  public double getPriceFrom() {
    return priceFrom;
  }

  public void setPriceFrom(double priceFrom) {
    this.priceFrom = priceFrom;
  }

  public double getPriceTo() {
    return priceTo;
  }

  public void setPriceTo(double priceTo) {
    this.priceTo = priceTo;
  }
}
