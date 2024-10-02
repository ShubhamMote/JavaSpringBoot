package project.gym_management.services;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonClient {

	public String uploadFile(MultipartFile multipartFile);
	
	public String deleteFileFromS3Bucket(String fileUrl) ;
}
