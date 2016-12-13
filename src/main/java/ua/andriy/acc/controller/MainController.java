package ua.andriy.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by andriy on 11/19/16.
 */
@Controller
@RequestMapping(MainController.BASE_URL)
public class MainController {

    protected static final String BASE_URL = "/";

    @RequestMapping(value = {"","/","index"},method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
