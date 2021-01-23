package com.storagerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.file.StorageProperties;

@Repository
public interface DocumentStorageRepository extends JpaRepository<StorageProperties, Integer>{

	@Query("Select fileName from StorageProperties a where user_id = ?1 and fileName = ?2 ")
	String getAllUploadDocumnetPath(String userId ,String fileName);

}
