package com.alirabiee.datx.demo.question.service;

import com.alirabiee.datx.DatxApplication;
import com.alirabiee.datx.MvcConfig;
import com.alirabiee.datx.demo.question.domain.Question;
import com.alirabiee.datx.demo.questionnaire.service.QuestionnaireService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This class contains the tests for the question service.
 *
 * Created by A on 2016-08-05.
 */
@SuppressWarnings( "SpringJavaAutowiredMembersInspection" )
@RunWith( SpringRunner.class )
@SpringBootTest( classes = { DatxApplication.class, MvcConfig.class } )
public class QuestionServiceTest {
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionnaireService questionnaireService;

    @Test
    public void testSave() throws Exception {
        final Question.QuestionBuilder builder = new Question().toBuilder();

        builder.title( "Q1" );
        builder.questionnaire( questionnaireService.find( 1L ) );
        builder.choice1( "C1" );
        builder.choice2( "C2" );
        builder.choice3( "C3" );
        builder.choice4( "C4" );

        final Question question = builder.build();

        questionService.save( question );
    }
}
