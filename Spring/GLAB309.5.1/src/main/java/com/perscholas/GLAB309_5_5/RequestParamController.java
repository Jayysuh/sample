package com.perscholas.GLAB309_5_5;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class RequestParamController {

    /* Binding a request parameter to a method parameter using 'name' or 'value'
     * attribute of @RequestParam */
    @RequestMapping("/request1")
    @ResponseBody
    public String handler(@RequestParam(name = "name") String name) {
        return "URL parameter <br> " + "name =" + name;
        /*(http://localhost:8080/request1?name=David%20Miller)
        URL parameter
         name =David Miller*/
    }


    /* Binding request parameters to method parameters without using 'name' or
     * 'value' attribute of @RequestParam. */
    @RequestMapping("/request2")
    @ResponseBody
    public String handler(@RequestParam String firstName, @RequestParam String
            lastName)
    {
        return "URL parameters - <br>" + " firstName = " + firstName + " <br>" + " lastName = " + lastName;
        /*
        (http://localhost:8080/request2?firstName=David&lastName=Miller)
        URL parameters -
        firstName = David
        lastName = Miller*/
    }


    /* If method parameter type is not String then Spring automatically converts to
    the appropriate type such as int, long, float etc.*/
    @RequestMapping("/request3")
    @ResponseBody
    public String handler(@RequestParam("name") String name,
                          @RequestParam("age") int age,
                          @RequestParam("amount") double amount,
                          @RequestParam("active") boolean active) {
        return "URL parameters - <br>"
                + " name = " + name + " <br>"
                + " age = " + age + " <br>"
                + " amount = " + amount
                + " <br>" + " active = " + active;

        /*(http://localhost:8080/request3?name=David&age=32&amount=1200.50&active=1)
            URL parameters -
            name = David
            age = 32
            amount = 1200.5
            active = true
         */
    }


    /* Binding all request parameters to Map */
    @RequestMapping("/request4")
    @ResponseBody
    public String handler(@RequestParam Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        builder.append("URL parameters - <br>");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.append(entry.getKey() + " = " + entry.getValue() + "<br>");
        }
        return builder.toString();
        /*(http://localhost:8080/request4?name=David&age=32&country=USA&city=NewYork)
        URL parameters -
        name = David
        age = 32
        country = USA
        city = NewYork
         */
    }


    /* The required=false attribute of @RequestParam annotation is used to make a
    method parameter as Optional i.e. it binds a null value to a method parameter if the
    request parameter is not present. */
    @RequestMapping("/request5")
    @ResponseBody
    public String handler(@RequestParam("firstName") String firstName,
                          @RequestParam(name = "middleName", required = false) String
                                  middleName, @RequestParam("lastName") String lastName) {
        return "URL parameters - <br>"
                + " firstName = " + firstName + " <br>"
                + " middleName = " + middleName + " <br>"
                + " lastName = " + lastName;
        /*(http://localhost:8080/request5?firstName=David&lastName=Miller)
        URL parameters -
        firstName = David
        middleName = null
        lastName = Miller
         */
    }


    /* Binding date and time request parameters to LocalDate and LocalTime using
    @DateTimeFormat and @RequestParam */
    @RequestMapping("/request6")
    @ResponseBody
    public String handler(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") LocalDate date,
            @DateTimeFormat(pattern = "HH:mm:ss") @RequestParam("time") LocalTime time)
    {
        return "URL parameters - <br>" + " date = " + date + " <br>" + " time = " + time;
        /*(http://localhost:8080/request6?date=2017-12-12&time=12:54:52)
        URL parameters -
        date = 2017-12-12
        time = 12:54:52
         */
    }


    /* Binding request parameter to array and list */
    @RequestMapping("/request7")
    @ResponseBody
    public String handler(@RequestParam("country") String[] country,
                          @RequestParam("city") List<String> city) {
        return "URL parameters - <br>"
                + " country = " + Arrays.asList(country) + " <br>"
                + " city = " + city;

        /*(http://localhost:8080/request7?country=USA&country=PAKISTAN&country=Japan&city=NYC&city=KARACHI&city=TOKYO)
        URL parameters -
        country = [USA, PAKISTAN, Japan]
        city = [NYC, KARACHI, TOKYO]
         */

    }


    /* Using default value of a method parameter if request parameter is not provided
    or has an empty value */
    @RequestMapping("/request8")
    @ResponseBody
    public String handler(@RequestParam(name = "code", defaultValue = "10") int code
    ) {
        return "URL parameters - <br>" + " code = " + code;
        /*(http://localhost:8080/request8)
        URL parameters -
        code = 10
         */
    }
}
