package project.gym_management.controllers;

import java.util.List;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.gym_management.dto.Credentials;
import project.gym_management.dto.DietDto;
import project.gym_management.dto.FeedbackDto;
import project.gym_management.dto.ImageDto;
import project.gym_management.dto.InventoryDto;
import project.gym_management.dto.PlanDto;
import project.gym_management.dto.Response;
import project.gym_management.dto.TrainerDto;
import project.gym_management.entities.TableFeedback;
import project.gym_management.entities.TableInventory;
import project.gym_management.entities.TablePlan;
import project.gym_management.entities.TableTrainer;
import project.gym_management.entities.TableUser;
import project.gym_management.services.TableDietService;
import project.gym_management.services.TableFeedbackService;
import project.gym_management.services.TableInventoryService;
import project.gym_management.services.TablePlanService;
import project.gym_management.services.TableTrainerService;
import project.gym_management.services.TableUserService;

@CrossOrigin
@RestController
@Slf4j
public class AdminController {

	//private static final Logger logger =LoggerFactory.getLogger(AdminController.class);

	@Autowired
	TableFeedbackService feedService;
	@Autowired
	TableUserService tblUserService;
	@Autowired
	TablePlanService planService;
	@Autowired
	TableTrainerService trainerService;
	@Autowired
	TableInventoryService inventoryService;
	@Autowired
	TableDietService dietService;

	/* Table User REST */

	@RequestMapping("/deleteuser")
	public ResponseEntity<?> deleteUser(@RequestBody Credentials cred) {
		tblUserService.deleteUser(cred);
		return  Response.success("success");
	}

	@RequestMapping("/getallusers")
	public ResponseEntity<?> getAllUsers() {
		List<TableUser> list = tblUserService.getAllUsers();
		Stream<Credentials> allusers = list.stream().map(user -> Credentials.allDataTODto(user));
		log.info("Get all Users : " + list);
		return Response.success(list);
	}
	
	@RequestMapping("/updateUserRole")
	public ResponseEntity<?> updateUserRole(@RequestBody Credentials cred) {
		tblUserService.updateUserRole(cred);
		return Response.success("success");
	}

	
	/* Table Feedback REST */  
	
	@RequestMapping("/getAllfeedbacks")
	public ResponseEntity<?> getAllFeedbacks() {
		List<TableFeedback> list = feedService.getAllFeedbacks();
		Stream<FeedbackDto> feedbacks = list.stream().map(feedback -> FeedbackDto.fromEntity(feedback));
		return Response.success(feedbacks);
	}

	@RequestMapping("/deletefeedback")
	public ResponseEntity<?> deleteFeedbacks(@RequestBody FeedbackDto feeddto) {
		feedService.deleteFeedback(feeddto);
		return Response.success("success");
	}
	
	@RequestMapping("/feedbackResponse")
	public ResponseEntity<?> feedbackResponse(@RequestBody FeedbackDto feeddto) {
		feedService.feedbackResponse(feeddto);
		return  Response.success("success");
	}
	
	/* Table Plan REST */

	@RequestMapping("/createPlan")
	public ResponseEntity<?> createPlan(@RequestBody PlanDto plandto) { 
		planService.createPlan(plandto);
		return Response.success("success");
	}

	@RequestMapping("/getAllPlans")
	public ResponseEntity<?> getAllPlans() {
		List<TablePlan> list = planService.getAllPalns();
		Stream<PlanDto> plans = list.stream().map(plan -> PlanDto.fromEntity(plan));
		return  Response.success(plans);
	}

	@RequestMapping("/deletePlan")
	public ResponseEntity<?> deletePlan(@RequestBody PlanDto plandto) {
		planService.deletePlan(plandto);
		return Response.success("success");
	}

	@RequestMapping("/updatePlan")
	public ResponseEntity<?> updatePlan(@RequestBody PlanDto plandto) {
		planService.updatePlan(plandto);
		return Response.success("success");
	}

	/* Table Trainer REST */
	
/*
 	@PostMapping("/addTrainerImage")
	public ResponseEntity<?> addTrainerImage(@RequestParam MultipartFile thumbnail,@RequestParam String id) {
		ImageDto imageDto=new ImageDto(Integer.parseInt(id),thumbnail);
		trainerService.addTrainerImage(imageDto);
		return Response.success("success");
	}
*/
	@PostMapping("/addTrainer")
	public ResponseEntity<?> addTrainer(@RequestBody TrainerDto trainerDto) { 
		trainerService.addTrainer(trainerDto);
		return Response.success("success");
	}
	
	@RequestMapping("/getAllTrainers")
	public ResponseEntity<?> getAllTrainers() {
		List<TableTrainer> list = trainerService.getAllTrainers();
		Stream<TrainerDto> trainers = list.stream().map(trainer -> TrainerDto.fromEntity(trainer));
		return Response.success(trainers);
	}
	
	@RequestMapping("/deleteTrainer")
	public ResponseEntity<?> deleteTrainer(@RequestBody TrainerDto trainerDto) {
		trainerService.deleteTrainer(trainerDto);
		return Response.success("success");
	}
	
	@RequestMapping("/updateTrainer")
	public ResponseEntity<?> updateTrainer(@RequestBody TrainerDto trainerDto) {
		trainerService.updateTrainer(trainerDto);
		return Response.success("success");
	}
	
	/* Table Inventory REST */
	
	@RequestMapping("/addItemInfo")
	public ResponseEntity<?> addItemInfo(@RequestBody InventoryDto inventoryDto) { 
		inventoryService.addItemInfo(inventoryDto);
		return Response.success("success");
	}
	
	@RequestMapping("/getAllInventoryItems")
	public ResponseEntity<?> getAllInventoryItems() {
		List<TableInventory> list = inventoryService.getAllInventoryItems();
		Stream<InventoryDto> trainers = list.stream().map(item -> InventoryDto.fromEntity(item));
		return Response.success(trainers);
	}
	
	/*Table Diet REST */
	
	@RequestMapping("/addDiet")
	public ResponseEntity<?> addDiet(@RequestBody DietDto dietDto) { 
		dietService.addDiet(dietDto);
		return Response.success("success");
	}
	
	@RequestMapping("/updateDiet")
	public ResponseEntity<?> updateDiet(@RequestBody DietDto dietDto) {
		dietService.updateDiet(dietDto);
		return Response.success("success");
	}
	
	@RequestMapping("/deleteDiet")
	public ResponseEntity<?> deleteDiet(@RequestBody DietDto dietDto) {
		dietService.deleteDiet(dietDto);
		return Response.success("success");
	}
	
	@RequestMapping("/getAllDietItems")
	public ResponseEntity<?> getAllDietItems() {
		List<project.gym_management.entities.TableDiet> list = dietService.getAllDietItems();
		Stream<DietDto> trainers = list.stream().map(item -> DietDto.fromEntity(item));
		return Response.success(trainers);
	}
}
