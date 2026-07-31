package com.example.Splimate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberrepo;
	
	@Autowired
	private GroupRepository grouprepository; //Does GRoup Exists
	
	public Member addMember(Member member, Long groupId) {

	    GroupEntity group = grouprepository.findById(groupId)
	            .orElseThrow(() -> new RuntimeException("Group Not Found"));

	    member.setGroupEntity(group);

	    return memberrepo.save(member);
	}
	
	public List<Member> getMembersByGroup(Long groupId){
		return memberrepo.findByGroupentityId(groupId);
	}
	public void deleteMember(Long memberId) {

	    memberrepo.deleteById(memberId);

	}
}
