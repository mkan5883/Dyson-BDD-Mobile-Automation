package glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverManager;

import java.net.MalformedURLException;

public class Hooks {
    private final DriverManager driverManager;
    private final Logger logger = LoggerFactory.getLogger(Hooks.class);

    public Hooks(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Before
    public void setUp() throws MalformedURLException {
        logger.info("Tests are starting up!");
        driverManager.initializeDriver();
    }

    @After
    public void tearDown() {
        driverManager.quitDriver();
        logger.info("Tests are finished running!");
    }
}
