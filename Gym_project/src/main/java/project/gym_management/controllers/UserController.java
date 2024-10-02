package project.gym_management.controllers;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.gym_management.dto.Credentials;
import project.gym_management.dto.FeedbackDto;
import project.gym_management.dto.MemberPlanDto;
import project.gym_management.dto.PlanDto;
import project.gym_management.dto.Response;
import project.gym_management.entities.TableFeedback;
import project.gym_management.entities.TableMemberPlan;
import project.gym_management.entities.TablePlan;
import project.gym_management.entities.TableUser;
import project.gym_management.services.TableFeedbackService;
import project.gym_management.services.TableMemberPlanService;
import project.gym_management.services.TablePlanService;
import project.gym_management.services.TableUserService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	TableFeedbackService feedService;
	@Autowired
	TableUserService tbluserservice;
	@Autowired
	TableMemberPlanService tblMemberPlanService;
	@Autowired
	TablePlanService tblplanservice;

	@GetMapping("/getAllInfo/{user_id}")
	public ResponseEntity<?> getAddInfo(@PathVariable("user_id") int user_id) {
		TableUser allInfo = tbluserservice.getAllInfo(user_id);
		Credentials dtoInfo = Credentials.allDataTODto(allInfo);
		return Response.success(dtoInfo);
	}

	@RequestMapping("/updateBasicInfo")
	public ResponseEntity<?> updateBasicInfo(@RequestBody Credentials cred) {
		String message = tbluserservice.updateUser(cred);
		return Response.success(message);
	}

	@RequestMapping("/forgotpassword")
	public ResponseEntity<?> forgotPassword(@RequestBody Credentials cred) {
		String message = tbluserservice.forgotPassword(cred);
		return Response.success(message);
	}

	@RequestMapping("/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody Credentials cred) {
		tbluserservice.changePassword(cred);
		return Response.success("success");
	}

	/* Table Feedback REST */

	@RequestMapping("/postfeedback")
	public ResponseEntity<?> addFeedback(@RequestBody FeedbackDto feed) {
		feedService.addFeedback(feed);
		return Response.success("success");
	}

	@RequestMapping("/getUserFeedbacks/{user_id}")
	public ResponseEntity<?> getUserFeedbacks(@PathVariable("user_id") int user_id) {
		List<TableFeedback> feedList = feedService.getUserFeedbackById(user_id);
		Stream<FeedbackDto> feedbacks = feedList.stream().map(feedback -> FeedbackDto.fromEntity(feedback));
		return Response.success(feedbacks);
	}

	/* Table MemberPlan REST */

	@RequestMapping("/getUserPlans/{user_id}")
	public ResponseEntity<?> getUserPlans(@PathVariable("user_id") int user_id) {
		TableUser addinfo = tbluserservice.getById(user_id);
		Stream<PlanDto> allplans = addinfo.getPlanList().stream().map(plan -> PlanDto.fromEntityList(plan));
		return Response.success(allplans);
	}

	@RequestMapping("/addUserPlan")
	public ResponseEntity<?> addUserPlan(@RequestBody MemberPlanDto mpDto) {
		String message = tblMemberPlanService.addUserPlan(mpDto);
		return Response.success(message);
	}

	@RequestMapping("/deleteUserPlan")
	public ResponseEntity<?> deleteUserPlan(@RequestBody MemberPlanDto mpDto) {
		tblMemberPlanService.deleteUserPlan(mpDto);
		return Response.success("success");
	}

	@RequestMapping("/endDate")
	public ResponseEntity<?> endDate(@RequestBody MemberPlanDto mpDto) {
		TablePlan plan1 = tblplanservice.findPlan(mpDto.getPlan_id());
		TableMemberPlan endDate = tblMemberPlanService.endDate(mpDto);
		MemberPlanDto plan = MemberPlanDto.fromEntityList(endDate, plan1.getDuration());
		return Response.success(plan);
	}
}
