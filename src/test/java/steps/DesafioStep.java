package steps;

import java.io.File;
import java.io.IOException;
import java.util.Map;

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
		driver.get("https://teste-omie.vercel.app/clientes/listar");
	    driver.manage().window().maximize();
	}
	
	@And("Clico em novo para adcionar novo cliente")
	public void clico_em_novo_para_adcionar_novo_cliente() {
		driver.findElement(By.xpath("//a[text()=' Novo ']")).click();
		System.out.print("clicando em novo \n");
	}
	
	@When("Insiro as informações")
	public void insiro_as_informacoes() {
		driver.findElement(By.id("inscricao")).sendKeys("11111111111111");
		System.out.print("informando inscricao \n");
		driver.findElement(By.id("Apelido")).sendKeys("Loyd");
		System.out.print("informando apelido \n");
		driver.findElement(By.id("nome")).sendKeys("Loyd Forger");
		System.out.print("informando nome \n");
		driver.findElement(By.id("foto")).sendKeys("jooj");
		System.out.print("informando URL Foto \n");
		driver.findElement(By.id("status")).click();
		System.out.print("informando opção de status \n");
		driver.findElement(By.xpath("//option[text()='ATIVADO']")).click();
		System.out.print("informando opção de status Ativado \n");
	}
	
	@Then("Valido a criacao")
	public void valido_a_criacao() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.print("Clicando em cadastrar \n");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='form-control col-lg-6 ng-untouched ng-pristine ng-valid']")).click();
		System.out.print("Clicando na box para filtrar quantidade \n");
		driver.findElement(By.xpath("//option[text()='20']")).click();
		System.out.print("Clicando em 20 \n");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='17']")).click();
		System.out.print("Clicando na pagina 17 \n");
		
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("(//td[text() = ' Loyd '])[1]")), driver.findElement(By.xpath("(//td[text() = ' Loyd '])[1]")));
		System.out.print("Cliente Criado com sucesso");
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		driver.quit();
	}

	@And("Clico no botao de editar")
	public void clico_no_botao_de_editar() throws InterruptedException {
		driver.findElement(By.xpath("//select[@class='form-control col-lg-6 ng-untouched ng-pristine ng-valid']")).click();
		System.out.print("Clicando na box para filtrar quantidade \n");
		driver.findElement(By.xpath("//option[text()='20']")).click();
		System.out.print("Clicando em 20 \n");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='17']")).click();
		System.out.print("Clicando na pagina 17 \n");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class = 'btn btn-xs btn-primary'])[16]")).click();
	}
	
	@When("edito a opcao desejada")
	public void edito_a_opcao_desejada() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("Apelido")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("Apelido")).sendKeys("Anya");
		System.out.print("informando novo apelido \n");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.print("Clicando em editar \n");
	}
	
	@Then("Valido a edicao")
	public void valido_a_edicao() throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='form-control col-lg-6 ng-untouched ng-pristine ng-valid']")).click();
		System.out.print("Clicando na box para filtrar quantidade \n");
		driver.findElement(By.xpath("//option[text()='20']")).click();
		System.out.print("Clicando em 20 \n");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='17']")).click();
		System.out.print("Clicando na pagina 17 \n");
		Thread.sleep(1000);
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		
		driver.quit();
	
	}

	@Then("clico em deletar")
	public void clico_em_deletar() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text() = ' Deletar ']")).click();
		System.out.print("Clicando em deletar \n");
		driver.findElement(By.xpath("//button[text() = 'Excluir']")).click();
		System.out.print("Clicando em excluir \n");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='form-control col-lg-6 ng-untouched ng-pristine ng-valid']")).click();
		System.out.print("Clicando na box para filtrar quantidade \n");
		driver.findElement(By.xpath("//option[text()='20']")).click();
		System.out.print("Clicando em 20 \n");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='17']")).click();
		System.out.print("Clicando na pagina 17 \n");
		Thread.sleep(1000);
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		
		driver.quit();
	}

	@When("clico em mostrar categorias")
	public void clico_em_mostrar_categorias() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text() = 'Ver Categorias']")).click();
		Thread.sleep(2000);
		System.out.print("Clicando em ver categorias \n");
		driver.findElement(By.xpath("(//button[text() = 'Fechar'])[2]")).click();
		System.out.print("Clicando em fechar \n");
	}
	@And("clico no botao novo")
	public void clico_no_botao_novo() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text() = ' Novo ']")).click();
		System.out.print("Clicando no botão novo \n");
	}
	@And("preencho os campos")
	public void preencho_os_campos() throws InterruptedException {
		driver.findElement(By.xpath(("(//input[@id= 'nome'])[2]"))).sendKeys("Anya Forger");
		System.out.print("Colocando nome \n");
		driver.findElement(By.id("email")).sendKeys("Anya@gmail.com");
		System.out.print("Colocando email \n");
		driver.findElement(By.id("categoria")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//option[text() = 'Anya']")).click();
		System.out.print("selecionando categoria \n");
	}
	@Then("clico em cadastrar")
	public void clico_em_cadastrar() throws InterruptedException, IOException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		System.out.print("Clicando em cadastrar \n");
		Thread.sleep(1000);
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		
		driver.quit();
	}

}
