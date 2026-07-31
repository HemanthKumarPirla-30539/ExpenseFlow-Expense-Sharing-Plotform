package com.example.Splimate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

	@Autowired
	public GroupRepository grouprepo;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	public GroupEntity createGroup(GroupEntity group) {
		return  grouprepo.save(group);
	}
	public List<GroupEntity> getAllGroup(){
		return grouprepo.findAll();
	}
	public List<GroupEntity> getGroupsByUsername(String username){
	    return grouprepo.findByUsername(username);
	}
	public void deleteGroup(Long groupId) {

	    expenseRepository.deleteByGroupId(groupId);

	    memberRepository.deleteByGroupentityId(groupId);

	    grouprepo.deleteById(groupId);

	}
}
