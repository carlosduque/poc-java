package o.oo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import o.oo.service.Service;
import o.oo.vo.Word;

public class MainAbstractController extends AbstractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainAbstractController.class);

    private Service service = null;
 
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        //for the rest of controllers, the parameter name must match a setter in the commandClass
        Word word = new Word(request.getParameter("in"));

        LOGGER.info("::handleRequestInternal: " + word);
 
        //the jsp page to display
        ModelAndView model = new ModelAndView("MainAbstractPage");
        model.addObject("result", service.process(word));
        
        return model;
    }
    
    public void setService(Service newService) {
        this.service = newService;
    }
    
}
