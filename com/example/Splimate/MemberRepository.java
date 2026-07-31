package com.example.Splimate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface MemberRepository extends JpaRepository<Member,Long>{
	
List<Member> findByGroupentityId(Long groupId);
@Transactional
void deleteByGroupentityId(Long groupId);
}
