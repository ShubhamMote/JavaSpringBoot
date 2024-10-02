package project.gym_management.services;

import java.io.IOException;
import java.util.List;

import project.gym_management.dto.Credentials;
import project.gym_management.dto.ImageDto;
import project.gym_management.entities.TableUser;

public interface TableUserService {
	
	public TableUser getById(int id);

	public TableUser getByEmail(String email);
	
	public TableUser authenticateUser(Credentials cred);

	public String saveUser(Credentials cred);
	
	public String updateUser(Credentials cred);
	
	public void changePassword(Credentials cred);

	public String forgotPassword(Credentials cred);

	public void deleteUser(Credentials cred);

	public List<TableUser> getAllUsers();

	public TableUser getAllInfo(int user_id);

	public void addUserImage(ImageDto imageDto) throws IllegalStateException, IOException;

	public void updateUserRole(Credentials cred);

}
