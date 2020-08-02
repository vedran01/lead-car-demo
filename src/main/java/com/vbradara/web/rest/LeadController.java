package com.vbradara.web.rest;

import com.vbradara.dto.LeadCarDTO;
import com.vbradara.dto.LeadDTO;
import com.vbradara.service.CarService;
import com.vbradara.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lead")
@RequiredArgsConstructor
public class LeadController {

  private final LeadService leadService;
  private final CarService carService;
  @GetMapping

  public List<LeadDTO> findLeads(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName){
    return leadService.findAllLeads(firstName, lastName);
  }

  @GetMapping("/{leadId}")
  public LeadDTO findById(Long leadId){
    return leadService.findLeadById(leadId);
  }

  @PostMapping
  public LeadDTO saveLead(@RequestBody @Valid LeadDTO lead){
    return leadService.saveLead(lead);
  }

  @PutMapping
  public LeadDTO updateLead(@RequestBody @Valid LeadDTO lead){
    return leadService.updateLead(lead);
  }

  @PostMapping("/car")
  public LeadCarDTO setCar(@RequestBody LeadCarDTO car){
    return leadService.setCar(car);
  }

  @GetMapping("/{leadId}/car")
  public LeadCarDTO findCarByLeadId(@PathVariable Long leadId){
    return carService.findByLeadId(leadId);
  }


}
