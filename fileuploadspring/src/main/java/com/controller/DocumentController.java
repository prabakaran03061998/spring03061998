package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.response.UploadFileResponse;
import com.services.DocumentStorageServices;

@RestController
public class DocumentController {
	
	
	@Autowired
	private DocumentStorageServices documentStorageService;
	
	@PostMapping(value = "/uploadFile",headers = "Content-Type= multipart/form-data")
	public UploadFileResponse uploadFile(@RequestParam("file")MultipartFile file,@RequestParam("userId")String userId,@RequestParam(required = false) Map<String,String> requestParam ){
		String userName=requestParam.get("name");
		String dept=requestParam.get("dept");
		System.out.println("MapValues:\n"+"UserName:"+userName+"dept:"+dept);
		final String fileName=documentStorageService.storeFile(file, userId);
		String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile").path("/"+userId+"/").path(fileName).toUriString();
		return new UploadFileResponse(fileName, fileDownloadUri,file.getContentType(),file.getSize());
	}
	
	@PostMapping("/multiFiles")
	public List<UploadFileResponse> uploadFiles(@RequestParam("file")MultipartFile[] files,@RequestParam("userId")String userId)
	{
		List<UploadFileResponse>addResponse=new ArrayList<UploadFileResponse>();
		Arrays.asList(files)
			.stream()
			.forEach(file->{
		 		String fileName=documentStorageService.storeFile(file, userId);
				String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath()
						.path("/downloadFile").path("/"+userId+"/").path(fileName).toUriString();	
				UploadFileResponse response=new UploadFileResponse(fileName, fileDownloadUri,file.getContentType(),file.getSize());
				addResponse.add(response);
			});
		    
		return addResponse;
		//return new UploadFileResponse(fileName, fileDownloadUri,file.getContentType(),file.getSize());
		 
	}
	@GetMapping("/downloadFile/{userId}/{filename}")
	  public ResponseEntity<Resource> downloadFile(@PathVariable("userId") String userId,@PathVariable("filename")String filename ,HttpServletRequest request) {
	         String fileName = documentStorageService.getDocumentName(userId,filename);
	         Resource resource = null;
	         if(fileName !=null && !fileName.isEmpty()) {
	         try {
	             resource = documentStorageService.loadFileAsResource(fileName);
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	         // Try to determine file's content type
	         String contentType = null;
	         try {
	             contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	         } catch (IOException ex) { }
	         if(contentType == null) {
	             contentType = "application/octet-stream";
	         }
	         return ResponseEntity.ok()
	                 .contentType(MediaType.parseMediaType(contentType))
	                 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                 .body(resource);
	     } else {

	         return ResponseEntity.notFound().build();

	     }
	    } 

}
