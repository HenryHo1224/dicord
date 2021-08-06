package RPG;
public class script {

    private static String[] line_O = new String[100];
    private static String run = new String();
    private static int i = 0;

    public script(){
    }

    public static String opening(){
        run = getline();
        return run;
    }

    public static String getline(){
        line_O[0] = "long long time ago";
        return line_O[i];
    }
}
