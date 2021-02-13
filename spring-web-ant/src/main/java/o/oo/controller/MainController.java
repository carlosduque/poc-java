package o.oo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import o.oo.service.RedisService;

/**
 * How it works?
 * http://localhost:8080/spring2/welcome.form is requested.
 * URL ends with “.form” extension, so it will redirect to “DispatcherServlet”
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

public class MainController extends AbstractController {

    private RedisService service = null;
 
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        //the jsp page to display
        ModelAndView model = new ModelAndView("MainPage");
        model.addObject("msg", service.retrieve("hello"));
        
        return model;
    }
    
    public void setService(RedisService newService) {
        this.service = newService;
    }
}