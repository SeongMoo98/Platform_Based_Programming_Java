public class Club {
    private int ID;
    private String CLUB_NAME;


    public Club(int id, String club_name){
        this.ID = id;
        this.CLUB_NAME=club_name;
    }

    public int getID(){ return ID; }
    public String getCLUB_NAME(){ return CLUB_NAME; }

    @Override
    public String toString(){
        return String.format("%d %s",getID(),getCLUB_NAME());
    }
}
