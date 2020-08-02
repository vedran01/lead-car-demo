package com.vbradara.service;

import com.vbradara.dto.LeadCarDTO;
import com.vbradara.dto.LeadDTO;
import com.vbradara.exception.BadRequestException;
import com.vbradara.exception.ResourceNotFoundException;
import com.vbradara.model.LeadCarDO;
import com.vbradara.model.LeadDO;
import com.vbradara.model.UserDO;
import com.vbradara.repository.LeadCarRepository;
import com.vbradara.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeadService {

  private final CarService carService;
  private final LeadRepository leadRepository;
  private final LeadCarRepository leadCarRepository;

  private final EntityManager entityManager;

  protected LeadDO findById(Long leadId){
    return leadRepository.findById(leadId)
        .orElseThrow(() -> new ResourceNotFoundException("Lead with Id: " + leadId + " not found"));
  }

  public LeadDTO findLeadById(Long id) {
    LeadDO leadDO = this.findById(id);
    return new LeadDTO(leadDO);
  }

  public List<LeadDTO> findAllLeads(String firstName, String lastName) {

    boolean firstNamePresent = !StringUtils.isEmpty(firstName);
    boolean lastNamePresent = !StringUtils.isEmpty(lastName);

    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<LeadDO> query = criteriaBuilder.createQuery(LeadDO.class);
    Root<LeadDO> root = query.from(LeadDO.class);
    Join<LeadDO, UserDO> joinQuery = root.join("user");
    List<Predicate> restrictions = new ArrayList<>();

    if (firstNamePresent) {
      restrictions.add(criteriaBuilder.equal(joinQuery.get("firstName"), firstName));
    }
    if (lastNamePresent) {
      restrictions.add(criteriaBuilder.equal(joinQuery.get("lastName"), lastName));
    }

    if(!CollectionUtils.isEmpty(restrictions)){
      query.where(criteriaBuilder.and(restrictions.toArray(new Predicate[]{})));

    }

    List<LeadDO> leads = entityManager.createQuery(query).getResultList();

    return leads.stream()
        .map(LeadDTO::new)
        .collect(Collectors.toList());
  }

  @Transactional
  public LeadDTO saveLead(LeadDTO leadDTO) {

    String username = leadDTO.getData().getUsername();
    String password = leadDTO.getData().getPassword();

    if(StringUtils.isEmpty(username)) throw new BadRequestException("Username my not be empty");
    if(StringUtils.isEmpty(password)) throw new BadRequestException("Password my not be empty");

    leadDTO.getData().setUsername(username);
    leadDTO.getData().setPassword(password);
    LeadDO lead = leadDTO.toDO();
    LeadDO leadDO = leadRepository.save(lead);

    return new LeadDTO(leadDO);
  }

  @Transactional
  public LeadDTO updateLead(LeadDTO lead) {

    if(StringUtils.isEmpty(lead.getId())) throw new BadRequestException("Lead id my not be empty");

    LeadDO leadDO = findById(lead.getId());
    UserDO userDO = leadDO.getUser();
    userDO.setFirstName(lead.getData().getFirstName());
    userDO.setLastName(lead.getData().getLastName());
    userDO.setContact(lead.getData().getContact());
    userDO.setAddress(lead.getData().getAddress());
    return lead;
  }

  @Transactional
  public LeadCarDTO setCar(LeadCarDTO car) {

    LeadCarDO leadCarDO;

    if(car.getId() != null){
      leadCarDO = leadCarRepository.findById(car.getId())
          .orElseThrow(() -> new ResourceNotFoundException("Lead car with Id: " + car.getId() + " not found"));
    }

    else{

      if(car.getLeadId() == null)
        throw new BadRequestException("Lead id my not be empty");

      LeadDO leadDO = findById(car.getLeadId());
      leadCarDO = new LeadCarDO();
      leadCarDO.setLead(leadDO);
      leadCarDO = leadCarRepository.save(leadCarDO);
    }

    leadCarDO.setBrands(carService.findByNameIn(car.getBrands()));
    leadCarDO.setEngines(carService.findByEngineNameIn(car.getEngines()));
    leadCarDO.setBodies(carService.findByBodyNameIn(car.getBodies()));
    leadCarDO.setModels(carService.findByModelNameIn(car.getModels()));
    leadCarDO.setCcaFrom(car.getCcaFrom());
    leadCarDO.setCcaTo(car.getCcaTo());
    leadCarDO.setPriceFrom(car.getPriceFrom());
    leadCarDO.setPriceTo(car.getPriceTo());

    return new LeadCarDTO(leadCarDO);
  }
}
