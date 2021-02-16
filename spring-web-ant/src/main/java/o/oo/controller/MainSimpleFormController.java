package o.oo.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import o.oo.service.Service;
import o.oo.vo.Word;

/**
 * How it works?
 * http://localhost:8080/simple-web-ant/mainSimpleForm.do is requested.
 * URL ends with “.do” extension, so it will redirect to “DispatcherServlet”
 * and send requests to the default BeanNameUrlHandlerMapping.
 *
 * BeanNameUrlHandlerMapping returns MainController to the DispatcherServlet.
 * DispatcherServlet forwards request to the MainController.
 * MainController process it and return a ModelAndView object, with view name
 * “MainPage”.
 * DispatcherServlet received the ModelAndView and calls the viewResolver to process it.
 * viewResolver returns the /WEB-INF/pages/MainPage.jsp back to the DispatcherServlet.
 * DispatcherServlet returns the “MainPage.jsp” back to the user.
**/

public class MainSimpleFormController extends SimpleFormController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainSimpleFormController.class);

    private Service service = null;
 
    protected ModelAndView onSubmit(HttpServletRequest request,
        HttpServletResponse response, Object command) throws Exception {

        Word word = (Word) command;
        LOGGER.info("::onSubmit: " + word);

        return new ModelAndView("MainSimpleFormPageSuccess", "result", service.process(word));
    }
    
    public void setService(Service newService) {
        this.service = newService;
    }
    
}