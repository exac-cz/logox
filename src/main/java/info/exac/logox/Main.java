package info.exac.logox;

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
import java.util.Arrays;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);



    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
        BufferedImage bufferedImage = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        graphics2D.setBackground(Color.WHITE);
        graphics2D.drawRect(100, 100, 200, 200);
        ImageIO.write(bufferedImage, "png", new File("output.png"));


        Options options = new Options();
        options.addOption(new Option("i", "input", true, "Input LGX file"));
        options.addOption(new Option("o", "output", true, "Output PNG file"));

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        logger.info(cmd.getOptionValue("input"));
        logger.info(cmd.getOptionValue("output"));

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("logox", options, true);

        Arrays.stream(args).forEach(logger::info);
    }

}