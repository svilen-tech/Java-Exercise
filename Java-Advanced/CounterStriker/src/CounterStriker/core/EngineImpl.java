package CounterStriker.core;

import CounterStriker.common.Command;
import CounterStriker.models.guns.Gun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
         this.controller = new ControllerImpl(); //TODO implement first
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }

            } catch (IOException | IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s");

        Command command = Command.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        String result = null;

        switch (command) {
            case AddPlayer:
                result = this.addPlayer(data);
                break;
            case Exit:
                result = Command.Exit.name();
                break;
            case StartGame:
                result = this.start();
                break;
            case Report:
                result = this.report();
                break;
            case AddGun:
                result = this.addGun(data);
                break;
        }

        return result;
    }

    private String addGun(String[] data) {
        String type = data[0];
        String name = data[1];
        int bullets = Integer.parseInt(data[2]);
      return  controller.addGun(type, name, bullets);

    }

    private String report() {
        return this.controller.report();

    }

    private String addPlayer(String[] data) {
        String type= data[0];
        String username= data[1];
        int health= Integer.parseInt(data[2]);
        int armor = Integer.parseInt(data[3]);
        String gunName = data[4];

        return controller.addPlayer(type, username, health, armor, gunName);
    }

    private String start() {
        return controller.startGame();

    }
}
