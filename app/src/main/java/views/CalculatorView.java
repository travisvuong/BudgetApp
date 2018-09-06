package views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorView extends LinearLayout implements View.OnClickListener{
    Context context;
    String resultText;
    TextView result;

    public CalculatorView(Context context){
        super(context);
        this.context = context;
        resultText = "";
        init();
    }

    public void init(){
        setOrientation(LinearLayout.VERTICAL);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addTextLayout();
        addButtons();
    }

    public void addTextLayout(){
        result = new TextView(context);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        result.setLayoutParams(layoutParams);
        result.setTextSize(0, 50);
        addView(result);
    }

    public void addButtons() {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;

        GridView view = new GridView(context);
        view.setLayoutParams(layoutParams);
        view.setNumColumns(3);
        view.setClickable(true);

        ArrayList<Button> buttons = new ArrayList<>();
        List<String> calculatorValues = Arrays.asList("7", "8", "9",
                "4", "5", "6",
                "1", "2", "3");
        for (String value : calculatorValues) {
            buttons.add(createButton(value));
        }

        ArrayAdapter<Button> adapter = new ArrayAdapter<Button>(context, android.R.layout.simple_list_item_1, buttons) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                return getItem(position);
            }
        };
        view.setAdapter(adapter);
        addView(view);
    }

    private Button createButton(final String val) {
        Button button = new Button(context);
        button.setTextSize(0, 50);
        button.setText(val);
        button.setOnClickListener(onClick -> result.setText(result.getText().toString().concat(val)));
        return button;
    }

    @Override
    public void onClick(View v) {

    }
}
