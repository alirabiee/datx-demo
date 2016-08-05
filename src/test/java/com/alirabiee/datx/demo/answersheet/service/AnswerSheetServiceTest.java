package com.alirabiee.datx.demo.answersheet.service;

import com.alirabiee.datx.DatxApplication;
import com.alirabiee.datx.MvcConfig;
import com.alirabiee.datx.demo.answer.domain.Answer;
import com.alirabiee.datx.demo.answersheet.domain.AnswerSheet;
import com.alirabiee.datx.demo.question.domain.Question;
import com.alirabiee.datx.demo.question.service.QuestionService;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import com.alirabiee.datx.demo.questionnaire.service.QuestionnaireService;
import com.alirabiee.datx.enterprise.user.domain.User;
import com.alirabiee.datx.enterprise.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the tests for the question service.
 *
 * Created by A on 2016-08-05.
 */
@SuppressWarnings( "SpringJavaAutowiredMembersInspection" )
@RunWith( SpringRunner.class )
@SpringBootTest( classes = { DatxApplication.class, MvcConfig.class } )
public class AnswerSheetServiceTest {

    private static boolean setupIsDone = false;

    @Autowired
    AnswerSheetService answerSheetService;
    @Autowired
    QuestionnaireService questionnaireService;
    @Autowired
    QuestionService questionService;
    @MockBean
    UserService userService;

    @Before
    public void setup() {
        BDDMockito.given( userService.getCurrentUser() ).willReturn( new User( 1L, "admin", "dummypass" ) );

        if ( setupIsDone ) {
            return;
        }

        answerSheetService.deleteByQuestionnaireId( 1L );

        setupIsDone = true;
    }

    @Test
    public void testSave() throws Exception {
        final AnswerSheet.AnswerSheetBuilder builder = new AnswerSheet().toBuilder();

        final Questionnaire questionnaire = questionnaireService.find( 1L );

        final List< Question > questions = questionService.findByQuestionnaire( questionnaire );

        builder.questionnaire( questionnaire );

        final AnswerSheet answerSheet = builder.build();

        final ArrayList< Answer > answers = new ArrayList<>( questions.size() );

        for ( Question question : questions ) {
            final Answer.AnswerBuilder answerBuilder = new Answer().toBuilder();

            answerBuilder.question( question );
            answerBuilder.choiceIndex( ( int ) ( Math.random() * 4 ) + 1 );

            answers.add( answerBuilder.build() );
        }

        answerSheetService.save( answerSheet, answers );
    }

    @Test( expected = AnswerSheetAlreadyExistsException.class )
    public void testSaveAgain() throws Exception {
        testSave();
    }
}
