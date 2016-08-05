package com.alirabiee.datx.demo.questionnaire.service;

import com.alirabiee.datx.DatxApplication;
import com.alirabiee.datx.MvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by A on 2016-08-05.
 */
@RunWith( SpringRunner.class )
@SpringBootTest( classes = { DatxApplication.class, MvcConfig.class } )
public class QuestionnaireServiceTest {
    @Autowired
    private QuestionnaireService questionnaireService;

    @Test
    public void testGetAll() throws Exception {
        System.out.println( "QuestionnaireServiceTest.testGetAll" );
        questionnaireService.findAll();
        System.out.println( "QuestionnaireServiceTest.testGetAll [OK]" );
    }
}
