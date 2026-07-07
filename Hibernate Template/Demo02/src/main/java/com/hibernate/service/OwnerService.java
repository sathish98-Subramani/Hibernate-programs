package com.hibernate.service;


import com.hibernate.dto.OwnerDTO;
import com.hibernate.entity.PrimaryKey;
import com.hibernate.exception.DuplicateOwnerException;
import com.hibernate.exception.OwnerNotFoundException;

public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException;

	OwnerDTO findOwner(PrimaryKey primaryKey) throws OwnerNotFoundException;

	void updatePetDetails(PrimaryKey primaryKey, String petName) throws OwnerNotFoundException;

	void deleteOwner(PrimaryKey primaryKey) throws OwnerNotFoundException;

}