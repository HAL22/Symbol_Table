import java.io.*;
import java.util.*;

public class Symbol_Table_Simulator
{
    private String FileName;
    private String outputString;
    private Stack<HashTable> stack;


    public Symbol_Table_Simulator(String fileName)
    {
        this.FileName = fileName;
        outputString = "";

        stack = new Stack<>();
        stack.add(null);

    }


    public String process() throws Exception
    {

        File file = new File(FileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while ((line = br.readLine()) != null)
        {
            option(line);

        }




        return outputString;
    }

    public void option(String line) throws Exception
    {
        String tokens[] = line.split(" ");

        switch (tokens[0])
        {
            case "beginscope":
                beginscope(line);
                break;


            case "endscope":
                endscope(line);
                break;

            case "define":
                define(line,tokens[1],tokens[2]);
                break;


            case "use":
                use(line,tokens[1]);
                break;

            default:
                throw  new Exception("Incorrect option");


        }


    }



    public void beginscope(String line)
    {
        if(stack.peek()==null)
        {
            stack.add(new HashTable());

        }

        else
            {
                stack.add(stack.peek().getCopyHashTable());

            }


        outputString = outputString+line+"\n";
    }

    public void endscope(String line)
    {
        stack.pop();

        outputString = outputString+line+"\n";
    }

    public void define(String line,String Key,String Value) throws Exception
    {
        stack.peek().putValue(Key,Value);

        outputString = outputString+line+"\n";


    }

    public void use(String line,String Key) throws Exception
    {

        if(stack.peek()==null)
        {
            String Value = "undefined";

            outputString = outputString+line+" ="+" "+Value+"\n";

        }

        else
            {
                String Value = stack.peek().get(Key);

                if(Value!=null)
                {
                    outputString = outputString+line+" ="+" "+Value+"\n";

                }
                else
                {
                    Value = "undefined";

                    outputString = outputString+line+" ="+" "+Value+"\n";

                }

            }








    }
}
