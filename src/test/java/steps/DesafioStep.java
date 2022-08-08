package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DesafioStep{
	
	private WebDriver driver;
	
	@Given("Acesso ao link de teste")
	public void acesso_ao_link_de_teste() {
		System.setProperty("webdriver.chrome.driver", "E:/Eclipse/testeomie/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	    driver.manage().window().maximize();
	}
	
	@And("Clico em sign in")
	public void clico_em_sign_in() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title = 'Log in to your customer account']")).click();
		System.out.print("clicando em sign in \n");
		Thread.sleep(2000);
	}
	
	@When("insiro um email valido")
	public void insiro_um_email_valido() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id = 'email_create']")).sendKeys("ale34341@gmail.com");
		System.out.print("inserindo um email valido \n");
		driver.findElement(By.xpath("//button[@id = 'SubmitCreate']")).click();
		System.out.print("clicando em create an account \n");
	}
	
	@And("preencho as informacoes")
	public void preencho_as_informacoes() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("id_gender1")).click();
		System.out.print("Clicando no genero \n");
		driver.findElement(By.id("customer_firstname")).sendKeys("Robert");
		System.out.print("Inserindo nome \n");
		driver.findElement(By.id("customer_lastname")).sendKeys("Luise");
		System.out.print("Inserindo sobrenome \n");
		driver.findElement(By.id("passwd")).sendKeys("laranja123");
		System.out.print("Inserindo senha \n");
		driver.findElement(By.id("address1")).sendKeys("Rua Teste 333");
		System.out.print("Inserindo endereço \n");
		driver.findElement(By.id("city")).sendKeys("Teste");
		System.out.print("Inserindo cidade \n");
		driver.findElement(By.id("id_state")).click();
		driver.findElement(By.xpath("//option[text() = 'Alabama']")).click();
		System.out.print("Escolhendo estado \n");
		driver.findElement(By.id("postcode")).sendKeys("40028");
		System.out.print("Inserindo código postal \n");
		driver.findElement(By.id("phone_mobile")).sendKeys("40028922");
		System.out.print("Inserindo celular \n");
		driver.findElement(By.id("submitAccount")).click();
		System.out.print("Clicando em register \n");
	}
	
	@Then("usuario criado com sucesso")
	public void usuario_criado_com_sucesso() throws InterruptedException, IOException {
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//span[text() = 'Robert Luise']")), driver.findElement(By.xpath("//span[text() = 'Robert Luise']")));
		System.out.print("Usuario Criado com sucesso");
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		driver.quit();
	}
	
	@When("insiro as informacoes de login")
	public void insiro_as_informacoes_de_login() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("ale34341@gmail.com");
		System.out.print("inserindo email \n");
		driver.findElement(By.id("passwd")).sendKeys("laranja123");
		System.out.print("informando senha \n");
		driver.findElement(By.id("SubmitLogin")).click();
		System.out.print("clicando em Sign in \n");
	}
	
	@Then("login realizado com sucesso")
	public void login_realizado_com_sucesso() throws InterruptedException, IOException {
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//span[text() = 'Robert Luise']")), driver.findElement(By.xpath("//span[text() = 'Robert Luise']")));
		System.out.print("Usuario Criado com sucesso");
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		driver.quit();
	}
}
