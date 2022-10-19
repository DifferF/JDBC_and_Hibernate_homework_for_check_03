package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/*
Создать новую базу данных с помощью MySQLWorkbench.
Создать Maven-проект и настроить его правильно.
Создать файл с настройками hibernate.cfg.xml.
И создать класс Animal(int age, String name, boolean tail) с методами get и set,
как сущность к нашей таблице.
И с помощью hibernate создать новую таблицу с начальным значением.
 */

public class Main {

    public static void main(String[] args) {

        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);

        // Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // Initialize Session Object
        Session session = sessionFactory.openSession();

        Animal anim_1 = new Animal();
        anim_1.setAge(22);
        anim_1.setName("Monisha");
        anim_1.setTail(true);

        Song song1 = new Song();
        song1.setSongName("Broken Angel");
        song1.setArtist("Playing the ukulele");

        session.beginTransaction();
        session.save(anim_1);
        session.save(song1);

        session.getTransaction().commit();
        session.close();

        Session session_01 = sessionFactory.openSession();
        session_01.beginTransaction();
        
        String hib = "SELECT A.name FROM Animal A";
        org.hibernate.query.Query queryii = session_01.createQuery(hib);
        List result = queryii.list();
        System.out.println(result);

        hib = "SELECT S.songName FROM Song S";
        queryii = session_01.createQuery(hib);
        List result_2 = queryii.list();
        System.out.println(result_2);

        session_01.close();
    }
}
