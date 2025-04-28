import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirPessoas {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/exercicio_jdbc";
        String user = "root";
        String password = "0987";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conectado com sucesso!");

            String sql = "INSERT INTO pessoas (id, nome, rg) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Primeira pessoa
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Pedro Silva");
            preparedStatement.setString(3, "1234567");
            preparedStatement.executeUpdate();

            // Segunda pessoa
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Maria Souza");
            preparedStatement.setString(3, "7654321");
            preparedStatement.executeUpdate();

            // Terceira pessoa
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "Carlos Pereira");
            preparedStatement.setString(3, "3456789");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}