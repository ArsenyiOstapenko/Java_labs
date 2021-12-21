import java.sql.*;

import static jdbc.ConnectionData.*;

public class ResultSetClass {
    private static final String SELECT_QUERY1 = "SELECT Distinct FilmName from Films where ReleaseDate >= ?";
    private static final String SELECT_QUERY2 = "SELECT ActorName,idActors from Films where FilmName = ? ";
    private static final String SELECT_QUERY3 = "SELECT ActorName,idActors, COUNT(*) FROM films GROUP BY ActorName HAVING COUNT(*) > ?";
    private static final String SELECT_QUERY4 = "SELECT Distinct actors.ActorsFullName, producers.ProducersBirthday, actors.idActors FROM actors, producers WHERE actors.ActorsBirthday = producers.ProducersBirthday and  producers.ProducersBirthday = ?";
    private static final String DELETE_QUERY1 = "Delete from Films WHERE ReleaseDate > ?";

    public static void main(String[] args) throws SQLException {
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_QUERY1)) {
            preparedStatement.setString(1, "2019.12.31");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Фильмы, вышедшие на экран в текущем или прошлом году: ");
            while (resultSet.next()) {
                String FilmName = resultSet.getString("FilmName");
                System.out.println(FilmName);
            }


        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY2)) {
            preparedStatement.setString(1, "Однажды в Голливуде");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Вывести информацию об актерах, снимавшихся в заданном фильме: ");
            while (resultSet.next()) {
                int idActors = resultSet.getInt("idActors");
                String ActorName = resultSet.getString("ActorName");
                System.out.println(ActorName + " " + idActors);


            }

        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY3)) {
            preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Вывести информацию об актерах, снимавшихся как минимум в N фильмах: ");
            while (resultSet.next()) {
                int idActors = resultSet.getInt("idActors");
                String ActorName = resultSet.getString("ActorName");
                System.out.println(ActorName + " " + idActors);

            }
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY4)) {
            preparedStatement.setString(1, "2001-01-31");
            // preparedStatement.setString(2, "1979-06-28");

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Вывести информацию об актерах, которые были режиссерами хотя бы одного из фильмов: ");
            while (resultSet.next()) {
                int idActors = resultSet.getInt("idActors");
                String ActorsFullName = resultSet.getString("ActorsFullName");
                String ProducersBirthday = resultSet.getString("ProducersBirthDay");
                System.out.println(ActorsFullName + " " + idActors + " " + ProducersBirthday);
            }
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY1)) {
            statement.setString(1,"2021.09.14" );
            System.out.println("Удалить все фильмы, дата выхода которых была более заданной даты: ");
                int result = statement.executeUpdate();
                System.out.println("Количество удаленных записей :: " + result);
            }
        }
    }







