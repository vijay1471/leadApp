package com.lead.service.impl;

import com.lead.entity.Lead;
import com.lead.payload.LeadDto;
import com.lead.repository.LeadRepository;
import com.lead.service.LeadService;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService {

    private LeadRepository leadRepository;

    public LeadServiceImpl(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @Override
    public LeadDto createLead(LeadDto leadDto) {
        Lead lead = mapToEntity(leadDto);
        Lead saved = leadRepository.save(lead);
        LeadDto newLeadDto = mapToDto(saved);
        return newLeadDto;
    }

    public Lead mapToEntity(LeadDto leadDto) {
        Lead lead = new Lead();
        lead.setFirstName(leadDto.getFirstName());
        lead.setLastName(leadDto.getLastName());
        lead.setCity(leadDto.getCity());
        lead.setEmail(leadDto.getEmail());
        lead.setMobile(leadDto.getMobile());
        return  lead;
    }


    public LeadDto mapToDto(Lead saved) {
        LeadDto newLeadDto = new LeadDto();
        newLeadDto.setId(saved.getId());
        newLeadDto.setFirstName(saved.getFirstName());
        newLeadDto.setLastName(saved.getLastName());
        newLeadDto.setCity(saved.getCity());
        newLeadDto.setEmail(saved.getEmail());
        newLeadDto.setMobile(saved.getMobile());
        return newLeadDto;
    }
}
