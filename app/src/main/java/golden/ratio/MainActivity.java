package golden.ratio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final double f = 1.61803;
    double stop = 1;
    String a_show = "", b_show = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText a_text = findViewById(R.id.a);


        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (isDouble((a_text).getText().toString())) {

                    double a = Double.parseDouble((a_text).getText().toString());
                    double b;

                    while (stop >= 0.3) {

                        b = a / f;
                        stop = b;

                        TextView a_arr = findViewById(R.id.a_arr);
                        TextView b_arr = findViewById(R.id.b_arr);

                        a_show = a_show + new DecimalFormat("##.#####").format(a) + "\n";
                        b_show = b_show + new DecimalFormat("##.#####").format(b) + "\n";

                        a_arr.setText(a_show);
                        b_arr.setText(b_show);

                        a = b;
                    }
                    stop = 1;
                    a_show = "";
                    b_show = "";
                }
            }
        });

        a_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    findViewById(R.id.go).performClick();
                }
                return false;
            }
        });

    }

    public boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}


