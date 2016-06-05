package io.github.arlol;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JbrowserdriverCucumberIntegrationTestsApplication.class)
@WebIntegrationTest(value = "server.port=9000")
public class HomeControllerTest {
	
	private JBrowserDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new JBrowserDriver(Settings.builder().timezone(Timezone.AMERICA_NEWYORK).build());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testName() throws Exception {
		// This will block for the page load and any
		// associated AJAX requests
		driver.get("http://localhost:9000");

		// You can get status code unlike other Selenium drivers.
		// It blocks for AJAX requests and page loads after clicks
		// and keyboard events.
		System.out.println(driver.getStatusCode());

		// Returns the page source in its current state, including
		// any DOM updates that occurred after page load
		System.out.println(driver.getPageSource());
	}

}