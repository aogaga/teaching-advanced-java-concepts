package learningException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ListOfNumbers {

  private static final int SIZE = 10;
  private List<Integer> list;
  private Logger logger;

  public listOfNumbers() {
    this.list = new ArrayList<Integer>(SIZE);
    for (int i = 0; i < SIZE; i++) {
      list.add(new Integer(i));
    }

  }

  public void writeList() {
    PrintWriter out = null;

    try {
      System.out.println("Entered try statement");
      out = new PrintWriter(new FileWriter("outFile.txt"));
      for (int i = 0; i < SIZE; i++) {
        out.print("Value at: " + i + " = " + list.get(i));
      }
    } catch (IndexOutOfBoundsException e) {
      System.err.println("IndexoutofBoundsException" + e.getMessage());
    } catch (IOException e) {
      System.err.print("Caught IOException : " + e.getMessage());
    } finally {
      if (out != null) {
        System.out.println("Closing PrintWriter");
        out.close();
      } else {
        System.out.println("PrintWriter not open");
      }

    }

    out.close();
  }

  public void catchingMoreThanOneException() {
        catch(IOException | SQLException ex){
      logger.log(ex);
      throw ex;
    }
  }


  public String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {

    BufferedReader br = new BufferedReader(new FileReader(path));

    try {
      return br.readLine();
    } finally {
      if (br != null) {
        br.close();
      }
    }
  }


}
