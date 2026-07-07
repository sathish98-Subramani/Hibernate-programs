package com.hibernate.main;


import java.util.Scanner;

import com.hibernate.dto.OwnerDTO;
import com.hibernate.entity.PrimaryKey;
import com.hibernate.repository.OwnerRepository;
import com.hibernate.repository.impl.OwnerRepositoryImpl;
import com.hibernate.service.OwnerService;
import com.hibernate.service.impl.OwnerServiceImpl;
import com.hibernate.util.InputUtil;

public class App {
	public static void main(String[] args) {
		App app = new App();
		app.run();
	}

	public void run() {
		OwnerRepository ownerRepository = new OwnerRepositoryImpl();
		OwnerService ownerService = new OwnerServiceImpl(ownerRepository);
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("Welcome to Petistaan");
				int menuOption = InputUtil.acceptMenuOption(sc);
				switch (menuOption) {
					case 1:
						OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(sc);
						ownerService.saveOwner(ownerDTO);
						System.out.println("Owner has been saved successfully.");
						break;
					case 2:
						int ownerId = InputUtil.acceptOwnerIdToOperate(sc);
						int petId=InputUtil.acceptPetIdToOperate(sc);
						PrimaryKey primaryKey=new PrimaryKey();
						primaryKey.setId(ownerId);
						primaryKey.setPetId(petId);
						ownerDTO = ownerService.findOwner(primaryKey);
						System.out.println("Owner has been fetched successfully.");
						System.out.println(ownerDTO);
						break;
					case 3:
						ownerId = InputUtil.acceptOwnerIdToOperate(sc);
						petId=InputUtil.acceptPetIdToOperate(sc);
						primaryKey=new PrimaryKey();
						primaryKey.setId(ownerId);
						primaryKey.setPetId(petId);
						String petName = InputUtil.acceptPetDetailsToUpdate(sc);
						ownerService.updatePetDetails(primaryKey, petName);
						System.out.println("Pet details of owner have been updated successfully.");
						break;
					case 4:
						ownerId = InputUtil.acceptOwnerIdToOperate(sc);
						petId=InputUtil.acceptPetIdToOperate(sc);
						primaryKey=new PrimaryKey();
						primaryKey.setId(ownerId);
						primaryKey.setPetId(petId);
						ownerService.deleteOwner(primaryKey);
						System.out.println("Owner has been deleted successfully.");
						break;
					default:
						System.out.println("Invalid option entered.");
				}
			} while (InputUtil.wantToContinue(sc));

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}