
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Race f1 = new Race();
        ArrayList<Car> StartingProtocol = new ArrayList<>();

        //Добавим машины в стартовый протокол. Будем считать, что в гонке могут участвовать только три машины
        for (byte i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String carName = scanner.next();

            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");
                short carSpeed = (short) scanner.nextInt();
                if (carSpeed > 0 && carSpeed <=250){
                    Car car = new Car(carName, carSpeed);
                    StartingProtocol.add(car);
                    break;
                } else {
                    System.out.println("Скорость некорретная! Скорость машины должна быть от 0 до 250 км/час");
                }
            }
        }

        //Проводим гонку
        for (Car car : StartingProtocol) {
            f1.UpdateLeader(car.name, car.speed);
        }

        //Выводим результаты гонки
        String winerString;
        if (f1.leadersArray.size()==1) {
            winerString = "Самая быстрая машина в гонке: " + f1.leadersArray.get(0);
        } else {
            winerString = "В гонке несколько самых быстрых машин: ";
            for (byte i = 0; i < f1.leadersArray.size(); i++) {
                winerString = winerString + (i == 0 ? "" : ", ") + f1.leadersArray.get(i);
            }
        }
        System.out.println(winerString);
    }
}