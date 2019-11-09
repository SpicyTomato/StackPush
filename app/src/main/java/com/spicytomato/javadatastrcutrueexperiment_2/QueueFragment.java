package com.spicytomato.javadatastrcutrueexperiment_2;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spicytomato.javadatastrcutrueexperiment_2.databinding.FragmentQueueBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class QueueFragment extends Fragment {


    public QueueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_queue, container, false);

        MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(requireActivity(), new SavedStateVMFactory(requireActivity())).get(MyViewModel.class);

        FragmentQueueBinding binding;
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_queue , container , false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        return binding.getRoot();
    }

}
