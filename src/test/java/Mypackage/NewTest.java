package Mypackage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;

	@Test(priority = 0)
	public void f() throws InterruptedException {

		WebElement search_result = driver
				.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));

		search_result.click();

		Thread.sleep(1000);

		search_result.sendKeys("Latest from MI");

		Thread.sleep(1000);

		search_result.click();

		Thread.sleep(1000);

	}

	@Test(priority = 1)
	public void selectfromdropdown() throws InterruptedException {

		Thread.sleep(1000);

		WebElement clickfirstElement = driver.findElement(By.xpath("(//a[@class='oleBil'])[1]"));
		clickfirstElement.click();

		Thread.sleep(1000);

	}

	@Test(priority = 2)
	public void selectpriceSlider() throws InterruptedException {

		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='PYKUdo'] )[1]")));
		WebElement priceslider = driver.findElement(By.xpath("(//div[@class='PYKUdo'] )[1]"));

		int xwidth = priceslider.getSize().width;

		System.out.println("The dimension of priceslider width = " + xwidth);

		Actions action = new Actions(driver);
		action.clickAndHold(priceslider);
		action.dragAndDropBy(priceslider, xwidth * 3, 00);
		action.build().perform();

		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void firstmobilefromthelistisDisplayed() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//div[@class='KzDlHZ'])[1]"))));

		WebElement first = driver.findElement(By.xpath("(//div[@class='KzDlHZ'])[1]"));

		System.out.println("The first element is present or not = " + first.isDisplayed());

		first.click();

	}

	@Test(priority = 4)
	public void verifyingtheproductprice() {

		String mainWindowHandle = driver.getWindowHandle();

		Set<String> windownHandles = driver.getWindowHandles();

		for (String handle : windownHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}

		}

	}

	@Test(priority = 5)
	public void checkingthemobileprice() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Nx9bqj CxhGGd']")));

		WebElement priceTag = driver.findElement(By.xpath("//div[@class='Nx9bqj CxhGGd']"));
		String pricevalue = priceTag.getText();

		String strpricvalue = pricevalue.replaceAll("^[0-9]", " ");

		String str1 = strpricvalue.replaceAll(" +", " ");

		System.out.println("The price of the Mobile phone " + str1);
		int priceint = Integer.parseInt(str1);

		if (0 <= priceint) {
			System.out.println("Yes, Checked the value is greater than 0");
		}

		else {
			System.out.println("No, Checked the value is less than 0");
		}
	}

	@Test(priority = 6)
	public void checkingtheThumbnailDisplayed() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@loading='eager'])[1]")));

		WebElement thumbnail = driver.findElement(By.xpath("(//img[@loading='eager'])[1]"));

		if (thumbnail.isDisplayed()) {
			System.out.println("The thumbnail is present");

		} else {
			System.out.println("The thumbnail is absent");
		}

	}

	@Test(priority = 7)
	public void sendDeliverycode() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Delivery Pincode']")));

		WebElement deliveryCode = driver.findElement(By.xpath("//input[@placeholder='Enter Delivery Pincode']"));

		Actions action = new Actions(driver);
		action.sendKeys(deliveryCode, "600078");

		Thread.sleep(2000);
	}

	@BeforeSuite
	public void beforesuite() {
		System.out.println("------Before suite-------");

		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("-----------After sutie----------");
	}

}
