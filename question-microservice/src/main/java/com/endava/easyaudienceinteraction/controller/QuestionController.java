package com.endava.easyaudienceinteraction.controller;

import com.endava.easyaudienceinteraction.entity.Question;
import com.endava.easyaudienceinteraction.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Laurentiu Iordache
 */

@Controller
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:9090")
public class QuestionController {

    QuestionService questionService;

    @Autowired
    QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Question create(@RequestBody(required = true) Question question) {
        return questionService.create(question);
    }

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Question create(@RequestParam(value = "subject") String subject,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "content") String content,
                           @RequestParam(value = "votes") int votes) {
        return questionService.create(subject, name, email, content, votes);
    }

    @RequestMapping(value = "/findOne",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Question findOne(@RequestParam(value = "id") Long id) {
        return questionService.findOne(id);
    }

    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Question update(@RequestBody Question question){
        return questionService.update(question);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Question update(@RequestParam(value = "id") Long id,
                           @RequestParam(value = "subject") String subject,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "content") String content,
                           @RequestParam(value = "votes") int votes) {
        return questionService.update(id, subject, name, email, content, votes);
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestParam(value = "id") Long id) {
        questionService.delete(id);
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Question question) {
        questionService.delete(question);
    }

}
