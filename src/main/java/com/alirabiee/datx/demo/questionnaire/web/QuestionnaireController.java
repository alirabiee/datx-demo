package com.alirabiee.datx.demo.questionnaire.web;

import com.alirabiee.datx.demo.question.domain.Question;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import com.alirabiee.datx.demo.questionnaire.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

/**
 * Created by A on 2016-08-05.
 */
@RestController
@Secured( "ROLE_ADMIN" )
public class QuestionnaireController {
    @Autowired
    QuestionnaireService service;

    @RequestMapping( value = "/questionnaire", method = RequestMethod.GET )
    public Page< Questionnaire > getList(
        @RequestParam( name = "page", required = false, defaultValue = "1" ) final Integer page
    ) {
        return service.findAll( new PageRequest( page, 10 ) );
    }

    @RequestMapping( value = "/questionnaire", method = RequestMethod.POST )
    public Questionnaire addQuestionnaire(
        @RequestBody Questionnaire questionnaire
    ) {
        return service.save( questionnaire );
    }

    @Secured( { "ROLE_ADMIN", "RULE_USER" } )
    @RequestMapping( value = "/questionnaire/primary", method = RequestMethod.GET )
    public Questionnaire getThePrimary() {
        final Questionnaire primary = service.findThePrimary();

        for ( Question question : primary.getQuestions() ) {
            question.setQuestionnaire( null );
        }

        return primary;
    }
}
