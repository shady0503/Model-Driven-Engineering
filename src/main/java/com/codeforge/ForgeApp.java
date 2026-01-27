package com.codeforge;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.codeforge.cli.ForgeCli;

@SpringBootApplication
public class ForgeApp {

    public static void main(String[] args) {
        System.exit(ForgeCli.runCli(args));
    }
}
