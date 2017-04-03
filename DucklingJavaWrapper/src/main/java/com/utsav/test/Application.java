package com.utsav.test;
import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.LazySeq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration

public class Application  extends SpringBootServletInitializer {
    private static IFn require = null;

    static {
        require = load();
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);
        String input = "Call me day after tommorow at 6pm";
        String result = extractdatetime(input);
        System.out.println("Result : "+result);
    }

    public static String extractdatetime(String input) throws IOException {
        String result ="";
        try {

            LazySeq o = (LazySeq) Clojure.var("duckling.core", "parse").invoke("en$core", input);
            require.invoke(Clojure.read("clojure.data.json"));
            result = (String) Clojure.var("clojure.data.json", "write-str").invoke(o);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static IFn load() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("duckling.core"));
        Clojure.var("duckling.core", "load!").invoke();
        return require;
    }

}
