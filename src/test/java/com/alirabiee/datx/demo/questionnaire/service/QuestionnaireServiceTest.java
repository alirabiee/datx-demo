package com.alirabiee.datx.demo.questionnaire.service;

import com.alirabiee.datx.DatxApplication;
import com.alirabiee.datx.MvcConfig;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This class contains the tests for the questionnaire service.
 *
 * Created by A on 2016-08-05.
 */
@SuppressWarnings( "SpringJavaAutowiredMembersInspection" )
@RunWith( SpringRunner.class )
@SpringBootTest( classes = { DatxApplication.class, MvcConfig.class } )
public class QuestionnaireServiceTest {
    @Autowired
    private QuestionnaireService questionnaireService;

    @Test
    public void testGetAll() throws Exception {
        questionnaireService.findAll();
    }

    @Test
    public void testSaveNonPrimary() throws Exception {
        final Questionnaire.QuestionnaireBuilder builder = new Questionnaire().toBuilder();

        builder.title( "Test Questionnaire" )
               .isPrimary( false );

        questionnaireService.save( builder.build() );
    }

    @Test
    public void testSavePrimary() throws Exception {
        final Questionnaire.QuestionnaireBuilder builder = new Questionnaire().toBuilder();

        builder.title( "Test Primary Questionnaire" )
               .isPrimary( true );

        final Questionnaire questionnaire = builder.build();

        questionnaireService.save( questionnaire );

        final Questionnaire thePrimary = questionnaireService.findThePrimary();

        Assertions.assertThat( questionnaire ).isEqualToComparingOnlyGivenFields( thePrimary, "id" );
    }

    @Test
    public void testSaveSecondPrimary() throws Exception {
        final Questionnaire.QuestionnaireBuilder builder = new Questionnaire().toBuilder();

        builder.title( "Test Second Primary Questionnaire" )
               .isPrimary( true );

        final Questionnaire questionnaire = builder.build();

        questionnaireService.save( questionnaire );

        final Questionnaire thePrimary = questionnaireService.findThePrimary();

        Assertions.assertThat( questionnaire ).isEqualToComparingOnlyGivenFields( thePrimary, "id" );
    }
}
