package mailgun.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    @RequestMapping("/status")
    public String status() {
        return "OK";
    }

    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    public Boolean webhook() {
        return true;
    }
}