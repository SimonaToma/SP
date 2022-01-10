package ro.uvt.controllers;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.difexamples.ClientComponent;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "Hello from Srping Boot";
    }

    @Autowired
    private ClientComponent clientComponent;

    @RequestMapping("/clientComponent")
    @GetMapping
    public String get(){
        return clientComponent.get();
    }
}
