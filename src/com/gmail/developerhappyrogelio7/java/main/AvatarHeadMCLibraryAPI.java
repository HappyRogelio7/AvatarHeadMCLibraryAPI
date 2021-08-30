package com.gmail.developerhappyrogelio7.java.main;


import net.md_5.bungee.api.ChatColor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public final class AvatarHeadMCLibraryAPI {

    private AvatarHeadMCLibraryAPI() {
        throw new AssertionError();
    }

    /*
    API / Library Information
    */

    public void OnEnable (){

        System.out.println("-------------------------------");
        System.out.println(" AvatarHeadMCLibrary V.1.0.1");
        System.out.println(" ");
        System.out.println(" API / Library to obtain the head / avatar of the Minecraft player.");
        System.out.println(" It is designed for plugins, but you can see the open source to use it with another system.");
        System.out.println(" ");
        System.out.println(" Author: HappyRogelio7");
        System.out.println(" GitHub: https://github.com/HappyRogelio7");
        System.out.println(" GitHub API/LIBRARY: https://github.com/HappyRogelio7/AvatarHeadMCLibraryAPI");
        System.out.println(" License: https://github.com/HappyRogelio7/AvatarHeadMCLibraryAPI/LICENSE");
        System.out.println(" API: https://cravatar.eu/");
        System.out.println("-------------------------------");

    }

    /*
    For this liberia to work, it requires obtaining the data from the website of:
    https://cravatar.eu/
    */

    private static String fixInvalidLength(String hex) {
        if (hex.length() < 6) {
            return new String(new char[6 - hex.length()]).replace("\0", "0") + hex;
        }
        return hex;
    }

    public static ArrayList<String> getFace(String nickname, int size){

        BufferedImage image = null;
        try {

            URL url = new URL("https://cravatar.eu/helmavatar/{nickname}/{size}"
                    .replace("{nickname}", nickname)
                    .replace("{size}", String.valueOf(size)));

            image = ImageIO.read(url);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image == null) return new ArrayList<>();

        ArrayList<String> lines = new ArrayList<>();
        for (int y = 0; y < image.getHeight(); y++) {

            StringBuilder line = new StringBuilder();

            for (int x = 0; x < image.getWidth(); x++) {

                /*
                This is a check of the API in Console/Terminal,
                It is only Activated in the TESTING Version
                of the AvatarHeadMCLibrary API.
                */

                //System.out.println("x: " + x + ",  y: " + y);

                line.append(ChatColor.of("#" + fixInvalidLength(Integer.toHexString(image.getRGB(x, y) & 0x00FFFFFF)))).append("\u2588");
            }
            lines.add(line.toString());
        }

        return lines;

    }

    /*
    The following is currently in BETA!
    */

    public static ArrayList<String> getHead(String nickname, int size){

        /*
        Notes to the Console/Terminal that this option is in BETA!
        */

        System.out.println("Currently 'getHead' is in BETA!");
        System.out.println("More information in: https:/github.com/HappyRogelio7/AvatarHeadMCLibraryAPI");

        BufferedImage image = null;
        try {

            URL url = new URL("https://cravatar.eu/head/{nickname}/{size}"
                    .replace("{nickname}", nickname)
                    .replace("{size}", String.valueOf(size)));

            image = ImageIO.read(url);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image == null) return new ArrayList<>();

        ArrayList<String> lines = new ArrayList<>();
        for (int y = 0; y < image.getHeight(); y++) {

            StringBuilder line = new StringBuilder();

            for (int x = 0; x < image.getWidth(); x++) {

                /*
                This is a check of the API in Console/Terminal,
                It is only Activated in the TESTING Version
                of the AvatarHeadMCLibrary API.
                */

                System.out.println("x: " + x + ",  y: " + y);

                line.append(ChatColor.of("#" + fixInvalidLength(Integer.toHexString(image.getRGB(x, y) & 0x00FFFFFF)))).append("\u2588");
            }
            lines.add(line.toString());
        }

        return lines;

    }



}

