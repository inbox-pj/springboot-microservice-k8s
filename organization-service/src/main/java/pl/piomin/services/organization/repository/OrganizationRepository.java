package com.clover.services.organization.repository;

import org.springframework.data.repository.CrudRepository;

import com.clover.services.organization.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, String> {
	
}
