package ru.tkachenko.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dmitry Tkachenko on 19.04.18
 */
@RestController
public class ProducerController {

    @Autowired
    Producer producer;

    @GetMapping("/send")
    public String sendMsg(@RequestParam("msg") String msg){
        producer.send(msg);
        return "Done";
    }
}
