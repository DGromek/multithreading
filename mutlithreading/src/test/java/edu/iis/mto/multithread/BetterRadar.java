package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private int volleySize;

    public BetterRadar(PatriotBattery battery, int volleySize) {
        this.battery = battery;
        this.volleySize = volleySize;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < volleySize; i++) {
                battery.launchPatriot(enemyMissile);
            }
        };

        new Thread(launchPatriotTask).start();
    }
}
