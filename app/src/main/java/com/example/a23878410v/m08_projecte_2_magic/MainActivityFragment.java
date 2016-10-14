package com.example.a23878410v.m08_projecte_2_magic;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import Magic.Game;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Game game;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("player1_hp", this.game.getPlayer1().getHp());
        outState.putInt("player1_px", this.game.getPlayer1().getPoison());
        outState.putInt("player2_hp", this.game.getPlayer2().getHp());
        outState.putInt("player2_px", this.game.getPlayer2().getPoison());

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_main, container, false);

        MenuItem btnReset = (MenuItem) fragment.findViewById(R.id.action_reset);

        TextView txtPlayer1 = (TextView) fragment.findViewById(R.id.txtPlayer1);
        TextView txtPlayer2 = (TextView) fragment.findViewById(R.id.txtPlayer2);
        ImageButton btnPlayer1_LifeIncrement = (ImageButton) fragment.findViewById(R.id.btnPlayer1_inc_life);
        ImageButton btnPlayer2_LifeIncrement = (ImageButton) fragment.findViewById(R.id.btnPlayer2_inc_life);
        ImageButton btnPlayer1_LifeDecrement = (ImageButton) fragment.findViewById(R.id.btnPlayer1_dec_life);
        ImageButton btnPlayer2_LifeDecrement = (ImageButton) fragment.findViewById(R.id.btnPlayer2_dec_life);

        ImageButton btnPlayer1_StealLife = (ImageButton) fragment.findViewById(R.id.btnPlayer1_StealLife);
        ImageButton btnPlayer2_StealLife = (ImageButton) fragment.findViewById(R.id.btnPlayer2_StealLife);

        Button btnPlayer1_PoisonIncrement = (Button) fragment.findViewById(R.id.btnPlayer1_inc_poison);
        Button btnPlayer1_PoisonDecrement = (Button) fragment.findViewById(R.id.btnPlayer1_dec_poison);
        Button btnPlayer2_PoisonIncrement = (Button) fragment.findViewById(R.id.btnPlayer2_inc_poison);
        Button btnPlayer2_PoisonDecrement = (Button) fragment.findViewById(R.id.btnPlayer2_dec_poison);

        game = new Game(
                btnReset,
                txtPlayer1,
                txtPlayer2,
                btnPlayer1_LifeIncrement,
                btnPlayer2_LifeIncrement,
                btnPlayer1_LifeDecrement,
                btnPlayer2_LifeDecrement,
                btnPlayer1_StealLife,
                btnPlayer2_StealLife,
                btnPlayer1_PoisonIncrement,
                btnPlayer2_PoisonIncrement,
                btnPlayer1_PoisonDecrement,
                btnPlayer2_PoisonDecrement);

        if(savedInstanceState != null){
            this.game.getPlayer1().setHp(savedInstanceState.getInt("player1_hp"));
            this.game.getPlayer1().setPoison(savedInstanceState.getInt("player1_px"));
            this.game.getPlayer2().setHp(savedInstanceState.getInt("player2_hp"));
            this.game.getPlayer2().setPoison(savedInstanceState.getInt("player2_px"));
            this.game.init_txt();
        }

        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reset) {
            final Game gmatrix = this.game;

            Snackbar.make(getView(), R.string.snackbar_text, Snackbar.LENGTH_LONG)
                    .setAction(R.string.snackbar_action, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gmatrix.doReset();
                        }
                    })  // action text on the right side
                    .setDuration(3000).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
