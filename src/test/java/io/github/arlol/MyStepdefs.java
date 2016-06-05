package io.github.arlol;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JbrowserdriverCucumberIntegrationTestsApplication.class, loader = SpringApplicationContextLoader.class)
@WebIntegrationTest(randomPort = true)
public class MyStepdefs {

	@Value("${local.server.port}")
	private int port;
	private WebDriver driver = new JBrowserDriver();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() {
		driver.get("http://localhost:" + port);
	}

	@Then("^I see \"(.*)\"")
	public void I_see(String string) {
		WebElement findElement = driver.findElement(By.cssSelector("h1"));
		Assert.assertEquals(findElement.getText(), string);
	}

}
