package kakeibo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class KakeiboData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sunyuu;
    private int shishutsu;
    private int chokin;

    public KakeiboData() {}

    public KakeiboData(int sunyuu, int shishutsu, int chokin) {
        this.sunyuu = sunyuu;
        this.shishutsu = shishutsu;
        this.chokin = chokin;
    }

    public int getId() { return id; }
    public int getSunyuu() { return sunyuu; }
    public int getShishutsu() { return shishutsu; }
    public int getChokin() { return chokin; }
}