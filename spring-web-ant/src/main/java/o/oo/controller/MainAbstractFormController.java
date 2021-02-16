package o.oo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractFormController;

import o.oo.service.Service;
import o.oo.vo.Word;

public class MainAbstractFormController extends AbstractFormController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainAbstractFormController.class);

    private Service service = null;
 
    protected ModelAndView showForm(HttpServletRequest request,
        HttpServletResponse response, BindException error) {
        LOGGER.info("::showForm");
        return new ModelAndView("MainAbstractFormPage");
    }

    protected ModelAndView processFormSubmission(HttpServletRequest request,
        HttpServletResponse response, Object command, BindException error) throws Exception {
 
        Word word = (Word) command;
        LOGGER.info("::processFormSubmission: " + word);

        //the jsp page to display
        return new ModelAndView("MainAbstractFormPageSuccess", "result", service.process(word));
    }
    
    public void setService(Service newService) {
        this.service = newService;
    }
    
}
