import java.io.*;

public class Reader
{
    public static void main(String[] args) throws IOException
    {
        LazyBinarySearchTree tree = new LazyBinarySearchTree();
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter wr = new BufferedWriter(new FileWriter(args[1]));

        String line;

        while( (line = br.readLine() ) != null) //Regular Expression verification of A-Za-z followed by ':' and then two digits.
        {
            if(line.contains("Insert:"))
            {
                String keyString = line.substring( line.indexOf(':') + 1);
                int key = Integer.parseInt(keyString);

                boolean correct = tree.insert(key);

                if(!tree.ERROR_HOLDER.isEmpty())
                {
                    wr.write(tree.ERROR_HOLDER);
                    wr.newLine();
                    tree.ERROR_HOLDER = "";
                }
                else if(correct)
                {
                    wr.write("True");
                    wr.newLine();
                }
                else
                {
                    wr.write("False");
                    wr.newLine();
                }
            }
            else if(line.contains("Delete:"))
            {
                String keyString = line.substring( line.indexOf(':') + 1);
                int key = Integer.parseInt(keyString);

                boolean correct = tree.delete(key);
                if(!tree.ERROR_HOLDER.isEmpty())
                {
                    wr.write(tree.ERROR_HOLDER);
                    wr.newLine();
                    tree.ERROR_HOLDER = "";
                }
                else if(correct)
                {
                    wr.write("True");
                    wr.newLine();
                }
                else
                {
                    wr.write("False");
                    wr.newLine();
                }
            }
            else if(line.contains("Contains:"))
            {
                String keyString = line.substring( line.indexOf(':') + 1);
                int key = Integer.parseInt(keyString);

                boolean correct = tree.contains(key);
                if(!tree.ERROR_HOLDER.isEmpty())
                {
                    wr.write(tree.ERROR_HOLDER);
                    wr.newLine();
                    tree.ERROR_HOLDER = "";
                }
                else if(correct)
                {
                    wr.write("True");
                    wr.newLine();
                }
                else
                {
                    wr.write("False");
                    wr.newLine();
                }
            }
            else if(line.equals("PrintTree"))
            {
                wr.write(tree.toString());
                wr.newLine();
            }
            else if(line.equals("FindMin"))
            {
                int min = tree.findMin();
                wr.write(Integer.toString(min));
                wr.newLine();
            }
            else if(line.equals("FindMax"))
            {
                int max = tree.findMax();
                wr.write(Integer.toString(max));
                wr.newLine();
            }
            else if(line.equals("Height"))
            {
                int height = tree.height();
                wr.write(Integer.toString(height));
                wr.newLine();
            }
            else if(line.equals("Size"))
            {
                int size = tree.size();
                wr.write(Integer.toString(size));
                wr.newLine();
            }
            else
            {
                wr.write("Error in Line: " + line);
                wr.newLine();
            }
        }
        br.close();
        wr.close();
    }
}
