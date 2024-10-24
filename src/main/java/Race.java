import java.util.ArrayList;

public class Race {
    short bestDistance;  //за 24 часа можно проехать не больше 6000 км
    ArrayList<String> leadersArray = new ArrayList<>();


    public void UpdateLeader(String carName, short carSpeed) {
        short carDistance = (short) (carSpeed * 24);
        if (carDistance >= this.bestDistance) {
            if (carDistance > this.bestDistance) {
                this.bestDistance = carDistance;
                if (!leadersArray.isEmpty()) {
                    leadersArray.clear();
                }
            }
            leadersArray.add(carName);
        }
    }

}
