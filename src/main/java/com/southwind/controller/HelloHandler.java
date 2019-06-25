package com.southwind.controller;
import com.southwind.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class HelloHandler {

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/if")
    public ModelAndView ifTest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("score",90);
        return modelAndView;
    }

    @GetMapping("/unless")
    public ModelAndView unlessTest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("score",90);
        return modelAndView;
    }

    @GetMapping("/switchcase")
    public ModelAndView switchcase(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("studentId",1);
        return modelAndView;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName,@RequestParam("password") String password){
        System.out.println(userName);
        System.out.println(password);
        return "login";
    }

    @GetMapping("/each")
    public ModelAndView each(){
        List<User> list = new ArrayList<>();
        list.add(new User(1L,"张三",1));
        list.add(new User(2L,"李四",0));
        list.add(new User(3L,"王五",1));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @GetMapping("/value")
    public ModelAndView value(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("value","Spring Boot");
        return modelAndView;
    }

    @GetMapping("/src")
    public ModelAndView src(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("src","/images/springboot.png");
        return modelAndView;
    }

    @GetMapping("/href")
    public ModelAndView href(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("href","https://spring.io/projects/spring-boot/");
        return modelAndView;
    }

    @GetMapping("/selected")
    public ModelAndView selected(){
        List<User> list = new ArrayList<>();
        list.add(new User(1L,"张三",1));
        list.add(new User(2L,"李四",0));
        list.add(new User(3L,"王五",1));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("list",list);
        modelAndView.addObject("name","李四");
        return modelAndView;
    }

    @GetMapping("/attr")
    public ModelAndView attr(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("attr","Spring Boot");
        return modelAndView;
    }

    @GetMapping("/servlet")
    public String servlet(HttpServletRequest request){
        request.setAttribute("value","request");
        request.getSession().setAttribute("value","session");
        request.getServletContext().setAttribute("value","servletContext");
        return "test";
    }

    @GetMapping("/servlet2")
    public ModelAndView servlet2(HttpSession session){
        session.setAttribute("name","李四");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("name","张三");
        return modelAndView;
    }

    @GetMapping("/utility")
    public ModelAndView utility(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("date",new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019,5,5);
        modelAndView.addObject("calendar",calendar);
        modelAndView.addObject("number",0.06);
        modelAndView.addObject("string","Spring Boot");
        modelAndView.addObject("boolean",true);
        modelAndView.addObject("array", Arrays.asList("张三","李四","王五"));
        List<User> list = new ArrayList<>();
        list.add(new User(1L,"张三",1));
        list.add(new User(2L,"李四",0));
        list.add(new User(3L,"王五",1));
        modelAndView.addObject("list",list);
        Set<User> set = new HashSet<>();
        set.add(new User(1L,"张三",1));
        set.add(new User(2L,"李四",0));
        set.add(new User(3L,"王五",1));
        modelAndView.addObject("set",set);
        Map<Long,User> map = new HashMap<>();
        map.put(1L,new User(1L,"张三",1));
        map.put(2L,new User(2L,"李四",0));
        map.put(3L,new User(3L,"王五",1));
        modelAndView.addObject("map",map);
        return modelAndView;
    }
}
