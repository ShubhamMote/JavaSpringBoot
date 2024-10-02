package project.gym_management.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gym_management.dao.TableUserDao;
import project.gym_management.dto.Credentials;
import project.gym_management.dto.ImageDto;
import project.gym_management.entities.TableUser;
import project.gym_management.utils.StorageService;

@Transactional
@Service
public class TableUserServiceImpl implements TableUserService {

	@Autowired
	private TableUserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private StorageService storageService;
	@Autowired
	private AmazonClient amazonClient;
	

	@Override
	public TableUser getById(int id) {
		Optional<TableUser> user = userDao.findById(id);
		return user.orElse(null);
	}

	@Override
	public TableUser getByEmail(String email) {
        return userDao.findByEmail(email);
	}

	@Override
	public List<TableUser> getAllUsers() {
        return userDao.findAll();
	}

	@Override
	public String saveUser(Credentials cred) {
		int counter = 0;
		List<TableUser> list = this.getAllUsers();
		for (TableUser tableUser : list) {
			if (tableUser.getRole().equals("admin"))
				counter=counter+1;
		}
		//System.out.println("counter :"+counter);
		for (TableUser tableUser : list) {
			if (tableUser.getEmail().equals(cred.getEmail()))
				return "email already in use";
		}
		TableUser tbUser = new TableUser();
		BeanUtils.copyProperties(cred, tbUser);
		String encPassword = passwordEncoder.encode(tbUser.getPassword());
		tbUser.setPassword(encPassword);
		tbUser.setUser_id(0);
		if(counter > 0) {
		tbUser.setRole("user");
		}else {
			tbUser.setRole("admin");
		}
		userDao.save(tbUser);
		return "success";
	}

	@Override
	public String updateUser(Credentials cred) {

		TableUser tbUser = getById(cred.getUser_id());
		tbUser.setContact(cred.getContact());
		tbUser.setAddress(cred.getAddress());
		tbUser.setHeight(cred.getHeight());
		tbUser.setAge(cred.getAge());
		tbUser.setWeight(cred.getWeight());
		tbUser.setJoining_date(cred.getJoining_date());
		tbUser.setGender(cred.getGender());
		userDao.save(tbUser);
		return "success";
	}

	@Override
	public void changePassword(Credentials cred) {
		TableUser tbUser = getByEmail(cred.getEmail());
		String encPassword = passwordEncoder.encode(cred.getPassword());
		tbUser.setPassword(encPassword);
		userDao.save(tbUser);
	}

	@Override
	public TableUser authenticateUser(Credentials cred) {
		TableUser user = getByEmail(cred.getEmail());
		if (user != null && passwordEncoder.matches(cred.getPassword(), user.getPassword()))
			return user;
		return null;
	}

	@Override
	public String forgotPassword(Credentials cred) {
		TableUser user = this.getByEmail(cred.getEmail());
		if (user == null) {
			return "no such email found";
		}
		if (user.getQuestion() != cred.getQuestion()) {
			return "try another question !!";
		} else if (!(user.getAnswer().equals(cred.getAnswer()))) {
			return "wrong answer";
		} else
			return "success";
	}

	@Override
	public void deleteUser(Credentials cred) {
		/*
		 * TableUser allinfo = userDao.getById(cred.getUser_id());
		 * amazonClient.deleteFileFromS3Bucket(allinfo.getAvatar());
		 */
		userDao.deleteById(cred.getUser_id());
	}

	@Override
	public TableUser getAllInfo(int user_id) {
        return userDao.getById(user_id);

	}

	@Override
	public void addUserImage(ImageDto imageDto) throws IllegalStateException, IOException {
		String filePath="C:\\Users\\91956\\Downloads";
		TableUser user = userDao.getById(imageDto.getId());
		String fileName = storageService.store(imageDto.getThumbnail());

		System.out.println("Filename : " + fileName);
		//String fileName=amazonClient.uploadFile(imageDto.getThumbnail());
		//imageDto.getThumbnail().transferTo(new File(filePath));
		//user.setAvatar(fileName);
		userDao.save(user);		
	}

	@Override
	public void updateUserRole(Credentials cred) {
		TableUser tbUser = getById(cred.getUser_id());
		tbUser.setRole("admin");
		userDao.save(tbUser);
	}
}
