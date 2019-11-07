package com.spicytomato.javadatastrcutrueexperiment_2;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spicytomato.javadatastrcutrueexperiment_2.databinding.FragmentPushBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class PushFragment extends Fragment {


    public PushFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_push, container, false);

        final MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(requireActivity(),new SavedStateVMFactory(requireActivity())).get(MyViewModel.class);

        final FragmentPushBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.id.pushFragment,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_pushFragment_to_mainFragment);
            }
        });

        binding.buttonCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0 ; i < binding.editTextPushText.getText().length() ; i++){
                    myViewModel.getStackHead().getValue().StackPush(binding.editTextPushText.getText().charAt(i));
                    binding.textViewHint.setText("入栈成功" + i+1);
                }
            }
        });


        return binding.getRoot();
    }

}
