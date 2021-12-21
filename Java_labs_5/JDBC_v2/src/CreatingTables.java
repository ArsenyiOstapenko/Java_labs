import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static jdbc.ConnectionData.URL;
import static jdbc.ConnectionData.USER;
import static jdbc.ConnectionData.PASSWORD;

public class CreatingTables {
    private static final String CREATE_TABLE_ACTORS = "CREATE TABLE IF NOT EXISTS Actors (idActors INT NOT NULL AUTO_INCREMENT, ActorsFullName VARCHAR(45) NOT NULL, ActorsBirthday DATE NOT NULL, PRIMARY KEY (idActors))";
    private static final String CREATE_TABLE_PRODUCERS = "CREATE TABLE IF NOT EXISTS Producers (ProducersId INT NOT NULL AUTO_INCREMENT, ProducersFullName VARCHAR(45) NOT NULL, ProducersBirthday DATE NOT NULL, PRIMARY KEY (ProducersId))";
    private static final String CREATE_TABLE_FILMS = "CREATE TABLE IF NOT EXISTS Films (FilmId INT NOT NULL AUTO_INCREMENT,FilmName VARCHAR(45) NOT NULL,ActorName VARCHAR(45) NOT NULL,ReleaseDate DATE NOT NULL,ReleaseCountry VARCHAR(45) NOT NULL,idActors INT NOT NULL, idProducers INT NOT NULL, PRIMARY KEY (FilmId), INDEX idActors_idx (idActors ASC) VISIBLE, INDEX idProducers_idx (idProducers ASC) VISIBLE, CONSTRAINT idActors FOREIGN KEY (idActors) REFERENCES Actors (idActors) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT idProducers FOREIGN KEY (idProducers) REFERENCES Producers (ProducersId) ON DELETE CASCADE ON UPDATE CASCADE)";
    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE_ACTORS);
            statement.executeUpdate(CREATE_TABLE_PRODUCERS);
            statement.executeUpdate(CREATE_TABLE_FILMS);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

