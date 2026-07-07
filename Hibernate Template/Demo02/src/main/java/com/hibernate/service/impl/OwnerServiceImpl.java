package com.hibernate.service.impl;

import com.hibernate.dto.OwnerDTO;
import com.hibernate.entity.Owner;
import com.hibernate.entity.PrimaryKey;
import com.hibernate.exception.DuplicateOwnerException;
import com.hibernate.exception.OwnerNotFoundException;
import com.hibernate.repository.OwnerRepository;
import com.hibernate.repository.impl.OwnerRepositoryImpl;
import com.hibernate.service.OwnerService;
import com.hibernate.util.MapperUtil;

import java.util.Objects;
import java.util.UUID;

public class OwnerServiceImpl implements OwnerService {

	private OwnerRepository ownerRepository;

	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException {
		PrimaryKey primaryKey=new PrimaryKey();
		primaryKey.setId(ownerDTO.getId());
		primaryKey.setPetId(ownerDTO.getPetId());
		Owner owner = ownerRepository.findOwner(primaryKey);

		if (Objects.nonNull(owner)) {
			throw new DuplicateOwnerException("Owner already exists");
		}

		ownerRepository.saveOwner(MapperUtil.convertOwnerDtoToEntity(ownerDTO));
	}

	@Override
	public OwnerDTO findOwner(PrimaryKey primaryKey) throws OwnerNotFoundException {

		Owner owner = ownerRepository.findOwner(primaryKey);

		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("Owner Not Found");
		}

		return MapperUtil.convertOwnerEntityToDto(owner);
	}

	@Override
	public void updatePetDetails(PrimaryKey primaryKey, String petName) throws OwnerNotFoundException {

		Owner owner = ownerRepository.findOwner(primaryKey);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("Owner Not Found");
		}
		ownerRepository.updatePetDetails(primaryKey,petName);
	}

	@Override
	public void deleteOwner(PrimaryKey primaryKey) throws OwnerNotFoundException {

		Owner owner = ownerRepository.findOwner(primaryKey);

		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("Owner Not Found");
		}

		ownerRepository.deleteOwner(primaryKey);
	}
}