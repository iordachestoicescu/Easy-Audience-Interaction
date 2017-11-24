package com.endava.easyaudienceinteraction.service;

import com.endava.easyaudienceinteraction.entity.Question;
import com.endava.easyaudienceinteraction.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Laurentiu Iordache
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question create(String subject, String name, String email, String content, int votes) {
        return questionRepository.save(new Question(subject, name, email, content, votes));
    }

    @Override
    public Question findOne(Long id) {
        return questionRepository.findOne(id);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question update(Question question) {
        System.out.println(question.toString());
        Question q = questionRepository.findOne(question.getId());
        q.setVotes(question.getVotes());
        q.setContent(question.getContent());
        q.setSubject(question.getSubject());
        q.setEmail(question.getEmail());
        q.setName(question.getName());
        questionRepository.save(q);

        return q;
    }

    @Override
    public Question update(Long id, String subject, String name, String email, String content, int votes) {
        Question question = questionRepository.findOne(id);
        question.setSubject(subject);
        question.setName(name);
        question.setEmail(email);
        question.setContent(content);
        question.setVotes(votes);
        questionRepository.save(question);

        return question;
    }

    @Override
    public void delete(Long id) {
        questionRepository.delete(id);
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }
}
