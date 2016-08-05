package com.alirabiee.datx.demo.questionnaire;

import com.alirabiee.datx.DatxTestApplication;
import com.alirabiee.datx.MvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This class contains the tests for the question service.
 * <p>
 * Created by A on 2016-08-05.
 */
@SuppressWarnings( "SpringJavaAutowiredMembersInspection" )
@RunWith( SpringRunner.class )
@SpringBootTest( classes = { DatxTestApplication.class, MvcConfig.class } )
@AutoConfigureMockMvc
@ActiveProfiles(value = "test")
public class QuestionnaireControllerTest {
    @Autowired
    private MockMvc mvc;

//    @MockBean
//    private QuestionnaireService questionnaireService;

    @Test
    public void testSaveQuestionnaire() throws Exception {
//        given(
//            questionnaireService.save( any( Questionnaire.class ) )
//        ).willReturn(
//            new Questionnaire().toBuilder().title( "hahaha" ).build()
//        );

        mvc.perform( MockMvcRequestBuilders
                         .post( "/questionnaire" )
                         .accept( MediaType.APPLICATION_JSON )
                         .contentType( MediaType.APPLICATION_JSON )
                         .content( "{\"title\":\"hahaha\"}" ) )
           .andExpect( status().isOk() );
    }

    @Test
    public void testUpdateQuestionnaire() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                         .post( "/questionnaire" )
                         .accept( MediaType.APPLICATION_JSON )
                         .contentType( MediaType.APPLICATION_JSON )
                         .content( "{\"title\":\"hahaha" + Math.random() + "\", \"id\":118, \"isPrimary\": true}" ) )
           .andExpect( status().isOk() );
    }
}
