package com.iress.toyrobot.runner;

import com.iress.toyrobot.command.CommandMapper;
import com.iress.toyrobot.model.TableTop;
import com.iress.toyrobot.model.ToyRobot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@Component
public class ToyRobotRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws FileNotFoundException {
        log.info("Greatings! Will now be reading instructions from file");

        String filePath = args[0];

        try {
            TableTop tableTop = new TableTop(5, 5);
            ToyRobot toyRobot = new ToyRobot(tableTop);

            Stream<String> userInput = getUserInput(filePath);

            issueCommandsToRobot(toyRobot, userInput);
        } catch (IOException e) {
            log.warn("Error occurred whilst reading input: " + e.getMessage());
            throw new FileNotFoundException("Error occurred whilst reading input");
        }
    }

    private Stream<String> getUserInput(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath));
    }

    private void issueCommandsToRobot(ToyRobot toyRobot, Stream<String> userInput) {
        userInput.map(CommandMapper::mapUserInputToCommand)
                .filter(Objects::nonNull)
                .forEach(toyRobot::receiveCommand);
    }
}
