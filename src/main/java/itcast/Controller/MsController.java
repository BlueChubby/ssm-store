package itcast.Controller;

import itcast.Pojo.Ms;
import itcast.Service.MsServiceImpl;
import itcast.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/ms")
public class MsController {

    @Autowired
    private MsServiceImpl msservice;
    @RequestMapping(path = "/msstart")
    public @ResponseBody
    Integer msStart(Ms ms) {
        Integer integer = msservice.msStart(ms);
        return integer;
    }

    @RequestMapping(path = "/msfind")
    public @ResponseBody Ms msFind() {
        Ms ms =msservice.msFind();
        return ms;
    }
}
