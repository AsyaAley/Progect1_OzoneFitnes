public class MultiClubMember extends Member {
    private int membershipPoints;

    //конструктор
    public MultiClubMember(char memberType, int memberID, String name, double fees, int pMembershipPoints) {
        super(memberType, memberID, name, fees);
        this.membershipPoints = pMembershipPoints;
    }

    //методы
    @Override
    public String toString(){
        String memberInfo = this.getMemberType() + "," + this.getMemberID() + "," + this.getName() +  "," + this.getFees() + "," + this.membershipPoints;
        return memberInfo;
    }

    //гет/сет

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }
}
