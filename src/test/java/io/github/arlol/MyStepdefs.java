package io.github.arlol;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;

import cucumber.api.java.en.Given;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JbrowserdriverCucumberIntegrationTestsApplication.class, loader = SpringApplicationContextLoader.class)
@WebIntegrationTest(randomPort = true)
public class MyStepdefs {
	
    @Value("${local.server.port}")
    private int port;
    
    @Before
	public void setUp() throws Exception {
		System.out.println("Herro");
	}
    
	@Given("I have (\\d+) cukes in my belly")
	public void I_have_cukes_in_my_belly(int cukes) {
		System.out.format("Cukes: %n\n", cukes);
		JBrowserDriver driver = new JBrowserDriver(Settings.builder().timezone(Timezone.AMERICA_NEWYORK).build());
		driver.get("http://localhost:" + port);
		System.out.println(driver.getPageSource());
		driver.close();
	}

}
