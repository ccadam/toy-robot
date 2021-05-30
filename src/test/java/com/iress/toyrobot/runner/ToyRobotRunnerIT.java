package com.iress.toyrobot.runner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(OutputCaptureExtension.class)
public class ToyRobotRunnerIT {

    private ToyRobotRunner toyRobotRunner;

    @BeforeEach
    public void setUp() {
        toyRobotRunner = new ToyRobotRunner();
    }

    @Test
    void testRun_whenRunWithExampleA_shouldReturnExpectedResult(CapturedOutput capturedOutput) throws FileNotFoundException {
        toyRobotRunner.run("src/test/resources/exampleA.csv");
        assertTrue(capturedOutput.getOut().contains("0,1,NORTH"));
    }

    @Test
    void testRun_whenRunWithExampleB_shouldReturnExpectedResult(CapturedOutput capturedOutput) throws FileNotFoundException {
        toyRobotRunner.run("src/test/resources/exampleB.csv");
        assertTrue(capturedOutput.getOut().contains("0,0,WEST"));
    }

    @Test
    void testRun_whenRunWithExampleC_shouldReturnExpectedResult(CapturedOutput capturedOutput) throws FileNotFoundException {
        toyRobotRunner.run("src/test/resources/exampleC.csv");
        assertTrue(capturedOutput.getOut().contains("3,3,NORTH"));
    }
}
