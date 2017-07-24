package bot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/webhook")
public class BotController {

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody WebhookResponse webhook(@RequestBody String obj){
  System.out.println(obj);
        String indate = obj.substring(obj.indexOf("inDate"),20);
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String d = "20170724";
        Date date1 = new Date();
        try {
            date = f.parse(indate);
           date1 = f.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        if (date.after(date1))
            return new WebhookResponse("https://www.google.com", "https://www.google.com");
        else
            return new WebhookResponse("hey","hey");
    }
}
