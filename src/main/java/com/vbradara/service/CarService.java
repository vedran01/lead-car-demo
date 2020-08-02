package com.vbradara.service;

import com.vbradara.dto.CarDTO;
import com.vbradara.dto.LeadCarDTO;
import com.vbradara.exception.ResourceNotFoundException;
import com.vbradara.model.*;
import com.vbradara.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

  @Lazy
  @Autowired
  private LeadService leadService;

  private final EntityManager entityManager;

  private final CarRepository repository;
  private final CarBrandRepository carBrandRepository;
  private final CarModelRepository carModelRepository;
  private final CarEngineRepository carEngineRepository;
  private final CarBodyRepository carBodyRepository;
  private final LeadCarRepository leadCarRepository;


  public List<CarDTO> findAll() {
    return repository.findAll().stream()
        .map(CarDTO::new).collect(Collectors.toList());

  }

  public LeadCarDTO findByLeadId(Long leadId) {
    return leadCarRepository.findByLeadId(leadId)
        .map(LeadCarDTO::new)
        .orElseThrow(() -> new ResourceNotFoundException("Lead car with id: " + leadId + " not found"));
  }

  public List<CarDTO> findCarByLeadCriteria(Long criteriaId) {

    LeadCarDO criteria = leadCarRepository.findById(criteriaId).orElseThrow(
        () -> new ResourceNotFoundException("Criteria by id: " + criteriaId + " not found"));

    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<CarDO> query = builder.createQuery(CarDO.class);
    Root<CarDO> root = query.from(CarDO.class);

    CriteriaQuery<CarDO> selectQuery = query.select(root);

    applyBrandCriteria(criteria, builder, root, selectQuery);
    applaymodelCriteria(criteria, builder, root, selectQuery);
    applyEngineCriteria(criteria, builder, root, selectQuery);
    applyBodyCriteria(criteria, builder, root, selectQuery);
    applyConditions(builder, criteria, root, selectQuery);

    List<CarDO> cars = entityManager.createQuery(selectQuery).getResultList();
    return cars.stream().map(CarDTO::new).collect(Collectors.toList());

  }

  private void applyConditions(CriteriaBuilder builder, LeadCarDO criteria, Root<CarDO> root, CriteriaQuery<CarDO> selectQuery) {

    List<Predicate> conditions = new ArrayList();
    conditions.add(builder.ge(root.get("cca"), criteria.getCcaFrom()));
    conditions.add(builder.ge(root.get("price"), criteria.getPriceFrom()));

    if (criteria.getCcaTo() > 0)
      conditions.add(builder.le(root.get("cca"), criteria.getCcaFrom()));

    if (criteria.getPriceTo() > 0)
      conditions.add(builder.le(root.get("price"), criteria.getPriceFrom()));

    selectQuery.where(conditions.toArray(new Predicate[]{}));

  }

  private void applyBrandCriteria(LeadCarDO criteria,
                                  CriteriaBuilder builder,
                                  Root<CarDO> carDORoot,
                                  CriteriaQuery<CarDO> select) {

    if (!CollectionUtils.isEmpty(criteria.getBrands())) {
      Join<CarDO, CarBrandDO> joinCars = carDORoot.join("brand");
      CriteriaBuilder.In<Long> inClause = builder.in(joinCars.get("id"));

      for (CarBrandDO brand : criteria.getBrands()) {
        inClause.value(brand.getId());
      }

      select.where(inClause);
    }
  }

  private void applyEngineCriteria(LeadCarDO criteria, CriteriaBuilder builder, Root<CarDO> carDORoot, CriteriaQuery<CarDO> select) {
    if (!CollectionUtils.isEmpty(criteria.getEngines())) {
      Join<CarDO, CarEngineDO> joinCars = carDORoot.join("engine");
      CriteriaBuilder.In<Long> inClause = builder.in(joinCars.get("id"));

      for (CarEngineDO engineDO : criteria.getEngines()) {
        inClause.value(engineDO.getId());
      }

      select.where(inClause);
    }
  }


  private void applaymodelCriteria(LeadCarDO criteria, CriteriaBuilder builder, Root<CarDO> carDORoot, CriteriaQuery<CarDO> select) {
    if (!CollectionUtils.isEmpty(criteria.getModels())) {
      Join<CarDO, CarModelDO> joinCars = carDORoot.join("model");
      CriteriaBuilder.In<Long> inClause = builder.in(joinCars.get("id"));

      for (CarModelDO model : criteria.getModels()) {
        inClause.value(model.getId());
      }

      select.where(inClause);
    }
  }

  private void applyBodyCriteria(LeadCarDO criteria, CriteriaBuilder builder, Root<CarDO> carDORoot, CriteriaQuery<CarDO> select) {
    if (!CollectionUtils.isEmpty(criteria.getBodies())) {
      Join<CarDO, CarBodyDO> joinCars = carDORoot.join("body");
      CriteriaBuilder.In<Long> inClause = builder.in(joinCars.get("id"));

      for (CarBodyDO body : criteria.getBodies()) {
        inClause.value(body.getId());
      }

      select.where(inClause);
    }
  }

  public Set<CarBrandDO> findByNameIn(Set<String> names) {
    return carBrandRepository.findByNameIn(names);
  }

  public Set<CarEngineDO> findByEngineNameIn(Set<String> names) {
    return carEngineRepository.findByTypeIn(names);
  }

  public Set<CarModelDO> findByModelNameIn(Set<String> names) {
    return carModelRepository.findByNameIn(names);
  }

  public Set<CarBodyDO> findByBodyNameIn(Set<String> names) {
    return carBodyRepository.findByTypeIn(names);
  }

}
