//package com.file;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "user_record")
//public class Users {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	    @Column(name = "id")
//	    private long id;
//	    @Column(name = "userId")
//	    private Integer UserId;
//	    @Column(name = "user_name")
//	    private String userName;
//	   
//	    
//		public Users(Integer userId, String userName, List<StorageProperties> fileName) {
//			super();
//			this.UserId = userId;
//			this.userName = userName;
//			this.fileName = fileName;
//		}
//
//		public Users() {
//			super();
//		}
//
//		public long getId() {
//			return id;
//		}
//
//		public void setId(Integer id) {
//			this.id = id;
//		}
//
//		public Integer getUserId() {
//			return UserId;
//		}
//
//		public void setUserId(Integer userId) {
//			UserId = userId;
//		}
//
//		public String getUserName() {
//			return userName;
//		}
//
//		public void setUserName(String userName) {
//			this.userName = userName;
//		}
//
//		public List<StorageProperties> getFileName() {
//			return fileName;
//		}
//
//		public void setFileName(List<StorageProperties> fileName) {
//			this.fileName = fileName;
//		}
//		
//	  
//}
