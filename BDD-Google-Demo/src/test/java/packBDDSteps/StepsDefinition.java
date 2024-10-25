package packBDDSteps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition 
{
	static WebDriver driver;
	public WebDriverWait wait;
	public String url,title,fn;
	
	@Before("@Google")
	public void Open()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		

	}
	
	
	@Given("Google HomePage is Open")
	public void google_home_page_is_open() {
	    // Write code here that turns the phrase above into concrete actions
		url="http://google.com";
	    driver.get(url);
	    title=driver.getTitle();
	    System.out.println("Home Page : " + title);
	}

	@When("I Type SearchKey")
	public void i_type_search_key() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium");
	}

	@When("Click GoogleSearch")
	public void click_google_search() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement submitBtn=driver.findElement(By.name("btnK"));
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
	}

	@Then("SearchPage Opens")
	public void search_page_opens() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("I click on FirstSuggested Link")
	public void i_click_on_first_suggested_link() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@id='rso']/descendant::a[1]")).click();
		System.out.println("Searched Page Title is : " + driver.getTitle());
	}
	
	// scenario with example
	
	@When("I Type SearchKey as {string}")
	public void i_type_search_key_as(String searchKey) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys(searchKey);
	}

	@Then("SearchPage Opens with expURL {string}")
	public void search_page_opens_with_exp_url(String expUrl) {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertTrue(driver.getCurrentUrl().contains(expUrl), "URL not correct");
	}

	@Then("print the pageTitle")
	public void print_the_page_title() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Page Title : " + driver.getTitle());
	}
	
	@After("@Google")
	public void Close()
	{
		
		driver.quit();
	}
	
	
}
