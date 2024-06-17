package com.perscholas.GLAB309_5_2.Controller;

import com.perscholas.GLAB309_5_2.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {

    @PostMapping("/users")
    public void printData(@RequestBody User user) {
        System.out.println("Printing the user data:"+user);
    }}

/* The @RequestBody annotation allows us to retrieve the request’s body and
automatically convert it to a Java Object. This annotation needs to be specified when
an object is passed to a method. It automatically deserializes the JSON object to a Java
object.

@PostMapping annotated methods handle the HTTP POST requests matched with a
given URI expression.
Note: @PostMapping acts as a shortcut for @RequestMapping(method =
RequestMethod.POST*/
