package com.example.Splimate;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface GroupRepository extends JpaRepository<GroupEntity,Long>{
	List<GroupEntity> findByUsername(String username);
}
