package com.animsh.aux_sudokusolver;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9;
    EditText ed11, ed12, ed13, ed14, ed15, ed16, ed17, ed18, ed19;
    EditText ed21, ed22, ed23, ed24, ed25, ed26, ed27, ed28, ed29;
    EditText ed31, ed32, ed33, ed34, ed35, ed36, ed37, ed38, ed39;
    EditText ed41, ed42, ed43, ed44, ed45, ed46, ed47, ed48, ed49;
    EditText ed51, ed52, ed53, ed54, ed55, ed56, ed57, ed58, ed59;
    EditText ed61, ed62, ed63, ed64, ed65, ed66, ed67, ed68, ed69;
    EditText ed71, ed72, ed73, ed74, ed75, ed76, ed77, ed78, ed79;
    EditText ed81, ed82, ed83, ed84, ed85, ed86, ed87, ed88, ed89;
    BottomNavigationView bottomNavigationView;

    int[][] board = new int[9][9];

    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num) {
        for (int d = 0; d < board.length; d++) {
            // if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {
            // if the number we are trying to
            // place is already present in
            // that column, return false;

            if (board[r][col] == num) {
                return false;
            }
        }

        // corresponding square has
        // unique number (box-clash)
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    public static boolean solveSudoku(
            int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    // we still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // no empty space left
        if (isEmpty) {
            return true;
        }

        // else for each-row backtrack
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    // print(board, n);
                    return true;
                } else {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editTextNumber1);
        ed2 = findViewById(R.id.editTextNumber2);
        ed3 = findViewById(R.id.editTextNumber3);
        ed4 = findViewById(R.id.editTextNumber4);
        ed5 = findViewById(R.id.editTextNumber5);
        ed6 = findViewById(R.id.editTextNumber6);
        ed7 = findViewById(R.id.editTextNumber7);
        ed8 = findViewById(R.id.editTextNumber8);
        ed9 = findViewById(R.id.editTextNumber9);

        ed11 = findViewById(R.id.editTextNumber11);
        ed12 = findViewById(R.id.editTextNumber12);
        ed13 = findViewById(R.id.editTextNumber13);
        ed14 = findViewById(R.id.editTextNumber14);
        ed15 = findViewById(R.id.editTextNumber15);
        ed16 = findViewById(R.id.editTextNumber16);
        ed17 = findViewById(R.id.editTextNumber17);
        ed18 = findViewById(R.id.editTextNumber18);
        ed19 = findViewById(R.id.editTextNumber19);

        ed21 = findViewById(R.id.editTextNumber21);
        ed22 = findViewById(R.id.editTextNumber22);
        ed23 = findViewById(R.id.editTextNumber23);
        ed24 = findViewById(R.id.editTextNumber24);
        ed25 = findViewById(R.id.editTextNumber25);
        ed26 = findViewById(R.id.editTextNumber26);
        ed27 = findViewById(R.id.editTextNumber27);
        ed28 = findViewById(R.id.editTextNumber28);
        ed29 = findViewById(R.id.editTextNumber29);

        ed31 = findViewById(R.id.editTextNumber31);
        ed32 = findViewById(R.id.editTextNumber32);
        ed33 = findViewById(R.id.editTextNumber33);
        ed34 = findViewById(R.id.editTextNumber34);
        ed35 = findViewById(R.id.editTextNumber35);
        ed36 = findViewById(R.id.editTextNumber36);
        ed37 = findViewById(R.id.editTextNumber37);
        ed38 = findViewById(R.id.editTextNumber38);
        ed39 = findViewById(R.id.editTextNumber39);

        ed41 = findViewById(R.id.editTextNumber41);
        ed42 = findViewById(R.id.editTextNumber42);
        ed43 = findViewById(R.id.editTextNumber43);
        ed44 = findViewById(R.id.editTextNumber44);
        ed45 = findViewById(R.id.editTextNumber45);
        ed46 = findViewById(R.id.editTextNumber46);
        ed47 = findViewById(R.id.editTextNumber47);
        ed48 = findViewById(R.id.editTextNumber48);
        ed49 = findViewById(R.id.editTextNumber49);

        ed51 = findViewById(R.id.editTextNumber51);
        ed52 = findViewById(R.id.editTextNumber52);
        ed53 = findViewById(R.id.editTextNumber53);
        ed54 = findViewById(R.id.editTextNumber54);
        ed55 = findViewById(R.id.editTextNumber55);
        ed56 = findViewById(R.id.editTextNumber56);
        ed57 = findViewById(R.id.editTextNumber57);
        ed58 = findViewById(R.id.editTextNumber58);
        ed59 = findViewById(R.id.editTextNumber59);

        ed61 = findViewById(R.id.editTextNumber61);
        ed62 = findViewById(R.id.editTextNumber62);
        ed63 = findViewById(R.id.editTextNumber63);
        ed64 = findViewById(R.id.editTextNumber64);
        ed65 = findViewById(R.id.editTextNumber65);
        ed66 = findViewById(R.id.editTextNumber66);
        ed67 = findViewById(R.id.editTextNumber67);
        ed68 = findViewById(R.id.editTextNumber68);
        ed69 = findViewById(R.id.editTextNumber69);

        ed71 = findViewById(R.id.editTextNumber71);
        ed72 = findViewById(R.id.editTextNumber72);
        ed73 = findViewById(R.id.editTextNumber73);
        ed74 = findViewById(R.id.editTextNumber74);
        ed75 = findViewById(R.id.editTextNumber75);
        ed76 = findViewById(R.id.editTextNumber76);
        ed77 = findViewById(R.id.editTextNumber77);
        ed78 = findViewById(R.id.editTextNumber78);
        ed79 = findViewById(R.id.editTextNumber79);

        ed81 = findViewById(R.id.editTextNumber81);
        ed82 = findViewById(R.id.editTextNumber82);
        ed83 = findViewById(R.id.editTextNumber83);
        ed84 = findViewById(R.id.editTextNumber84);
        ed85 = findViewById(R.id.editTextNumber85);
        ed86 = findViewById(R.id.editTextNumber86);
        ed87 = findViewById(R.id.editTextNumber87);
        ed88 = findViewById(R.id.editTextNumber88);
        ed89 = findViewById(R.id.editTextNumber89);

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        EditText[] row0 = {ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9};
        EditText[] row1 = {ed11, ed12, ed13, ed14, ed15, ed16, ed17, ed18, ed19};
        EditText[] row2 = {ed21, ed22, ed23, ed24, ed25, ed26, ed27, ed28, ed29};
        EditText[] row3 = {ed31, ed32, ed33, ed34, ed35, ed36, ed37, ed38, ed39};
        EditText[] row4 = {ed41, ed42, ed43, ed44, ed45, ed46, ed47, ed48, ed49};
        EditText[] row5 = {ed51, ed52, ed53, ed54, ed55, ed56, ed57, ed58, ed59};
        EditText[] row6 = {ed61, ed62, ed63, ed64, ed65, ed66, ed67, ed68, ed69};
        EditText[] row7 = {ed71, ed72, ed73, ed74, ed75, ed76, ed77, ed78, ed79};
        EditText[] row8 = {ed81, ed82, ed83, ed84, ed85, ed86, ed87, ed88, ed89};

        //EditText[][] box = {row0, row1, row2, row3, row4, row5, row6, row7, row8};

        final EditText[][] box = {
                {ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9},
                {ed11, ed12, ed13, ed14, ed15, ed16, ed17, ed18, ed19},
                {ed21, ed22, ed23, ed24, ed25, ed26, ed27, ed28, ed29},
                {ed31, ed32, ed33, ed34, ed35, ed36, ed37, ed38, ed39},
                {ed41, ed42, ed43, ed44, ed45, ed46, ed47, ed48, ed49},
                {ed51, ed52, ed53, ed54, ed55, ed56, ed57, ed58, ed59},
                {ed61, ed62, ed63, ed64, ed65, ed66, ed67, ed68, ed69},
                {ed71, ed72, ed73, ed74, ed75, ed76, ed77, ed78, ed79},
                {ed81, ed82, ed83, ed84, ed85, ed86, ed87, ed88, ed89}
        };


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.btn_reset:
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                box[i][j].setText("");
                            }
                        }
                        Toast.makeText(MainActivity.this, "Reset Successfully !!", Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.btn_solve:
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                if (box[i][j].getText().toString().equals("") || box[i][j].getText().toString().equals(" ")) {
                                    board[i][j] = 0;
                                } else {
                                    board[i][j] = Integer.parseInt(box[i][j].getText().toString());
                                }
                            }
                        }
                        solveSudoku(board, 9);
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                box[i][j].setText(String.valueOf(board[i][j]));
                            }
                        }
                        Toast.makeText(MainActivity.this, "Solved Successfully !!", Toast.LENGTH_LONG).show();
                        Log.e("Board ", "onSolved: " + board.length);
                        return true;

                    case R.id.btn_about:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        ViewGroup viewGroup = findViewById(android.R.id.content);
                        View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.about_dialog, viewGroup, false);
                        builder.setView(dialogView);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        return true;
                }
                return true;
            }
        });


    }

}