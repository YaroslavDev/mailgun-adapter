package mailgun.web;

import mailgun.Main;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class WebhookController {

    static Logger logger = Logger.getLogger(Main.class);

    @RequestMapping("/status")
    public String status() {
        return "Status: OK";
    }

    @RequestMapping(value = "/delivered", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Boolean webhook(@RequestParam("event") String event) {
        logger.info("Received webhook: " + event);
        return true;
    }

    @RequestMapping(value = "/dropped", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean webhook(@RequestBody MultipartFile[] files) {
        logger.info("Received webhook: " + files);
        return true;
    }
}