package com.mde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mde.cli.MdeGenCli;

@SpringBootApplication
public class MdeWebApplication {

    public static void main(String[] args) {
        // If arguments are provided, run CLI mode
        if (args.length > 0) {
            System.exit(MdeGenCli.runCli(args));
        }

        // Otherwise, start web server
        SpringApplication.run(MdeWebApplication.class, args);
    }

}
