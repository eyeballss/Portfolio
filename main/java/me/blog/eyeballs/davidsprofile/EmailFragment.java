package me.blog.eyeballs.davidsprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;

public class EmailFragment extends Fragment {

    private ButtonRectangle sendWithOtherMailAppButton;

    public EmailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
        setListener();
    }

    private void init(){
        sendWithOtherMailAppButton = (ButtonRectangle) getView().findViewById(R.id.sendWithOtherMailAppButton);
    }

    private void setListener(){
        sendWithOtherMailAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Uri uri = Uri.parse("david.changwoolee@gmail.com");
//                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
//                getContext().startActivity(intent);


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"david.changwoolee@gmail.com"});
//                intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"david.changwoolee@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                intent.putExtra(Intent.EXTRA_TEXT, "hi there!");
                intent.setType("text/plain");
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    getActivity().startActivity(Intent.createChooser(intent, "Send Email using:"));
//                    getActivity().startActivity(intent);

                }
                else {
                    Toast.makeText(getActivity(), "You don't have any email apps to contact us.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sendWithOtherMailAppButton=null;
    }
}
