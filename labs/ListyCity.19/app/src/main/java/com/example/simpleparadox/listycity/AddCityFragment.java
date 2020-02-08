package com.example.simpleparadox.listycity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.Serializable;

public class AddCityFragment extends DialogFragment {
    private EditText cityName;
    private EditText provinceName;
    private OnFragmentInterationListener listener;

    public interface OnFragmentInterationListener {
        void onOkPressed(City newCity);
    }

    static AddCityFragment newInstance(City city){
        Bundle args = new Bundle();
        args.putSerializable("city", city);

        AddCityFragment fragment = new AddCityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof OnFragmentInterationListener) {
            listener = (OnFragmentInterationListener) context;
        }
        else{
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        View view = LayoutInflater.from(getActivity())
                .inflate(R.layout.add_city_fragment_layout, null);
        cityName = view.findViewById(R.id.city_name_editText);
        provinceName = view.findViewById(R.id.province_editText);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final Bundle arg = getArguments();

        return builder
                .setView(view)
                .setTitle("Add city")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String city = cityName.getText().toString();
                        String province = provinceName.getText().toString();

                        City cityedit;
                        if (arg == null){
                            listener.onOkPressed(new City(city, province));

                        }
                        else {
                            cityedit = (City) arg.getSerializable("city");
                            if (cityedit != null){
                                cityedit.setCity(city,province);
                            }
                        }

                    }

                }).create();
    }

}
