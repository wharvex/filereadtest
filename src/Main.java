import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Exception(
          "Please call the program with exactly one argument (the input filename).");
    }
    Path inputFilePath = Paths.get(args[0]);
    Lexer lexer = new Lexer(Files.readAllLines(inputFilePath, StandardCharsets.UTF_8));
    lexer.lex();
  }
}