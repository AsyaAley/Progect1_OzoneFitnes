import java.util.LinkedList;

public class JavaProject {
    public static void main(String[] args) {
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Member> members = fh.readFile();
        int choice = 0;

        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("===============================");
        do {
            choice = mm.getChoice();
            switch (choice) {
                case 1:
                    fh.appendFile(mm.addMembers(members));
                    members = fh.readFile();
                    System.out.println("Member added.");
                    break;
                case 2:
                    mm.removeMember(members);
                    fh.overwriteFile(members);
                    members = fh.readFile();
                    break;
                case 3:
                    mm.printMemberInfo(members);
                    break;
                case -1:
                    System.out.println("THANK YOU FOR USING OZONE FITNESS CENTER.");
                    System.out.println("Glad to see you again!");
                    System.out.println("===================================");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice. Please choose from following values:");
            }
        }while (choice!=-1);
        System.exit(0);
    }
}
