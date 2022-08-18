package ru.msaggik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.msaggik.hibernate.model.Item;
import ru.msaggik.hibernate.model.Person;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        // подключение файла конфигурации hibernate.properties и класса Person
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        // создание сессии из configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // сессия
        Session session = sessionFactory.getCurrentSession();

        try {
            // начало транзакции
            session.beginTransaction();

//            // вывод товаров пользователя:
//            // 1) вывод пользователя с id=3
//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
//            // 2) вывод товаров данного пользователя
//            List<Item> items = person.getItems();
//            System.out.println(items);

//            // определение владельца товара:
//            // 1) вывод товара с id=5
//            Item item = session.get(Item.class, 5);
//            System.out.println(item);
//            // 2) вывод владельца данного товара
//            Person person = item.getOwner();
//            System.out.println(person);

//            // добавление товаров:
//            // 1) вывод пользователя с id=2 владеющего создаваемым товаром
//            Person person = session.get(Person.class, 2);
//            // 2.1) создание нового товара с владельцем
//            Item newItem = new Item("Hoover", person);
//            // добавление пользователю нового товара (приведение в порядок кэша java)
//            person.getItems().add(newItem);
//            // 3.1) запись в БД нового товара
//            session.save(newItem);
//            // 2.2) создание нового товара без владельца
//            Item newItem1 = new Item("Ipad", null);
//            // 3.2) запись в БД нового товара
//            session.save(newItem1);

//            // создание нового пользователя с одним заказом:
//            // 1) создание нового пользователя:
//            Person person = new Person("Sophy", 28);
//            // 2) создание нового товара с владельцем
//            Item newItem = new Item("Printer", person);
//            // добавление новому пользователю нового товара (приведение в порядок кэша java)
//            person.setItems(new ArrayList<>(Collections.singleton(newItem)));
//            // 3) сохранение изменений в БД
//            session.save(person);
//            session.save(newItem);

//            // удаление всех товаров пользователя с id=2:
//            // 1) вывод пользователя с id=2
//            Person person = session.get(Person.class, 2);
//            // 2) получение товаров пользователя с id=2
//            List<Item> items = person.getItems();
//            // 3) обезличенивание товаров в БД пользователя с id=2
//            for(Item item: items)
//                session.remove(item);
//            // очистка списка Items() (приведение в порядок кэша java)
//            person.getItems().clear();

//            // удаление данных пользователя с id=3 из БД
//            // 1) вывод пользователя с id=3
//            Person person = session.get(Person.class, 3);
//            // 2) удаление данных пользователя с id=3 из БД
//            session.remove(person);
//            // 3) удаление данных пользователя с id=3 (приведение в порядок кэша java)
//            person.getItems().forEach(i -> i.setOwner(null));

//            // изменение владельца у существующего товара:
//            // 1) вывод из БД информации пользователя с id=4
//            Person person = session.get(Person.class, 4);
//            // 2.1) получение из БД информации безхозного товара с id=8
//            Item item = session.get(Item.class, 8);
//            // 2.2) получение из БД информации товара с id=8 с другим владельцем
//            Item item1 = session.get(Item.class, 1);
//            // 3) назначение товарам нового владельца с id=4 в БД
//            item.setOwner(person);
//            item1.setOwner(person);
//            // удаление товаров у старова владельца (приведение в порядок кэша java)
//            item1.getOwner().getItems().remove(item1);
//            // добавление товаров новому владельца (приведение в порядок кэша java)
//            person.getItems().add(item);
//            person.getItems().add(item1);

            // закрытие транзакции
            session.getTransaction().commit();
        } finally {
            // закрытие сессии
            sessionFactory.close();
        }
    }
}