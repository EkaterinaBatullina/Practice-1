package a;

import users.models.User;
import users.repositories.UsersRepository;
import users.repositories.UsersRepositoryJdbcImpl;
import util.DriverManagerDataSource;

import javax.sql.DataSource;

public class Main2 {

    public static void main(String[] args) {
        DataSource dataSource = new DriverManagerDataSource("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/javalab_2024_db", "postgres", "eka_rina16");
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        usersRepository.save(new User(1, "name1","email1", "password1.1"));
        usersRepository.save(new User(2, "name2","email2", "password2"));
        System.out.println(usersRepository.findAll());
        usersRepository.update(new User(1,"name1","email1","password1.2"));
        System.out.println(usersRepository.findAll());
        usersRepository.delete(1);
        System.out.println(usersRepository.findAll());
        System.out.println(usersRepository.findById(2));
    }

}
