package Magic;

import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Lluís Bayer Soler on 30/09/16.
 */

public class Player  {

    private int hp;
    private int poison;

    public Player() {
        this.hp = 20;
        this.poison = 0;
    }

    public void incrementHp(){
        this.hp++;
    }

    public void decrementHp(){
        this.hp--;
    }


    public void incrementPoison(){
        this.poison++;
    }

    public void decrementPoison(){
        this.poison--;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }

    public String getString(){
        return hp+"/"+poison;
    }

}
