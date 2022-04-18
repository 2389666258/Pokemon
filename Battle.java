package Pokemons;

import java.util.Objects;

public class Battle {

//    // test
//    public static void main(String[] args) {
//        Player player1, player2;
//
//        player1 = new Player(new Mail("1@mail.sustech.edu.cn"), new PhoneNumber("1"), "1");
//        player2 = new Player(new Mail("2@mail.sustech.edu.cn"),new PhoneNumber("2"), "2");
//        Skill skill1 = new Skill("skill1", 2, 3);
//        Skill skill2 = new Skill("skill2", 3, 2);
//        Pokemon pokemon1 = new Pokemon("pokemon1", 10, 1, skill1, 1, 1, 3, 3);
//        Pokemon pokemon2 = new Pokemon("pokemon2", 10, 1, skill2, 1, 2, 3, 3);
//        player1.addPokemon(pokemon1);
//        player2.addPokemon(pokemon2);
//
//        Player winner = Battle.tatakai(player1, player2);
//
//        if (winner == null) {
//            System.out.println("Draw");
//        } else {
//            System.out.println(winner.getMail().mail + " wins");
//        }
//
//    }

    public static Player tatakai(Player p1, Player p2) {

        /* --- Pokemon HP --- */

        int[] pi_pok_hp = new int[p1.pokemons.size()];
        for (int i = 0; i < p1.pokemons.size(); i++) {
            pi_pok_hp[i] = p1.pokemons.get(i).getHp();
        }

        int[] p2_pok_hp = new int[p2.pokemons.size()];
        for (int i = 0; i < p2.pokemons.size(); i++) {
            p2_pok_hp[i] = p2.pokemons.get(i).getHp();
        }


        /* --- Battle --- */

        int p1_pok_num = 0;
        int p2_pok_num = 0;

        while (p1_pok_num < p1.pokemons.size() && p2_pok_num < p2.pokemons.size()) {
            // get pokemon
            Pokemon pok1 = p1.pokemons.get(p1_pok_num);
            Pokemon pok2 = p2.pokemons.get(p2_pok_num);

            // who attacks first
            boolean p1Turn = pok2.getSpeed() <= pok1.getSpeed();

            int round = 0;
            int cd = 1;

            while (pok1.getHp() > 0 && pok2.getHp() > 0 && round < 100) {
                if (p1Turn) {
                    if (cd % pok1.skill.getSkillCd() == 0 && !Objects.equals(pok1.skill.getSkillName(), "error")) {
                        pok2.setHp(pok2.getHp() - pok1.skill.getSkillAtk());
                    } else {
                        pok2.setHp(pok2.getHp() - pok1.getAtk());
                    }

                } else {
                    if (cd % pok2.skill.getSkillCd() == 0 && !Objects.equals(pok2.skill.getSkillName(), "error")) {
                        pok1.setHp(pok1.getHp() - pok2.skill.getSkillAtk());
                    } else {
                        pok1.setHp(pok1.getHp() - pok2.getAtk());
                    }
                }

//                // battle blog
//                if (round % 2 == 1) {
//                    System.out.println((round / 2 + 1) + " : 1.hp: " + pok1.getHp() + " 2.hp: " + pok2.getHp());
//                }

                round++;
                if (round % 2 == 0) {
                    cd++;
                }

                p1Turn = !p1Turn;

            } // end of round

            if (round == 100) {
                for (int i = 0; i < p1.pokemons.size(); i++) {
                    p1.pokemons.get(i).setHp(pi_pok_hp[i]);
                }
                for (int i = 0; i < p2.pokemons.size(); i++) {
                    p2.pokemons.get(i).setHp(p2_pok_hp[i]);
                }
                return null;
            }

            if (pok1.getHp() <= 0) {
                p1_pok_num ++;
            } else {
                p2_pok_num ++;
            }

        } // pokemon size

        // return winner
        for (int i = 0; i < p1.pokemons.size(); i++) {
            p1.pokemons.get(i).setHp(pi_pok_hp[i]);
        }
        for (int i = 0; i < p2.pokemons.size(); i++) {
            p2.pokemons.get(i).setHp(p2_pok_hp[i]);
        }
        if (p1_pok_num == p1.pokemons.size())
            return p2;
        else return p1;

    } // tatakai
} // Battle
