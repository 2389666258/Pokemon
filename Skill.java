package Pokemons;

public class Skill {
    private String name;
    private int cd;
    private int atk;

    public Skill(String name, int cd, int atk) {
        this.name = name;
        this.cd = cd;
        this.atk = atk;
        if (cd <= 0 || atk <= 0) {
            this.name = "error";
            this.cd = 51;
            this.atk = 0;
        }
    }

    public String getSkillName() {
        return name;
    }

    public int getSkillCd() {
        return cd;
    }

    public int getSkillAtk() {
        return atk;
    }
}
