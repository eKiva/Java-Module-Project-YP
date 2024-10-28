import java.util.ArrayList;

public class Race {
    int bestDistance;
    //Несколько машин могут проехать одинаковую дистанцию гонки, имея одинаковую скорость
    //Таким образом, необходимо хранить не одного промежуточного лидера, а список лидеров
    ArrayList<String> leadersArray = new ArrayList<>();


    public void updateLeader(String carName, int carSpeed) {
        int carDistance = carSpeed * 24;

        if (carDistance >= this.bestDistance) {   //Это претендент на лидерство: показал лучшую дистанцию или дистанцию, равную текущей лучшей
            //Если претендент стал единоличным лидером, то запомним новую лучшую дистанцию и очистим сисок лидеров
            if (carDistance > this.bestDistance) {
                this.bestDistance = carDistance;
                if (!leadersArray.isEmpty()) {
                    leadersArray.clear();
                }
            }
            //Добавим название машины в список лидеров
            leadersArray.add(carName);
        }
    }

}
