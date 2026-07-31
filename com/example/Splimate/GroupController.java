package com.example.Splimate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/groups")
public class GroupController {

	@Autowired
	public GroupService groupservice;
	
	@PostMapping("/create")
	public GroupEntity createGroup(@RequestBody GroupEntity ge) {
		return groupservice.createGroup(ge);
	}
	@GetMapping("/getgroups")
	public List<GroupEntity> getAllGroups(){
		return groupservice.getAllGroup();
	}
	@GetMapping("/mygroups")
	public List<GroupEntity> myGroups(
	        @RequestParam String username){

	    return groupservice.getGroupsByUsername(username);
	}
	@GetMapping("/count")
	public long groupCount() {
	    return groupservice.getAllGroup().size();
	}
	@DeleteMapping("/delete")
	public String deleteGroup(
	        @RequestParam Long groupId) {

	    groupservice.deleteGroup(groupId);

	    return "Group Deleted Successfully";
	}
}
