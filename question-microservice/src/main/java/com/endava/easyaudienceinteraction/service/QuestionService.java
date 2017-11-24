package com.endava.easyaudienceinteraction.service;

import com.endava.easyaudienceinteraction.entity.Question;

import java.util.List;

/**
 * @author Laurentiu Iordache
 */
public interface QuestionService {

    Question create(Question question);

    Question create(String subject, String name, String email, String content, int votes);

    Question findOne(Long id);

    List<Question> findAll();

    Question update(Question question);

    Question update(Long id, String subject, String name, String email, String content, int votes);

    void delete(Long id);

    void delete(Question q);


}
