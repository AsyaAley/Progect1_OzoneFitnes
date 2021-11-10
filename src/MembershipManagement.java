import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MembershipManagement implements Calculator{
    private Scanner reader = null;

    @Override
    public double calculateFees(int clubID) {
        double fees = 0;
        switch (clubID) {
                case 1:
                    fees  = 900;
                    break;
                case 2:
                    fees  = 950;
                    break;
                case 3:
                    fees  = 1000;
                    break;
                case 4:
                    fees  = 1200;
                    break;
                default:
                    printClubOptions();
                    clubID = getIntInput();
            }
        return fees;
        }

    //методы
    private int getIntInput(){
        int user_input;
        try{
            reader = new Scanner(System.in);
            user_input = reader.nextInt();
        }catch (InputMismatchException e){
            System.out.println("No existing command. Please, re-enter.");
            reader = new Scanner(System.in);
            user_input = reader.nextInt();
        }
        return user_input;
    }

    private void printClubOptions(){
        System.out.println("Please select a club:");
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice(){
        int choice;
        System.out.println();
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println("Please select an option (or Enter -1 to quit):");
        System.out.println();
        choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> m){
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        //Calculator cal;

        //спрашиваем в какой клуб
        do{
            printClubOptions();
            club = getIntInput();
        } while (club<=1 && club>=4);

        //присваиваем идентификатор
        try{
            memberID = m.getLast().getMemberID() +1;
        }catch(NoSuchElementException e){
            memberID = 1;
        }
        //вычисляем взнос
        fees = calculateFees(club);
        //спрашиваем имя посетителя
        System.out.println("Enter member name");
        reader = new Scanner(System.in);
        name = reader.nextLine();

        //создаем члена одного и многих клубов
        if (club == 4){
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
        }
        else {
            mbr = new SingleClubMember('S', memberID, name, fees, club);
        }
        //добавляем члена клуба в список
        m.add(mbr);
        //возвращаем строковое значение члена клуба
        return mbr.toString();
    }

    public void removeMember(LinkedList<Member> m){
        System.out.println("Enter member's ID");
        int memberID = getIntInput();
        String message = "ID does not  exist.";
        for (Member mem:m) {
            if (mem.getMemberID() == memberID){
                m.remove(mem);
                message = "Member deleted.";
                break;
            }
        }
        System.out.println(message);
    }

    public void printMemberInfo(LinkedList<Member> m){
        System.out.println("Enter member's ID");
        int memberID = getIntInput();
        String message = "ID does not  exist.";
        for (Member mem:m) {
            if (mem.getMemberID() == memberID){
                message = "Here is your information";
                System.out.println(mem.toString());
                break;
            }
        }
        System.out.println(message);
    }

}



