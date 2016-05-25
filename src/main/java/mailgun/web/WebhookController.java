package mailgun.web;

import mailgun.Main;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    static Logger logger = Logger.getLogger(Main.class);

    @RequestMapping("/status")
    public String status() {
        return "Status: OK";
    }

    @RequestMapping(value = "/webhook", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean webhook(@RequestBody final MultiValueMap<String, String> body) {
        logger.info("Received webhook: " + body);
        return true;
    }
}