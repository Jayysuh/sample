package com.perscholas.GLAB309_5_6;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class PathVariableController {
    /* Binding a URI template variable to a method parameter using 'name' or
    'value' attribute of @PathVariable */
    @GetMapping("/request1/{name}")
    @ResponseBody
    public String handler(@PathVariable(name = "name") String name) {
        return "URL parameter name: " + name;
        /*(http://localhost:8080/request1/Haseeb)
        URL parameter name: Haseeb
         */
    }



    /* Binding URI template variables to method parameters without using 'name'
    or 'value' attribute of @PathVariable. */
    @GetMapping("/request2/{firstName}/{lastName}")
    @ResponseBody
    public String handler(@PathVariable String firstName, @PathVariable String
            lastName) {
        return "URL parameters - <br>"
                + " firstName = " + firstName + " <br>"
                + " lastName = " + lastName;
        /*http://localhost:8080/request2/Muhammad/Haseeb
            URL parameters -
            firstName = Muhammad
            lastName = Haseeb
         */
    }


    /* If the method parameter type is not String then Spring automatically
    converts to the appropriate type such as int, long, float, etc. */
    @GetMapping("/request3/{name}/{age}/{salary}/{active}")
    @ResponseBody
    public String handler(@PathVariable("name") String name,
                          @PathVariable("age") int age,
                          @PathVariable("salary") double salary,
                          @PathVariable("active") boolean active) {
        return "URL parameters - <br>"
                + " name = " + name + " <br>"
                + " age = " + age + " <br>"
                + " salary = " + salary
                + " <br>" + " active = " + active;
        /*(http://localhost:8080/request3/David/45/45000.00/1)
        URL parameters -
        name = David
        age = 45
        salary = 45000.0
        active = true
         */
    }


    /* Binding all URI template variables to Map */
    @GetMapping("/request4/{name}/{age}/{address}/{city}/{country}")
    @ResponseBody
    public String handler(@PathVariable Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        builder.append("URL parameters - <br>");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.append(entry.getKey() + " = " + entry.getValue() + "<br>");
        }
        return builder.toString();
        /*(http://localhost:8080/request4/David/45/105thST/Nyc/USA)
        URL parameters -
        country = USA
        address = 105thST
        city = Nyc
        name = David
        age = 45
         */
    }



    /*Binding date and time URL template variable to LocalDate and LocalTime */
    @GetMapping("/request5/{date}/{time}")
    @ResponseBody
    public String handler(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("date") LocalDate date,
            @DateTimeFormat(pattern = "HH:mm:ss") @PathVariable("time")
            LocalTime time) {
        return "URL parameters - <br>"
                + " date = " + date + " <br>"
                + " time = " + time;
        /*(http://localhost:8080/request5/2017-04-09/12:15:25)
        URL parameters -
        date = 2017-04-09
        time = 12:15:25
         */
    }


    /*Binding URI template variable to array and list */
    @GetMapping("/request6/{country}/{city}")
    @ResponseBody
    public String handler(@PathVariable("country") String[] country,
                          @PathVariable("city") List<String> city) {
        return "URL parameters - <br>"
                + " country = " + Arrays.asList(country) + " <br>"
                + " city = " + city;
        /*(http://localhost:8080/request6/IND,USA,JPN,UK,AUS/DELHI,JANAN,NEW%20YORK)
        URL parameters -
        country = [IND, USA, JPN, UK, AUS]
        city = [DELHI, JANAN, NEW YORK]
         */
    }
}
