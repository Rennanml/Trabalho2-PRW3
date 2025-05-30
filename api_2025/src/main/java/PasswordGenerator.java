import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "1234";
        String hashedPassword = encoder.encode(rawPassword);
        System.out.println("Senha '123456' hashed: " + hashedPassword);

        // Agora, compare com o hash do seu banco de dados
        String hashDoBanco = "$2y$10$j/n7DqizlR1zuQ2JSARfK.av6A.83c8hOnNuEk3R.MsdcjOM6ImFG"; // Seu hash do INSERT
        boolean matches = encoder.matches(rawPassword, hashDoBanco);
        System.out.println("A senha '123456' corresponde ao hash do banco? " + matches);

        // Se não corresponder, gere uma nova senha e insira no banco
        String novaSenhaParaBanco = encoder.encode("senha_nova_e_correta");
        System.out.println("Nova senha hashed para inserir no banco: " + novaSenhaParaBanco);
    }
}