package bdconnection;


import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * instalar e configurar servidor mysql 8.0 corretamente (nome = root, senha = root, schema name = carddex)
 * Instalar o Connector/J 8.0
 * Encontrar a pasta do Connector/J (C:\Program Files (x86)\MySQL\Connector J 8.0)
 * botão direito no projeto no netbeans -> propriedades -> bibliotecas -> adicionar JAR
 * adicionar o Connector/J
 * adicionar cartas ao BD (só copiar os códigos e executar UMA VEZ:
 * insert into lista (nome, tipo, limite) values ("Lista 1", "deck", 60);
 * insert into lista (nome, tipo) values ("Lista 2", "pasta");
 * insert into carta (nome, tipo, colecao, energia, ps, descricao, recuo, fraqueza) values ("Reshiram e Charizard GX", "Pokemon", "20/214", "Fogo", 270, "Ultraje - 30\n Golpe de Chamas - 230\n", 3, "Agua");
 * insert into carta (nome, tipo, colecao, energia, ps, descricao, recuo, fraqueza) values ("Volcanion", "Pokemon", "25/214", "Fogo", 120, "Atear Fogo\n Raio de Calor Intenso - 50+\n", 2, "Agua");
 * insert into carta(nome, tipo, colecao, descricao) values ("Desbravamento da Green", "Apoiador", "175/214", "Você só pode jogar esta carta se não tiver Pokémon com Habilidades em jogo.\n\nProcure por até 2 cartas de Treinador no seu baralho, revele-as e coloque-as na sua mão. Em seguida, embaralhe seu baralho");
 * insert into carta(nome, tipo, colecao) values ("Energia de Fogo", "Energia", "2019/1");
 * insert into carta(nome, tipo, colecao, descricao) values ("Mistura de Ervas", "Item", "184/214", "Remova 1 condição especial do seu pokémon ativo");
 * insert into carta(nome, tipo, colecao, descricao) values ("Santuário da Punição", "Estadio", "143/168", "Entre as vezes de jogar, coloque 1 contador de dano em cada pokémon GX e EX");
 */
public class BDConnection {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // cria os objetos
        Connection conn1;
        Statement stmt1;
        ResultSet rs1;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // cria a conexao com o bd
            conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/carddex?useTimezone=true&serverTimezone=UTC", "root", "root");
            //cria o objeto de query
            stmt1 = conn1.createStatement();

            //executa a query e passa o resultado pra rs1
            rs1 = stmt1.executeQuery("SELECT * from carta where tipo=\"pokemon\"");

                //para cada resultado em rs1
                while(rs1.next()){
                    //pegar o valor do tipo int da coluna id
                    System.out.println("id: "+rs1.getInt("id"));
                    //pegar o valor do tipo string da coluna nome
                    System.out.println("nome: "+rs1.getString("nome"));
                    //....
                    System.out.println("tipo: "+rs1.getString("tipo"));
                    System.out.println("colecao: "+rs1.getString("colecao"));
                    System.out.println("energia: "+rs1.getString("energia"));
                    System.out.println("ps: "+rs1.getInt("ps"));
                    System.out.println("descricao: "+rs1.getString("descricao"));
                    System.out.println("recuo: "+rs1.getInt("recuo"));
                    System.out.println("fraqueza: "+rs1.getString("fraqueza"));
                    System.out.println("\n\n");
                }
            
            //fecha o objeto guardando os resultados
            rs1.close();
            
            //fecha a conexao com o BD (IMPORTANTE!)
            conn1.close();


        } catch (SQLException E) {
            System.out.println("Message: " + E.getMessage());
        }
    }

}
