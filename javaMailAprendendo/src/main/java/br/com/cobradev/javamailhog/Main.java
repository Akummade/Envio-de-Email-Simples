package br.com.cobradev.javamailhog;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        EmailService emailService = new EmailService();
        emailService.enviar(
            "Ola , segue sua prestação de contas :",
                "XXX despesas pendentes. Evite o bloqueio do seu cartão. ",
                "f05037967@gmail.com"
        );
    }
}
