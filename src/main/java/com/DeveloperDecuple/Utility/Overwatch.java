package com.DeveloperDecuple.Utility;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/*
 * Code by Player_Decuple
 * API by OWAPI (v3)
 */

public class Overwatch {

    private final String tag;
    private String JSONBody;

    public Overwatch(String tag) {

        this.tag = tag.replace("#", "-");
        try {
            this.JSONBody = getJSONBody();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getJSONBody() throws Exception {

        GetJSON json = new GetJSON();
        String BASE_URL = "https://owapi.net/api/v3/u/";
        return json.getJsonByUrlForUserMode(BASE_URL + URLEncoder.encode(tag, "UTF-8") + "/stats");

    }

    public String getOverwatchScore(int type) {

        if (type >= 3) return null;

        JsonParser jp = new JsonParser();

        JsonObject body = (JsonObject) jp.parse(JSONBody);
        JsonObject koreanServer_stats = body.getAsJsonObject("kr").getAsJsonObject("stats");

        // COMPETITIVE //
        JsonObject ko_competitive = koreanServer_stats.getAsJsonObject("competitive").getAsJsonObject("overall_stats");

        if (ko_competitive != null) {

            /*
            int ko_cpPrestige = 0;

            try {
                ko_cpPrestige = ko_competitive.get("prestige").getAsInt();
            } catch (UnsupportedOperationException e) {
                // ignore
            }

            int ko_cpLevel = ko_competitive.get("level").getAsInt();
            int ko_level = (ko_cpPrestige * 100) + ko_cpLevel;

            // RANK POINTS //

            int games = ko_competitive.get("games").getAsInt();
            int losses = ko_competitive.get("losses").getAsInt();
            int wins = ko_competitive.get("wins").getAsInt();
            double winRate = ko_competitive.get("win_rate").getAsDouble();
             */

            try {
                String ko_tankTier = ko_competitive.get("tank_tier").getAsString();
                int ko_tankRank = ko_competitive.get("tank_comprank").getAsInt();

                if (ko_tankTier != null) {
                    if (type == 0) return ko_tankTier.toUpperCase() + " " + ko_tankRank;
                } else {
                    return "BRONZE <500점";
                }
            } catch (NullPointerException | UnsupportedOperationException e) {
                // ignore
            }

            try {
                String ko_dealTier = ko_competitive.get("damage_tier").getAsString();
                int ko_dealRank = ko_competitive.get("damage_comprank").getAsInt();

                if (ko_dealTier != null) {
                    if (type == 1) return ko_dealTier.toUpperCase() + " " + ko_dealRank;
                }
            } catch (NullPointerException | UnsupportedOperationException e) {
                // ignore
            }

            try {
                String ko_healTier = ko_competitive.get("support_tier").getAsString();
                int ko_healRank = ko_competitive.get("support_comprank").getAsInt();

                if (ko_healTier != null) {
                    if (type == 2) return ko_healTier.toUpperCase() + " " + ko_healRank;
                }
            } catch (NullPointerException | UnsupportedOperationException e) {
                // ignore
            }

        }

        return null;

    }

}
