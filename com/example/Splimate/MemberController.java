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
import org.springframework.web.bind.annotation.DeleteMapping;
@CrossOrigin("/5173")
@RestController
@RequestMapping("/members")
public class MemberController {
@Autowired
public MemberService memberservice;
 
@PostMapping("/add")
public Member addMember(@RequestBody Member member,@RequestParam Long groupId) {
	return memberservice.addMember(member, groupId);
}
@GetMapping("/getgroupmembers")
public List<Member> getMembersByGroup(@RequestParam Long gId){
	return memberservice.getMembersByGroup(gId);
}

@DeleteMapping("/delete")
public String deleteMember(
        @RequestParam Long memberId) {

    memberservice.deleteMember(memberId);

    return "Member Deleted Successfully";
}
}      
