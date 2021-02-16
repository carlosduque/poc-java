package o.oo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import o.oo.vo.Word;

public class DefaultService implements Service {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultService.class);

    public String process(Word word) {
        LOGGER.info("processing: " + word);
        return word.getContent().toUpperCase();
    }
}