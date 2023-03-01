package domain;

public class Figuren{

    Figur type;
    String team;
    boolean status;

    int id;



    public Figuren(Figur type, String team, boolean status, int id) {
        this.type = type;
        this.team = team;
        this.status = status;
        this.id = id;
    }

    public Figur getType() {
        return type;
    }

    public void setType(Figur type) {
        this.type = type;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
