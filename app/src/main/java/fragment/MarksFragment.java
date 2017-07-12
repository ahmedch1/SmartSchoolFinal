package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ahmedchtn.smartschool.MarkItem;
import ahmedchtn.smartschool.R;


public class MarksFragment extends Fragment {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMarksDatabaseReference;
    private String mUsername;
    EditText mMarksEdiText;
    EditText mMarksEdiTextValue;
    Button mSendMarkButton;
    private ChildEventListener mChildEventListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_marks, container, false);


        mUsername = "ANONYMOUS";

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMarksDatabaseReference = mFirebaseDatabase.getReference().child("marks");
        mSendMarkButton = (Button) v.findViewById(R.id.addMark);
        mMarksEdiText = (EditText) v.findViewById(R.id.markEditText);
        mMarksEdiTextValue = (EditText) v.findViewById(R.id.markEditTextValue);
        mSendMarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Send marks on click

                //Add a new Mark with 3 attributes
                MarkItem markItem = new MarkItem(mMarksEdiText.getText().toString(), mUsername, mMarksEdiTextValue.getText().toString(), null);

                mMarksDatabaseReference.push().setValue(markItem);
                //clear input box
                mMarksEdiText.setText("");
                mMarksEdiTextValue.setText("");

            }
        });


        mChildEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // MarkItem markItem=dataSnapshot.getValue(MarkItem.class);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mMarksDatabaseReference.addChildEventListener(mChildEventListener);

        // Inflate the layout for this fragment
        return v;
    }


}
