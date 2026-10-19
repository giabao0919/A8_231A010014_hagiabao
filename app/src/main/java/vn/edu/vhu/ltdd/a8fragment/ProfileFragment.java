package vn.edu.vhu.ltdd.a8fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private static final String KEY_TEN = "key_ten";
    private static final String KEY_MSSV = "key_mssv";

    public static ProfileFragment newInstance(String ten, String mssv) {
        ProfileFragment f = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(KEY_TEN, ten);
        args.putString(KEY_MSSV, mssv);
        f.setArguments(args);
        return f;
    }

    /** Cách gọn hơn: truyền layout vào constructor của Fragment, khỏi viết onCreateView. */
    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        String ten = (args != null) ? args.getString(KEY_TEN, "Hà Gia Bảo") : "Hà Gia Bảo";
        String mssv = (args != null) ? args.getString(KEY_MSSV, "231A010014") : "231A010014";

        ((TextView) view.findViewById(R.id.tvTen)).setText(ten);
        ((TextView) view.findViewById(R.id.tvMssv)).setText(
                getString(R.string.profile_mssv, mssv));
    }
}