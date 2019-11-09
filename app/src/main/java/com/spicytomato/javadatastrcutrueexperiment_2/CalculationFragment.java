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

import com.spicytomato.javadatastrcutrueexperiment_2.databinding.FragmentCalculationBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculationFragment extends Fragment {


    public CalculationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_calculation, container, false);

        MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(requireActivity(), new SavedStateVMFactory(requireActivity())).get(MyViewModel.class);

        final FragmentCalculationBinding binding;
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_calculation , container , false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_calculationFragment_to_stackSelectFragment2);
            }
        });

        binding.buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculation calculation = new Calculation();
                StringBuffer postFix = calculation.toPostfix(binding.editTextInput.getText().toString());
                binding.textViewValue.setText(String.valueOf(calculation.toValue(postFix)));
            }
        });

        return binding.getRoot();
    }

}
