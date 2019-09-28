package mtr.multibanking.com.multibanking;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


public class InputValidation {
    private Context context;


    public InputValidation(Context context) {
        this.context = context;
    }


    public boolean isInputEditTextFilled(EditText editText) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            editText.setError("Error! Invalid Data");
            hideKeyboardFrom(editText);
            return false;
        } else {
             editText.setError(null);
        }
        return true;
    }

    public boolean isInputEditTextEmail(EditText editText) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            editText.setError("Invalid Email");
            hideKeyboardFrom(editText);
            return false;
        } else {
            editText.setError(null);
        }
        return true;
    }

    public boolean isInputEditTextMatches(EditText editText1, EditText editText2) {
        String value1 = editText1.getText().toString().trim();
        String value2 = editText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            editText2.setError("Password Not Match");
            hideKeyboardFrom(editText2);
            return false;
        }
        else {
            editText2.setError(null);

        }
        return true;
    }

    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}

