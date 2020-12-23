package hw1.games;

public class Robot implements Advancedable {
    private StringBuilder name;
    private int maxLength;
    private int maxHeight;
    private int length;
    private int height;
    private boolean flagOvercomeHurdle; //Флаг преодоления препятствия

    public Robot (StringBuilder name, int maxLength, int maxHeight){
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
        this.flagOvercomeHurdle = true;
    }

    @Override
    public void overcome(RunningTrack runningTrack, Wall wall) {
        if(!flagOvercomeHurdle){ //Если неполучилось, выходим
            System.out.println(name + " не прошел предыдущее препятствие");
            return;
        }
        this.length = runningTrack.getLength();
        this.height = wall.getHeigth();
        run();
        jump();
    }

    @Override
    public void jump() {
        if(height < maxHeight) {
            System.out.println(name + " перепрыгнул");
        } else {
            flagOvercomeHurdle = false;
            System.out.println(name + " НЕ перепрыгнул(");
        }
    }

    @Override
    public void run() {
        if (length < maxLength) {
            System.out.println(name + " пробежал");
        } else {
            flagOvercomeHurdle = false;
            System.out.println(name + " НЕ пробежал(");
        }
    }

}
