package info.exac.logox;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

@SpringBootApplication
@Slf4j
public class CliApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(CliApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
        BufferedImage bufferedImage = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        graphics2D.setBackground(Color.WHITE);
        graphics2D.drawRect(100, 100, 200, 200);
        ImageIO.write(bufferedImage, "png", new File("output.png"));

        Options options = new Options();
        Option inputOption = new Option("i", "input", true, "Input LGX file");
        inputOption.setArgName("INPUT_FILE");
        inputOption.setRequired(true);
        options.addOption(inputOption);
        Option outputOption = new Option("o", "output", true, "Output PNG file");
        outputOption.setArgName("OUTPUT_FILE");
        options.addOption(outputOption);
        options.addOption("h", "help", false, "Prints this help");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("help") || cmd.getOptions().length == 0) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("logox", options, true);
            System.exit(0);
        }
    }

}