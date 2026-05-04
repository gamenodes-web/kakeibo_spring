package kakeibo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class KakeiboData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sunyuu;
    private int shishutsu;
    private int chokin;
    private LocalDate date;

    public KakeiboData() {}

    public KakeiboData(int sunyuu, int shishutsu, int chokin) {
        this.sunyuu = sunyuu;
        this.shishutsu = shishutsu;
        this.chokin = chokin;
        this.date = LocalDate.now();
    }

    public int getId() { return id; }
    public int getSunyuu() { return sunyuu; }
    public int getShishutsu() { return shishutsu; }
    public int getChokin() { return chokin; }
    public LocalDate getDate() { return date; }
}