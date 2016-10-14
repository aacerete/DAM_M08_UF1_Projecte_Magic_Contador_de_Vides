package Magic;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Lluís Bayer Soler on 30/09/16.
 */

public class Game {
    private Player player1;
    private Player player2;
    private MenuItem btnReset;
    private TextView txtPlayer1, txtPlayer2;
    private ImageButton btnPlayer1_LifeIncrement, btnPlayer2_LifeIncrement, btnPlayer1_LifeDecrement, btnPlayer2_LifeDecrement, btnPlayer1_StealLife, btnPlayer2_StealLife;
    private Button btnPlayer1_PoisonIncrement, btnPlayer2_PoisonIncrement, btnPlayer1_PoisonDecrement, btnPlayer2_PoisonDecrement;

    final Game matrix;

    public Game(MenuItem btnReset, TextView txt1, TextView txt2,
                ImageButton btnPlayer1_LifeIncrement,
                ImageButton btnPlayer2_LifeIncrement,
                ImageButton btnPlayer1_LifeDecrement,
                ImageButton btnPlayer2_LifeDecrement,
                ImageButton btnPlayer1_StealLife,
                ImageButton btnPlayer2_StealLife,
                Button btnPlayer1_PoisonIncrement,
                Button btnPlayer2_PoisonIncrement,
                Button btnPlayer1_PoisonDecrement,
                Button btnPlayer2_PoisonDecrement) {
        this.btnReset = btnReset;
        this.txtPlayer1 = txt1;
        this.txtPlayer2 = txt2;
        this.btnPlayer1_LifeIncrement = btnPlayer1_LifeIncrement;
        this.btnPlayer2_LifeIncrement = btnPlayer2_LifeIncrement;
        this.btnPlayer1_LifeDecrement = btnPlayer1_LifeDecrement;
        this.btnPlayer2_LifeDecrement = btnPlayer2_LifeDecrement;
        this.btnPlayer1_StealLife = btnPlayer1_StealLife;
        this.btnPlayer2_StealLife = btnPlayer2_StealLife;
        this.btnPlayer1_PoisonIncrement = btnPlayer1_PoisonIncrement;
        this.btnPlayer2_PoisonIncrement = btnPlayer2_PoisonIncrement;
        this.btnPlayer1_PoisonDecrement = btnPlayer1_PoisonDecrement;
        this.btnPlayer2_PoisonDecrement = btnPlayer2_PoisonDecrement;
        this.matrix = this;

        this.doReset();
    }

    private void doInitialization(){
        this.init_txt();
        this.init_button_life();
        this.init_button_poison();
        this.init_button_steal();
    }

    public void doReset() {
        player1 = new Player();
        player2 = new Player();
        this.doInitialization();
    }

    private void init_button_life(){
        btnPlayer1_LifeIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.incrementHp();
                matrix.init_txt();
            }
        });
        btnPlayer1_LifeDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.decrementHp();
                matrix.init_txt();
            }
        });

        btnPlayer2_LifeIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2.incrementHp();
                matrix.init_txt();
            }
        });
        btnPlayer2_LifeDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2.decrementHp();
                matrix.init_txt();
            }
        });
    }

    private void init_button_poison(){
        btnPlayer1_PoisonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.incrementPoison();
                matrix.init_txt();
            }
        });
        btnPlayer1_PoisonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.decrementPoison();
                matrix.init_txt();
            }
        });

        btnPlayer2_PoisonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2.incrementPoison();
                matrix.init_txt();
            }
        });
        btnPlayer2_PoisonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2.decrementPoison();
                matrix.init_txt();
            }
        });
    }

    private void init_button_steal(){
        btnPlayer1_StealLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.incrementHp();
                player2.decrementHp();
                matrix.init_txt();
            }
        });

        btnPlayer2_StealLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2.incrementHp();
                player1.decrementHp();
                matrix.init_txt();
            }
        });
    }

    public void init_txt(){
        txtPlayer1.setText(player1.getString());
        txtPlayer2.setText(player2.getString());
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
