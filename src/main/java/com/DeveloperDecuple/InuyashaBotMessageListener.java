package com.DeveloperDecuple;

import com.DeveloperDecuple.Utility.EasyEqual;
import com.DeveloperDecuple.Utility.Overwatch;
import com.gikk.twirk.Twirk;
import com.gikk.twirk.events.TwirkListener;
import com.gikk.twirk.types.twitchMessage.TwitchMessage;
import com.gikk.twirk.types.users.TwitchUser;

import java.util.Timer;
import java.util.TimerTask;

public class InuyashaBotMessageListener implements TwirkListener {

    private final EasyEqual e = new EasyEqual();
    private final Twirk t = InuyashaBot.twirk;

    public InuyashaBotMessageListener() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                t.channelMessage("이누야샤 점수봇! [by 데큐플]");
            }
        }, 1, 60 * 30 * 1000);
    }

    @Override
    public void onPrivMsg(TwitchUser user, TwitchMessage message) {

        String msg = message.getContent();
        Overwatch overwatch = new Overwatch("트위치이누야샤#3127");

        if (e.eq(msg, "!탱커", "!탱")) {
            t.channelMessage("TANKER | " + overwatch.getOverwatchScore(0));
        }

        if (e.eq(msg, "!딜러", "!딜")) {
            t.channelMessage("DEALER | " + overwatch.getOverwatchScore(1));
        }

        if (e.eq(msg, "!힐러", "!힐")) {
            t.channelMessage("HEALER | " + overwatch.getOverwatchScore(2));
        }

    }

}
