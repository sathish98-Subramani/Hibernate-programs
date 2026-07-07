package com.hibernate.repository;

import com.hibernate.entity.Owner;
import com.hibernate.entity.PrimaryKey;

import java.util.UUID;

public interface OwnerRepository {

	void saveOwner(Owner owner);

	Owner findOwner(PrimaryKey primaryKey);

	void updatePetDetails(PrimaryKey primaryKey, String petName);

	void deleteOwner(PrimaryKey primaryKey);

}