package com.springBooot.restfullWebServices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostJPAService extends JpaRepository<Post,User> {
}
