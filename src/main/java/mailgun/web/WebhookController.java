package mailgun.web;

import mailgun.Main;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class WebhookController {

    static Logger logger = Logger.getLogger(Main.class);

    @RequestMapping("/status")
    public HttpEntity<String> status() {
        return new HttpEntity<>("Status: OK");
    }

    @RequestMapping(value = "/delivered", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public HttpEntity<String> delivered(@RequestParam("event") String event) {
        logger.info("Received webhook: " + event);
        return new HttpEntity<>("Received delivered");
    }

    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    public HttpEntity<String> dropped(@RequestParam final MultiValueMap<String, String> event) {
        logger.info("Received webhook: " + event);
        return new HttpEntity<>("Received dropped");
    }
}