package domain;

public class Figuren{

    final Figur type;
    final String team;
    boolean status;

    final int id;



    public Figuren(Figur type, String team, boolean status, int id) {
        this.type = type;
        this.team = team;
        this.status = status;
        this.id = id;
    }

    public Figur getType() {
        return type;
    }

    public String getTeam() {
        return team;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean EqualTeam(Figuren f){
        if(this.team.equals(f.team)){
            return true;
        }
        return false;
    }
}
