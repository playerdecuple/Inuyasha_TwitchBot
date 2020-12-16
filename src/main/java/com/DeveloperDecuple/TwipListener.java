package com.DeveloperDecuple;

import com.DeveloperDecuple.TwipUtility.TwipUtilityEventListener;
import com.gikk.twirk.Twirk;
import org.jetbrains.annotations.NotNull;

public class TwipListener implements TwipUtilityEventListener {
    @Override
    public void onDonateReceived(@NotNull String streamer, int amount, @NotNull String comment, @NotNull String nickname) {
        Twirk t =InuyashaBot.twirk;
        t.channelMessage("워후! " + nickname + "님 " + amount + "원 감사합니다!");
        t.channelMessage("내용: \"" + comment + "\"");
    }
}
