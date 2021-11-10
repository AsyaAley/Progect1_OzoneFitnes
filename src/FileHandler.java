import java.io.*;
import java.util.LinkedList;

public class FileHandler {
    String path = "C:\\Users\\Ася\\IdeaProjects\\Progect1_OzoneFitnes\\Members.txt";

    //методы
    public LinkedList<Member> readFile(){
        String line;
        LinkedList<Member> members = new LinkedList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            line = bufferedReader.readLine();
            while ( line != null){
                String[] param = line.split(",");
                if (param[0].equals("S")) {
                    SingleClubMember memS = new SingleClubMember('S', Integer.parseInt(param[1]), param[2], Double.parseDouble(param[3]), Integer.parseInt(param[4]));
                    members.add(memS);
                }
                else if (param[0].equals("M")) {
                    MultiClubMember memM = new MultiClubMember('M', Integer.parseInt(param[1]), param[2], Double.parseDouble(param[3]), Integer.parseInt(param[4]));
                    members.add(memM);
                }
                line = bufferedReader.readLine();
            };
            bufferedReader.close();
        }catch (IOException ex) {
            System.out.println("Error reading file.");
        }
        return members;
    }
    public void appendFile(String mem){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(mem);
            writer.newLine();
            writer.close();
        }catch (IOException e){
            System.out.println("Error_write");
        }
    }
    public void overwriteFile(LinkedList<Member> m){
        String temp = "C:\\Users\\Ася\\IdeaProjects\\Progect1_OzoneFitnes\\MembersTemp.txt";
        try {
            File nf = new File(temp);
            nf.createNewFile();
        }catch (IOException exp) {
            System.out.println("Error create temp file");
        }
        for (Member mem : m){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(temp, true));
                writer.write(mem.toString());
                writer.newLine();
                writer.close();
            }catch (IOException e){
                System.out.println("Error_write");
            }
        }
        File nf = new File(path);
        if (nf.exists()){
            nf.delete();
        }

        File tempFile = new File(temp);
        if (tempFile.exists()) {
            File nwFile = new File("C:\\Users\\Ася\\IdeaProjects\\Progect1_OzoneFitnes\\Members.txt");
            boolean rename = tempFile.renameTo(nwFile);
            //В переменную path записываем новое название файла(file2.getName()) и его путь(file2.getParent())
            //path = renewFile.getParent() + "//"+renewFile.getName();
            if (!rename){
                System.out.println("error rename");
            }
        }

    }
}