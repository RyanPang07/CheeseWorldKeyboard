import java.io.BufferedReader;
import java.io.FileReader;

public class readcsvfile {

    public static void main(String[] args){
        String filename = "molarmass.csv";
        System.out.println(" Read CSV File");

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
