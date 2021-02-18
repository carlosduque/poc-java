package o.oo.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import o.oo.service.RandomizerService;
import o.oo.service.Service;
import o.oo.vo.Word;

/**
 * curl -X POST -d 'content=rAyoZ' http://localhost:8080/spring-web-ant/mainCommand.do
 * How it works?
 * http://localhost:8080/spring-web-ant/mainAbstract.do is requested.
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

public class MainCommandController extends AbstractCommandController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainCommandController.class);

    private Service service = null;
    private RandomizerService idGen = null;
    private RandomizerService nameGen = null;
 
    public void setService(Service newService) {
        this.service = newService;
    }
 
    public void setIdGenerator(RandomizerService newService) {
        this.idGen = newService;
    }

    public void setNameGenerator(RandomizerService newService) {
        this.nameGen = newService;
    }

    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response,
                                  Object command, BindException error) throws Exception {

        Word word = (Word) command;
        LOGGER.info("::handle: " + word);
        String result = idGen.generate() + ": " + nameGen.generate() + " says " + service.process(word) + " !!!";

        return new ModelAndView("MainCommandPage", "result", result);
    }
    
}