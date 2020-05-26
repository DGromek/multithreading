package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    @RepeatedTest(20)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, timeout(100).times(10)).launchPatriot(enemyMissle);
    }


    @RepeatedTest(15)
    public void launchPatriotOnceWhenNoticesAScudMissleXTimesUsingBetterRadar() {
        int howManyMissiles = 100;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle, howManyMissiles);
        verify(batteryMock, timeout(10*howManyMissiles).times(howManyMissiles)).launchPatriot(enemyMissle);

    }

}
