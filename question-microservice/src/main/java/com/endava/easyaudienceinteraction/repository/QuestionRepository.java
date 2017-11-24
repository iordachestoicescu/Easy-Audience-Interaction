package com.endava.easyaudienceinteraction.repository;

import com.endava.easyaudienceinteraction.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author Laurentiu Iordache
 */

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
