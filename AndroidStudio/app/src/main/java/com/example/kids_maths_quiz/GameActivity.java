package com.example.kids_maths_quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {


    TextView txtQuestion, txtScore, txtTimer, txtQuestionNum, txtLevelNum;
    EditText editTxtAnswer;
    Button btnCheckAnswer;

    GameEngine game = new GameEngine();

    int score = 0;
    int questionNum = 0;
    int timeLimit = 0;

    CountDownTimer timer;
    MediaPlayer correctSound, wrongSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);


        txtQuestion = findViewById(R.id.txtQuestion);
        txtScore = findViewById(R.id.txtScore);
        editTxtAnswer = findViewById(R.id.editTxtAnswer);
        btnCheckAnswer = findViewById(R.id.btnCheckAnswer);
        txtTimer = findViewById(R.id.txtTimer);
        txtQuestionNum = findViewById(R.id.txtQuestionNum);
        txtLevelNum = findViewById(R.id.txtLevelNum);

        correctSound = MediaPlayer.create(this, R.raw.correct);
        wrongSound = MediaPlayer.create(this, R.raw.wrong);

        newQuestion();

        btnCheckAnswer.setOnClickListener(v -> checkAnswer());

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(GameActivity.this, LevelSelectorMenue.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void newQuestion() {

        if(questionNum >= 10) {
            txtQuestion.setText("Game finished! Your score: " + score);
            btnCheckAnswer.setEnabled(false);
            return;
        }

        game.genQuestion();
        txtQuestion.setText(game.question);

        questionNum ++;
        txtQuestionNum.setText(questionNum + "/10");

        setTimer();
    }

    void checkAnswer() {

        String ans = editTxtAnswer.getText().toString();

        if(ans.isEmpty()) return;

        int userAns = Integer.parseInt(ans);

        if(userAns == game.correctAns) {

            score ++;
            correctSound.start();
            newQuestion();
            txtScore.setText("Score: " + score);
        } else{
            wrongSound.start();
            newQuestion();
        }
    }

    void setTimer() {

        int level = getIntent().getIntExtra("level", 0);
        txtLevelNum.setText("Level " + level);

        if(level == 0) return;
        if(level == 1) timeLimit = 20000;
        if(level == 2) timeLimit = 10000;

        if(timer != null) {
            timer.cancel();}

        timer = new CountDownTimer(timeLimit, 1000) {

            public void onTick(long millisUnitFinished) {
                txtTimer.setText("Time: " + millisUnitFinished/1000);
            }

            public void onFinish() {
                wrongSound.start();
                newQuestion();
            }
        }.start();
    }
}