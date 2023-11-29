import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Conta {
	
	int saldo;
	int saque;
	boolean cliente_especial;
	
	/**
	 * @author Carol
	 * @param arg1 Este é o primeiro parâmetro
	 * @throws Throwable
	 */
	
	@Given("^Um cliente especial com saldo atual de -(\\d+) reais$") 
	public void um_cliente_especial_com_saldo_atual_de_reais(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete 
		/**
		 * Se for cliente especial, o parâmetro saldo receberá o que está no arquivo .feature, imprimirá o resultado e 
		 * chamará o próximo método. 
		 * Se for um cliente normal, irá para o método check_more_outcomes()
		 */
		if(cliente_especial = true) { 
			saldo = arg1;
			System.out.print(arg1);
			for_soicitado_um_saque_no_valor_de_reais(arg1);
		}else{
			check_more_outcomes();
		}
	    throw new PendingException();
	}

	@When("^for soicitado um saque no valor de (\\d+) reais$") 
	public void for_soicitado_um_saque_no_valor_de_reais(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		/**
		 * Se o cliente for especial, ele conseguirá realizar o saque.
		 * Se for cliente normal, irá para o método check_more_outcomes()
		 */
		
		if(cliente_especial = true) {
			saque = arg1;
			deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para(arg1);
		}else {
			check_more_outcomes();
		}
	    throw new PendingException();
	}

	@Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+)$") 
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		/**
		 * Se for cliente especial, o saque será realizado e terá seu saldo diminuído
		 * Caso seja cliente normal, não realizará o saque e irá para o método check_more_outcomes()
		 */
		if(cliente_especial = true) {
			saldo = arg1;
			saldo =- saque;
			System.out.println("Saque efetuado");
			System.out.println("Saldo atual: " + saldo);
		}else {
			check_more_outcomes();
			}
		
	    throw new PendingException();
	}

	@Then("^check more outcomes$") 
	public void check_more_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(cliente_especial = false) {
			if(saldo > 0) {
				System.out.print("Pode realizar o saque");
			}else {
				System.out.print("Saldo Insulficiente");
			}
		}
	    throw new PendingException();
	}
}
