package secret.a.game;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    int position;
    int score=0;
    int noq=0;
    TextView sumDisplay;
    TextView timertv;
    ArrayList<Integer> numbers=new ArrayList<Integer>();
    TextView result;
    TextView scoretv;
    Button btn0,btn1,btn2,btn3;
    Button playagainbtn;
    ConstraintLayout layoutt;

    public void playAgain(View view)
    {

        timertv.setText("30s");
        int score=0;
        int noq=0;
        scoretv.setText(score + "/" + noq);
        newQuestion();
        playagainbtn.setVisibility(View.INVISIBLE);
        result.setText("");
        new CountDownTimer (30100,1000)
        {

            @Override
            public void onTick(long l) {

                timertv.setText(String.valueOf(l/1000) + "s");

            }

            @Override
            public void onFinish() {

                timertv.setText("Done!");
                playagainbtn.setVisibility(View.VISIBLE);
            }
        }.start();


    }

    public void start(View view)
    {
        button.setVisibility(View.INVISIBLE);
        playAgain((TextView)findViewById(R.id.textView2));
        layoutt.setVisibility(View.VISIBLE);
    }

    public void choose(View view)
    {

        if(view.getTag().toString().equals(Integer.toString(position)))
        {
            result.setText("Correct!");
            score++;
        }
        else
        {
            result.setText("Wrong:(");
        }
        noq++;
        scoretv.setText(score + "/" + noq);
        newQuestion();

    }

    public void newQuestion()
    {
        Random rand=new Random();

        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        sumDisplay.setText(Integer.toString(a) + "+" + Integer.toString(b));

        position=rand.nextInt(4);

        numbers.clear();

        for(int i=0;i<4;i++)
        {
            if(i==position)
            {
                numbers.add(a+b);
            }
            else
            {
                int wrongans=rand.nextInt(41);
                while (wrongans==a+b)
                {
                    wrongans=rand.nextInt(41);
                }
                numbers.add(wrongans);
            }
        }

        btn0.setText(Integer.toString(numbers.get(0)));
        btn1.setText(Integer.toString(numbers.get(1)));
        btn2.setText(Integer.toString(numbers.get(2)));
        btn3.setText(Integer.toString(numbers.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        sumDisplay=(TextView)findViewById(R.id.textView4);
        timertv=(TextView)findViewById(R.id.textView2);

        btn0=(Button)findViewById(R.id.button0);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        playagainbtn=(Button)findViewById(R.id.button5);

        layoutt=(ConstraintLayout)findViewById(R.id.layoutt);

        result=(TextView)findViewById(R.id.textView);
        scoretv=(TextView)findViewById(R.id.textView3);



        button.setVisibility(View.VISIBLE);
        layoutt.setVisibility(View.INVISIBLE);





    }
}
