package com.DeveloperDecuple;

import com.DeveloperDecuple.TwipUtility.TwipUtilityEventHandler;
import com.DeveloperDecuple.TwipUtility.TwipUtilitySocketClient;
import com.gikk.twirk.Twirk;
import com.gikk.twirk.TwirkBuilder;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class InuyashaBot {

    public static Twirk twirk;
    private static PrintStream p;

    public static void main(String[] args) throws IOException, InterruptedException {
        twirk = new TwirkBuilder("#inuamsxa21s", "InuyashaBot", "OAUTH TOKEN")
                .setVerboseMode(false).build();
        twirk.addIrcListener(new InuyashaBotMessageListener());
        twirk.connect();

        p = new PrintStream(System.out);
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(@NotNull byte[] b) throws IOException {
            }

            @Override
            public void write(@NotNull byte[] b, int off, int len) throws IOException {
            }

            @Override
            public void flush() throws IOException {
            }

            @Override
            public void close() throws IOException {
            }

            @Override
            public void write(int b) throws IOException {
            }
        }));

        p.println("[INF] Connected successfully to Twitch!");
        new TwipUtilitySocketClient("inuamsxa21s", "rp4aB3boeb");
        TwipUtilityEventHandler.addListener(new TwipListener());

    }

}
