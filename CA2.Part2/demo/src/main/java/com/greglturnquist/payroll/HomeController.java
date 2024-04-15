
package com.greglturnquist.payroll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Controller // <1>
public class HomeController {

    @RequestMapping(value = "/") // <2> // (api/employee)
    public String index() {
        return "index"; // <3>
    }
}
// end::code[]