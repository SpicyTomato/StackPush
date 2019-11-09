package com.spicytomato.javadatastrcutrueexperiment_2;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spicytomato.javadatastrcutrueexperiment_2.databinding.FragmentStackSelectBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class StackSelectFragment extends Fragment {


    public StackSelectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_stack_select, container, false);

        MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(requireActivity(),new SavedStateVMFactory(requireActivity())).get(MyViewModel.class);

        FragmentStackSelectBinding binding;
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_stack_select , container , false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.buttonCommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_stackSelectFragment_to_mainFragment);
            }
        });

        binding.buttonCalculaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_stackSelectFragment_to_calculationFragment);
            }
        });

        return binding.getRoot();
    }

}
