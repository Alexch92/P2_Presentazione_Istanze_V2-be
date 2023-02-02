package com.sincon.p2_presentazione_istanze_v2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

@SpringBootApplication
public class SpringAppApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringAppApplication.class);

    
	public static void main(String[] args) {
    
        SpringApplication app = new SpringApplication(SpringAppApplication.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
	}

    private static void logApplicationStartup(Environment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(contextPath)) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info("\n----------------------------------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}{}\n\t" +
                "External: \t{}://{}:{}{}\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol,
            serverPort,
            contextPath,
            protocol,
            hostAddress,
            serverPort,
            contextPath,
            env.getActiveProfiles());
    }

}

@Component
class ActiveProfilesLoggerRunner implements CommandLineRunner {

    @Autowired
    private Environment environment;

    private static final Logger log = LoggerFactory.getLogger(ActiveProfilesLoggerRunner.class);

    @Override
    public void run(String... args) throws Exception {

        log.info("Active profiles: " + Arrays.toString(environment.getActiveProfiles()));
    }
}

@Component
@Profile(value="dev")
class DevRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DevRunner.class);

    // @Autowired
    // private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

        log.debug("In development");

        // String sql = "INSERT INTO Student (name) VALUES ("
        //            + "'nam@codejava.net')";

        // int rows = jdbcTemplate.update(sql);

        // if (rows > 0) {
        //     System.out.println("A new row has been inserted.");
        // }

        // Context context = new InitialContext();
        // DataSource dataSource = (DataSource) context.lookup("java:comp/localhost:3306/jdbc/db_presentazione_istanze");

    }
}

@Component
@Profile(value="prod & !dev")
class ProdRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In production");
    }
}

@Component
@Profile(value="local")
class LocalRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In local");
    }
}

@Component
@Profile(value={"dev & local"})
class DevAndLocalRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In development and local");
    }
}

@Component
@Profile(value={"dev", "prod"})
class DevOrProdRunner implements CommandLineRunner {

    @Value("${message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Message: " + message);
    }
}
