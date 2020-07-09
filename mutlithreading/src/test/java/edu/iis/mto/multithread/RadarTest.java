package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    public static final int UNRELEVANT_VOLLEY_SIZE = 30;

    @RepeatedTest(30)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock, UNRELEVANT_VOLLEY_SIZE);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, timeout(100).times(UNRELEVANT_VOLLEY_SIZE)).launchPatriot(enemyMissle);
    }

}
