public class SingleClubMember extends Member{
    private int club;

    //контсруктор
    public SingleClubMember(char memberType, int memberID, String name, double fees, int pClub) {
        super(memberType, memberID, name, fees);
        this.club = pClub;
    }

    //методы
    @Override
    public String toString(){
        String memberInfo = this.getMemberType() + "," + this.getMemberID() + "," + this.getName() +  "," + this.getFees() + "," + this.club;
        return memberInfo;
    }

    //гет/сет
    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }
}
