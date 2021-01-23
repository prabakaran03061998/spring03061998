package com.file;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
@Entity
@Table(name = "user_documents")
public class StorageProperties {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "document_id")
	    private Integer documentId;
	    @Column(name = "user_id")
	    private String UserId;
	    @Column(name = "file_name")
	    private String fileName;
	    @Column(name = "document_format")
	    private String documentFormat;
	    @Column(name = "upload_dir")
	    private String uploadDir;  
	    
		public StorageProperties(Integer documentId, String userId, String fileName, String documentFormat, String uploadDir) {
			super();
			this.documentId = documentId;
			this.UserId = userId;
			this.fileName = fileName;
			this.documentFormat = documentFormat;
			this.uploadDir = uploadDir;
		}
		public StorageProperties() {
			super();
		}
		public Integer getDocumentId() {
			return documentId;
		}
		public void setDocumentId(Integer documentId) {
			this.documentId = documentId;
		}
		public String getUserId() {
			return UserId;
		}
		public void setUserId(String userId) {
			UserId = userId;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
	
		public String getDocumentFormat() {
			return documentFormat;
		}
		public void setDocumentFormat(String documentFormat) {
			this.documentFormat = documentFormat;
		}
		public String getUploadDir() {
			return uploadDir;
		}
		public void setUploadDir(String uploadDir) {
			this.uploadDir = uploadDir;
		}
	    
}
