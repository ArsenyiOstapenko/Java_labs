import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static jdbc.ConnectionData.*;

public class InsertBatchData {
    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            /*
            //for actors
            statement.addBatch("INSERT INTO Actors (idActors, ActorsFullName, ActorsBirthday) VALUES ('1', 'Марк Уолберг', '2001.01.31')");
            statement.addBatch("INSERT INTO Actors (idActors, ActorsFullName, ActorsBirthday) VALUES ('2', 'Джейсон Стэтхем', '1996.03.19')");
            statement.addBatch("INSERT INTO Actors (idActors, ActorsFullName, ActorsBirthday) VALUES ('3', 'Марго Робби', '1982.10.08')");
            statement.addBatch("INSERT INTO Actors (idActors, ActorsFullName, ActorsBirthday) VALUES ('4', 'Мэтью Макконахи', '1979-06-28')");
            statement.addBatch("INSERT INTO Actors (idActors, ActorsFullName, ActorsBirthday) VALUES ('5', 'Том Харди', '1984.09.30')");
            statement.addBatch("INSERT INTO Actors (idActors, ActorsFullName, ActorsBirthday) VALUES ('6', 'Том Холланд', '1999.12.22')");

            //for producers
            statement.addBatch("INSERT INTO Producers (ProducersId, ProducersFullName, ProducersBirthday) VALUES ('1', 'Квентин Тарантино', ' 1974.04.19')");
            statement.addBatch("INSERT INTO Producers (ProducersId, ProducersFullName, ProducersBirthday) VALUES ('2', 'Гай Ричи', ' 1969.08.30')");
            statement.addBatch("INSERT INTO Producers (ProducersId, ProducersFullName, ProducersBirthday) VALUES ('3', 'Кристофер Нолан', ' 1982.11.01')");
            statement.addBatch("INSERT INTO Producers (ProducersId, ProducersFullName, ProducersBirthday) VALUES ('4', 'Вуди Аллен', ' 1979.12.06')");
            statement.addBatch("INSERT INTO Producers (ProducersId, ProducersFullName, ProducersBirthday) VALUES ('5', 'Клинт Иствуд', ' 1962.06.28'");

            //for films
            statement.addBatch("INSERT INTO FILMS (FilmId, FilmName, ActorName, ReleaseDate, ReleaseCountry, idActors, idProducers ) VALUES ('1', 'Однажды в Голливуде', 'Марго Робби', '2019.05.19', 'США', '3', '1' )");
             */


            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}



