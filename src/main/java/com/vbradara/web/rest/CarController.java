package com.vbradara.web.rest;

import com.vbradara.dto.CarDTO;
import com.vbradara.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

  private final CarService service;

  @GetMapping
  public List<CarDTO> findAllCars() {
    return service.findAll();
  }

  @GetMapping("/{leadId}")
  public List<CarDTO> findCarsByLead(@PathVariable Long leadId){
    return service.findCarByLeadCriteria(leadId);
  }

}
