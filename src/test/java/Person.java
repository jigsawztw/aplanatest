import java.util.*;

/**
 * @author  Osipov Ivan, student
 */
public class Person {
    private String firstName,lastName, middleName; //Имя, фамилия, отчество
    /**
     * @return число от 1 до 10
     */
    public static int randomize(){
        Random rand = new Random();
        return rand.nextInt(11) +1;
    }


    /**
     * Конструктор с параметрами
     */
    public Person(String firstName,String lastName,String middleName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;

    }

    /**
     * @return экземпляр Person в зависимости от рандомного значения которое генерирует метод randomize()
     */
    public static Person getRandomPerson() {

        switch (randomize()) {
            case 1:
                return  new Person("Сергей", "Петров", "Владимирович");
            case 2:
                return  new Person("Александр", "Смирнов", "Евгеньевич");
            case 3:
                return  new Person("Мария", "Лунина", "Геннадьевна");
            case 4:
                return  new Person("Владислав", "Афанасьев", "Викторович");
            case 5:
                return  new Person("Максим", "Червяков", "Олегович");
            case 6:
                return  new Person("Антон", "Страшнов", "Абрамович");
            case 7:
                return  new Person("Артем", "Куранов", "Владимирович");
            case 8:
                return  new Person("Михаил", "Бычинин", "Игоревич");
            case 9:
                return  new Person("Юлия", "Тарелкина", "Семеновна");
            case 10:
                return  new Person("Валентин", "Пирогов", "Андреевич");
            default: return new Person("Мавродий", "Мышкин", "Валентинович");
        }
    }

    /**
     * @return Имя
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return Фамилия
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return Отчество
     */
    public String getMiddleName() {
        return middleName;
    }
}
