
package com.greglturnquist.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Greg Turnquist
 */

@SpringBootApplication

// The last step needed to get a fully operational REST API off the ground
// is to write a public static void main method by using Spring Boot, as follows:
public class ReactAndSpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactAndSpringDataRestApplication.class, args);
    }
}
// end::code[]