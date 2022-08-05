import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        final String menu = "A - Add, D - Delete, P - Print, Q - Quit";
        boolean done = false;
        String cmd;

        do {
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toLowerCase();

            switch (cmd)
            {
                case "a":
                    list.add(SafeInput.getNonZeroLenString(in, "what would you like to add?"));
                    break;
                case "d":
                    list.remove(SafeInput.getInt(in, "what position would you like to delete?") - 1);
                    break;
                case "p":
                    displayList();
                    break;
                case "q":
                    done = SafeInput.getYNConfirm(in, "are you sure?");
                    break;
            }
            displayListNumbered();
            System.out.println("");
        }
        while (!done);
    }

    private static void displayListNumbered()
    {
        if (list.size() != 0)
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i+1, list.get(i));
                System.out.println("");
            }
        }
        else
        {
            System.out.println("list is empty");
        }
    }

    private static void displayList()
    {
        System.out.println("***********************************");
        if (list.size() != 0)
        {
            for (String s : list) {
                System.out.printf("%35s", s);
                System.out.println("");
            }
        }
        else
        {
            System.out.println("***        list is empty        ***");
        }
        System.out.println("***********************************");
    }
}